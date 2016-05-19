package com.rimitech.sgr.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rimitech.sgr.models.Structure;
import com.rimitech.sgr.models.Users;
import com.rimitech.sgr.services.StructureServiceImpl;

@Controller

@RequestMapping(value="structure")

public class StructureController {
	
	   @Autowired
	   StructureServiceImpl	structureService;
	   	@PreAuthorize("hasAuthority('ADMIND')")
		@RequestMapping(method=RequestMethod.GET)
		public ModelAndView	 index()
	    {
			
			return	new ModelAndView("structure/list","structures",structureService.findAll());
	    }

	    /**
	     * Show the form for creating a new resource.
	     *
	     * @return Response
	     */
		
		@RequestMapping(value="/add",method=RequestMethod.GET)
	    public	ModelAndView  create(ModelAndView	mv)
	    {
			mv.setViewName("structure/add");
			mv.addObject("structure",new Structure());
			mv.addObject("admin",new Users());
	    	return	mv;
	    }
		

	    /**
	     * Store a newly created resource in storage.
	     *
	     * @return Response
	     */
		@RequestMapping(value="/add",method=RequestMethod.POST)
	    public ModelAndView store(@ModelAttribute("structure") Structure structure,
	    		@ModelAttribute("admin") Users admin)
	    {
			structureService.add(structure, admin);
			return	new ModelAndView("redirect:/structure");
	    }

	    /**
	     * Display the specified resource.
	     *
	     * @param  int  
	     * @return Response
	     */
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
	    public ModelAndView show(@PathVariable("id") Long id,ModelAndView	mv)
	    {
			//structureService
			mv.setViewName("structure/detail");
			mv.addObject("structure",structureService.findOne(id));
	    	return	mv;//	new ModelAndView(,"id",id);
	    }

	    /**
	     * Show the form for editing the specified resource.
	     *
	     * @param  int  
	     * @return Response
	     */
		@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	    public ModelAndView edit(@PathVariable("id") Long id,ModelAndView	mv)
	    {
			mv.setViewName("structure/edit");
			mv.addObject("structure",structureService.findOne(id));
			
	    	return	mv;
	    }
		
		@RequestMapping(value="/edit",method=RequestMethod.POST)
	    public ModelAndView update(@ModelAttribute("structure") Structure structure)
	    {
			structureService.update(structure);
			
			
			
	    	return	new ModelAndView("redirect:/structure");
	    }

	   

	    /**
	     * Remove the specified resource from storage.
	     *
	     * @param  int  
	     * @return Response
	     */
		@RequestMapping(value="/supp/{id}",method=RequestMethod.GET)
	    public ModelAndView destroy(@PathVariable("id") Long id)
	    {
			//structureService.delete(id);
			structureService.delete(id);
	    	return	new ModelAndView("redirect:/structure");
	    	
	    }
		


}
