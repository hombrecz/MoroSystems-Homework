package com.hombre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hombre.db.bo.UserBo;
import com.hombre.db.model.User;

@Controller
@RequestMapping(value = "/users")
public class UsersViewController {

	@Autowired
	private UserBo userBo;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listUsers(@ModelAttribute("user") User user) {
		ModelAndView model = new ModelAndView("users");
		List<User> usersList = userBo.listUser();

		model.addObject("userslist", usersList);
		return model;
	}

}
