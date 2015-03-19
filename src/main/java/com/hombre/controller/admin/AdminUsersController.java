package com.hombre.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.hombre.db.bo.UserBo;
import com.hombre.db.model.User;
import com.hombre.security.HashCode;

@Controller
public class AdminUsersController {
		
	@Autowired
    private UserBo userBo;
	
	@Autowired
	private HashCode hashCode;
	
	@RequestMapping(value="admin/adminUsers", method = RequestMethod.GET)
    public ModelAndView listUsers(@ModelAttribute("user") User user) {    	
    	ModelAndView model = new ModelAndView("admin/adminUsers");
    	List<User> usersList = userBo.listUser();    	
    	model.addObject("userslist", usersList);
    	
		return model;
    }
    
    @RequestMapping(value="admin/adminUserDelete", method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute("user") User user) {
    	userBo.delete(user);
		return "redirect:/admin/adminUsers";
    }
	
    @RequestMapping(value="admin/adminUserAddEdit", method = RequestMethod.GET)
	public String initForm(@ModelAttribute("user") User user){
		return "admin/adminUserAddEdit";
	}
	
	@RequestMapping(value="admin/adminUserAddEdit", method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("user") @Valid User user, BindingResult result, SessionStatus status) {
 	
		if (result.hasErrors()) {
			System.out.print("Je tam chyba");
			return "admin/adminUserAddEdit";
		} else {
			status.setComplete();
			
			if(user.getUserid()==-1) {
				user.setPassword(hashCode.getHashPassword(user.getPassword()));
				userBo.save(user);
			} else {
				user.setPassword(hashCode.getHashPassword(user.getPassword()));
				userBo.update(user);
			}
			return "redirect:/admin/adminUsers";
		}
	}
	
}
