package com.rimitech.sgr.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value="/")
public class HomeController {
	
		
		@RequestMapping(method=RequestMethod.GET)
	    public	ModelAndView map(ModelAndView	mv) 
    {
	    	return	new ModelAndView("index");
	    }
		
		@RequestMapping(value="/login",method=RequestMethod.GET)
	    public	ModelAndView login(ModelAndView	mv) 
    {
	    	return	new ModelAndView("login");
	    }

}
