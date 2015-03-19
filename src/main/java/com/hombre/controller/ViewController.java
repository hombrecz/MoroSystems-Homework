package com.hombre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hombre.db.bo.UserBo;
import com.hombre.db.model.User;

@Controller
public class ViewController {
	
	@Autowired
    private UserBo userBo;
	
	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public ModelAndView getdata(int userID) {

		ModelAndView model = new ModelAndView("view");

		User queriedUser = userBo.getUserById(userID);
		if (queriedUser!=null) {
			model.addObject("user", queriedUser);
			model.addObject("status", "ok");
		} else {
			model.addObject("status", "null");
		}

		return model;
	}
		
}