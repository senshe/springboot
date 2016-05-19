package com.rimitech.sgr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rimitech.sgr.models.Equipement;
import com.rimitech.sgr.models.Users;
import com.rimitech.sgr.security.Account;
import com.rimitech.sgr.services.RoleServiceImpl;
import com.rimitech.sgr.services.UsersServiceImpl;
@Controller
@RequestMapping(value="user")
public class UsersConroller {
	   @Autowired
	   UsersServiceImpl	usersService;
	
	   @Autowired
	   RoleServiceImpl roles;
		@RequestMapping(method=RequestMethod.GET)
		public ModelAndView	 index()
	    {
			
			return	new ModelAndView("user/list","users",usersService.findAll());
	    }

	
		 
			@RequestMapping(value="/add",method=RequestMethod.GET)
		    public	ModelAndView  create(ModelAndView	mv)
		    {
				mv.setViewName("user/add");
				mv.addObject("user",new Users());
		    	return	mv;
		    }
			

			@RequestMapping(value="/add",method=RequestMethod.POST)
		    public ModelAndView store(@ModelAttribute("user") Users user,Authentication auth)
		    {
				Account c = (Account) auth.getPrincipal();
		    
				user.setStructure(c.getUser().getStructure());
				usersService.add(user,"USER");
				return	new ModelAndView("redirect:/user");
		    }
			
			
			@RequestMapping(value="/{nni}",method=RequestMethod.GET)
		    public ModelAndView show(@PathVariable("nni") String id,ModelAndView	mv)
		    {
				//structureService
				mv.setViewName("user/detail");
				mv.addObject("user",usersService.findOne(id));
		    	return	mv;
		    }

		    /**
		     * Show the form for editing the specified resource.
		     *
		     * @param  int  
		     * @return Response
		     */
			@RequestMapping(value="/edit/{nni}",method=RequestMethod.GET)
		    public ModelAndView edit(@PathVariable("nni") String nni,ModelAndView	mv)
		    {
				mv.setViewName("user/edit");
				mv.addObject("user",usersService.findOne(nni));
				
		    	return	mv;
		    }
			
			@RequestMapping(value="/edit",method=RequestMethod.POST)
		    public ModelAndView update(@ModelAttribute("user")Users users)
		    {
				usersService.update(users);
				
				
				
		    	return	new ModelAndView("redirect:/user");
		    }

		   

		    /**
		     * Remove the specified resource from storage.
		     *
		     * @param  int  
		     * @return Response
		     */
			@RequestMapping(value="/supp/{nni}",method=RequestMethod.GET)
		    public ModelAndView destroy(@PathVariable("nni") String nni)
		    {
				//structureService.delete(id);
				usersService.delete(nni);
		    	return	new ModelAndView("redirect:/user");
		    	
		    }
			
}

