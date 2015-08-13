package com.hombre.startup;

import java.text.ParseException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.hombre.db.bo.AccountBo;
import com.hombre.db.bo.BookBo;
import com.hombre.db.bo.RoleBo;
import com.hombre.db.bo.UserBo;
import com.hombre.db.model.Account;
import com.hombre.db.model.Book;
import com.hombre.db.model.Role;
import com.hombre.db.model.User;
import com.hombre.security.HashCode;

@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserBo userBo;

    @Autowired
    private BookBo bookBo;

    @Autowired
    private AccountBo accountBo;

    @Autowired
    private RoleBo roleBo;
    
    @Autowired
    private WebApplicationContext context;

//    @Autowired
//    private HashCode hashCode;
      //prototype stejně nefunguje :-/

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {}

    @PostConstruct
    public void init() throws ParseException {
        fillInitialData();
    }

    private void fillInitialData() throws ParseException {
        HashCode hashCode = (HashCode) context.getBean("hashCode");

        User newUser = new User(1, "Ondrej", hashCode.getHashPassword("andrew"), true);
        System.out.println(hashCode.toString());
        userBo.save(newUser);
        roleBo.save(new Role(newUser, "ROLE_ADMIN"));
        bookBo.save(new Book("MyBook1", "My generic book no.1", newUser));
        bookBo.save(new Book("MyBook2", "My generic book no.2", newUser));
        Book book = new Book("MyBook3", "My generic book no.3", newUser);
        bookBo.save(book);
        newUser.setFavoriteBookId(book.getId());
        accountBo.save(new Account("MyAccount1", 111111, 1234567890, 4321, newUser));
        Account account = new Account("MyAccount2", 111112, 1234567891, 4343, newUser);
        accountBo.save(account);
        newUser.setFavoriteAccountId(account.getId());
        newUser.setBirthdate("07-07-1997");
        newUser.setMailFrequency("1");
        userBo.merge(newUser);
        
        HashCode hashCode2 = (HashCode) context.getBean("hashCode");

        newUser = new User(2, "Daniela", hashCode2.getHashPassword("danielle"), true);
        System.out.println(hashCode.toString());
        userBo.save(newUser);
        roleBo.save(new Role(newUser, "ROLE_USER"));
        bookBo.save(new Book("BookOfDanielle1", "Danielle's book no.1", newUser));
        bookBo.save(new Book("BookOfDanielle2", "Danielle's book no.2", newUser));
        accountBo.save(new Account("AccountDanielle1", 222222, 1212121212, 2121, newUser));
        accountBo.save(new Account("AccountDanielle2", 222223, 1212121213, 2121, newUser));
        newUser.setFavoriteAccountId(account.getId());
        newUser.setBirthdate("08-08-1998");
        newUser.setMailFrequency("1");
        userBo.merge(newUser);
        
        HashCode hashCode3 = (HashCode) context.getBean("hashCode");
        System.out.println(hashCode.toString());
        newUser = new User(3, "Jan", hashCode3.getHashPassword("johny"), true);
        userBo.save(newUser);
        roleBo.save(new Role(newUser, "ROLE_USER"));
        bookBo.save(new Book("BookOfJohn1", "John's book no.1", newUser));
        bookBo.save(new Book("BookOfJohn2", "John's book no.2", newUser));
        accountBo.save(new Account("AccountJohn1", 332211, 33445533, 4321, newUser));
        accountBo.save(new Account("AccountJohn2", 112233, 33444455, 4343, newUser));
        newUser.setFavoriteAccountId(account.getId());
        newUser.setBirthdate("09-09-1999");
        newUser.setMailFrequency("7");
        userBo.merge(newUser);

        HashCode hashCode4 = (HashCode) context.getBean("hashCode");
        System.out.println(hashCode.toString());
        newUser = new User(4, "Veronika", hashCode4.getHashPassword("veronica"), true);
        userBo.save(newUser);
        roleBo.save(new Role(newUser, "ROLE_USER"));
        bookBo.save(new Book("BookOfVeronica1", "Veronica's book no.1", newUser));
        bookBo.save(new Book("BookOfVeronica2", "Veronica's book no.2", newUser));
        accountBo.save(new Account("AccountVeronica1", 332233, 33665544, 4321, newUser));
        accountBo.save(new Account("AccountVeronica2", 112211, 19876543, 2121, newUser));
        newUser.setFavoriteAccountId(account.getId());
        newUser.setBirthdate("10-10-2000");
        newUser.setMailFrequency("30");
        userBo.merge(newUser);
    }

}