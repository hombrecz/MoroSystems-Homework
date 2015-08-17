package com.hombre.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.hombre.db.bo.AccountBo;
import com.hombre.db.bo.BookBo;
import com.hombre.db.bo.UserBo;
import com.hombre.db.model.Account;
import com.hombre.db.model.Book;
import com.hombre.db.model.User;
import com.hombre.mailservice.ApplicationMailer;
import com.hombre.propertyeditor.AccountEditor;
import com.hombre.propertyeditor.BookEditor;

import freemarker.template.TemplateException;

@Controller
public class AdminUserDetailController {

    @Autowired
    private ServletContext servletContext;
    
    @Autowired
    private BookBo bookBo;

    @Autowired
    private AccountBo accountBo;

    @Autowired
    private UserBo userBo;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Book.class, new BookEditor(bookBo));
        dataBinder.registerCustomEditor(Account.class, new AccountEditor(accountBo));
    }

    @RequestMapping(value = "admin/adminUserDetail", method = RequestMethod.GET)
    public ModelAndView listDetails(@ModelAttribute("user") User user, @ModelAttribute("book") Book book,
            @ModelAttribute("account") Account account) {
        ModelAndView model = new ModelAndView("admin/adminUserDetail");

        int userid = user.getUserid();

        List<Book> books = userBo.getUserById(userid).getBooks();
        model.addObject("books", books);
        List<Account> accounts = userBo.getUserById(userid).getAccounts();
        model.addObject("accounts", accounts);
        return model;

    }

    @RequestMapping(value = "admin/adminUserDetailDeleteBook", method = RequestMethod.POST)
    public String deleteBook(@ModelAttribute("user") User user, @ModelAttribute("book") Book book,
            @ModelAttribute("account") Account account) {
        bookBo.delete(book);
        return "redirect:/admin/adminUserDetail?userid=" + book.getUser().getUserid() + "&username=" + book.getUser().getUsername()
                + "&enabled=" + book.getUser().getEnabled();
    }

    @RequestMapping(value = "admin/adminUserDetailDeleteAccount", method = RequestMethod.POST)
    public String deleteAccount(@ModelAttribute("user") User user, @ModelAttribute("book") Book book,
            @ModelAttribute("account") Account account) {
        accountBo.delete(account);
        return "redirect:/admin/adminUserDetail?userid=" + account.getUser().getUserid() + "&username=" + account.getUser().getUsername()
                + "&enabled=" + account.getUser().getEnabled();
    }

    @RequestMapping(value = "admin/adminUserDetailAddEditBook", method = RequestMethod.GET)
    public String initForm(@ModelAttribute("book") Book book) {
        return "admin/adminUserDetailAddEditBook";
    }

    @Test
    @RequestMapping(value = "admin/adminUserDetailAddEditBook", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("book") @Valid Book book, @ModelAttribute("user") User user, BindingResult result, SessionStatus status) {
        bookBo.merge(book);
        return "redirect:/admin/adminUserDetail?userid=" + book.getUser().getUserid() + "&username=" + book.getUser().getUsername()
                + "&enabled=" + book.getUser().getEnabled();
    }

    @RequestMapping(value = "admin/adminUserDetailAddEditAccount", method = RequestMethod.GET)
    public String initForm(@ModelAttribute("account") Account account) {
        return "admin/adminUserDetailAddEditAccount";
    }

    @Test
    @RequestMapping(value = "admin/adminUserDetailAddEditAccount", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("account") @Valid Account account, BindingResult result, SessionStatus status) {
        accountBo.merge(account);

        return "redirect:/admin/adminUserDetail?userid=" + account.getUser().getUserid() + "&username=" + account.getUser().getUsername()
                + "&enabled=" + account.getUser().getEnabled();
    }

    @RequestMapping(value = "admin/adminUserFavoriteBook", method = RequestMethod.POST)
    public String favoriteBook(@ModelAttribute("user") User user) {
        User updated_user = userBo.getUserById(user.getUserid());
        updated_user.setFavoriteBookId(user.getFavoriteBookId());
        userBo.merge(updated_user);
        return "redirect:/admin/adminUserDetail?userid=" + updated_user.getUserid() + "&username=" + updated_user.getUsername()
                + "&enabled=" + updated_user.getEnabled();
    }

    @RequestMapping(value = "admin/adminUserFavoriteAccount", method = RequestMethod.POST)
    public String favoriteAccount(@ModelAttribute("user") User user) {
        User updated_user = userBo.getUserById(user.getUserid());
        updated_user.setFavoriteAccountId(user.getFavoriteAccountId());
        userBo.merge(updated_user);
        return "redirect:/admin/adminUserDetail?userid=" + updated_user.getUserid() + "&username=" + updated_user.getUsername()
                + "&enabled=" + updated_user.getEnabled();
    }

    @RequestMapping(value = "admin/adminUserDetailAddBook", method = RequestMethod.GET)
    public String addBook(@ModelAttribute("user") User user) {
        bookBo.save(new Book("Book Title", "Book Description", userBo.getUserById(user.getUserid())));
        List<Book> helpbooks = userBo.getUserById(user.getUserid()).getBooks();
        int help = helpbooks.get(0).getId();
        return "redirect:/admin/adminUserDetailAddEditBook?id=" + help + "&title=Book Title&description=Book Description&user.userid="
                + user.getUserid();

    }

    @RequestMapping(value = "admin/adminUserDetailAddAccount", method = RequestMethod.GET)
    public String addAccount(@ModelAttribute("user") User user) {
        accountBo.save(new Account("Account name", 123456, 1234567890, 1234, userBo.getUserById(user.getUserid())));
        List<Account> helpaccounts = userBo.getUserById(user.getUserid()).getAccounts();
        int help = helpaccounts.get(0).getId();
        return "redirect:/admin/adminUserDetailAddEditAccount?id=" + help
                + "&name=Account name&accountPrefix=123456&accountNumber=1234567890&bankCode=1234&user.userid=" + user.getUserid();
    }

    @RequestMapping(value = "admin/adminUserDetailSendBookList", method = RequestMethod.POST)
    public String  sendBookList (@ModelAttribute("user") User user) throws IOException, TemplateException{
        int userid = user.getUserid();
        user = userBo.getUserById(userid);
        
        ApplicationMailer.sendMail(user, servletContext);
             
        return "redirect:/admin/adminUserDetail?userid=" + user.getUserid() + "&username=" + user.getUsername()
                + "&enabled=" + user.getEnabled();
    }

}
