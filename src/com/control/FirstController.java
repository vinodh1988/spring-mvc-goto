package com.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.Person;
import com.model.PersonDAO;
import com.model.PersonList;
import com.utils.ApplicationVariables;
import com.utils.SessionVariables;
import com.utils.TestAspect;
import com.utils.ValidationUtil;

@Controller
public class FirstController {
@Autowired
PersonDAO dao;
@Autowired
Person person;
@Autowired
TestAspect aspect;
@Autowired
SessionVariables session;
@Autowired
ApplicationVariables application;

@Autowired
ValidationUtil validation;

@Autowired
PersonList personList;

@InitBinder
   protected void initBinder(WebDataBinder binder) {
      binder.addValidators(validation);
   }

	@RequestMapping("/first.htm")
	public String emit(ModelMap m){
		System.out.println("Change reflecting");
		System.out.println("Winning...!!!!");
		m.addAttribute("sessionrequest",session.getAppRequests());
		m.addAttribute("applicationrequest", application.getAppRequests());
		m.addAttribute("sessionhash",session.toString());
		m.addAttribute("applicationhash",application.toString());
		return "home";
	}
	
	@RequestMapping("/tab.htm")
	public String tabular(ModelMap m){
		m.addAttribute("plist",dao.getPeople());
		return "tab";
	}
	
	@RequestMapping("/form.htm")
	public ModelAndView getForm()
	{
		System.out.println("It is working");
		return new ModelAndView("form","person",person);
	}
	
	@RequestMapping(value="/store.htm",method=RequestMethod.POST)
	public String storePerson(@ModelAttribute("person")@Validated Person person,BindingResult result)
	{
		System.out.println("Reflecting changes for validation");
		if(result.hasErrors())
			return "form";
		if(dao.addPerson(person))
		return "home";
		return "fail";
	}
	
	@RequestMapping("/person.do")
	public @ResponseBody PersonList getPerson(){
		personList.setPersonList(dao.getPeople());
		return personList;
	}
	
	@RequestMapping(value="/json",headers="Accept=application/json",  produces="application/json")
	public @ResponseBody List<Person> emitJson(){
		return dao.getPeople();
	}
}
