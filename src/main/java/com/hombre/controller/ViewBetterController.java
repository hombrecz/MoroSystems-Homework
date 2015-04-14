package com.hombre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hombre.db.bo.UserBo;
import com.hombre.db.model.User;

@Controller
public class ViewBetterController {

	@Autowired
	private UserBo userBo;

	@RequestMapping(value = "/viewBetter", method = RequestMethod.POST)
	public ModelAndView getdata(int userId) {
		ModelAndView model = new ModelAndView("viewBetter");

		User queriedUser = userBo.getUserById(userId);
		if (queriedUser != null) {
			model.addObject("user", queriedUser);
			model.addObject("status", "ok");
		} else {
			model.addObject("status", "null");
		}

		return model;
	}

}