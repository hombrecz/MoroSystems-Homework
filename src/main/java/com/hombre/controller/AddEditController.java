package com.hombre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.hombre.db.bo.UserBo;
import com.hombre.db.model.User;
import com.hombre.security.HashCode;

@Controller
@RequestMapping("/addedit")
public class AddEditController {

	@Autowired
	private UserBo userBo;

	@Autowired
	private HashCode hashCode;

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(@ModelAttribute("user") User user) {
		return "addedit";
	}

	@RequestMapping(value = "/addedit", method = RequestMethod.POST)
	public String onSubmit(@Valid @ModelAttribute("user") User user,
			BindingResult result, SessionStatus status) {
		System.out.println(result);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());

		if (result.hasErrors()) {
			System.out.print("Je tam chyba!");
			return "addedit";
		} else {
			status.setComplete();

			if (user.getUserid() == -1) {
				user.setPassword(hashCode.getHashPassword(user.getPassword()));
				userBo.save(user);
			} else {
				user.setPassword(hashCode.getHashPassword(user.getPassword()));
				userBo.update(user);
			}

			return "redirect:/users";
		}
	}

}
