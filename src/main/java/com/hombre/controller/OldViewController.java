package com.hombre.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hombre.db.bo.UserBo;

@Controller
public class OldViewController {

	@Autowired
	private UserBo userBo;

	@RequestMapping(value = "/oldView", method = RequestMethod.POST)
	public ModelAndView getdata() {

		String mystring = getString();
		Date mydate = getDate();
		List<String> mylist = getList();
		HashMap<String, Double> myhmap = getHashMap();

		ModelAndView model = new ModelAndView("oldView");

		model.addObject("string", mystring);
		model.addObject("date", mydate);
		model.addObject("lists", mylist);
		model.addObject("hashmaps", myhmap);

		return model;

	}

	private String getString() {
		return "This is the string!";
	}

	private Date getDate() {
		Date date = new Date();
		return date;
	}

	private List<String> getList() {
		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");
		return list;
	}

	private HashMap<String, Double> getHashMap() {
		HashMap<String, Double> hmap = new HashMap<String, Double>();
		hmap.put("HM_data_1", new Double(111.22));
		hmap.put("HM_data_2", new Double(222.33));
		hmap.put("HM_data_3", new Double(333.44));
		hmap.put("HM_data_4", new Double(0.111));
		hmap.put("HM_data_5", new Double(-111.222));
		return hmap;
	}

}