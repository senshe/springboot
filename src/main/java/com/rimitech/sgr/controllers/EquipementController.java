


package com.rimitech.sgr.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rimitech.sgr.models.Equipement;
import com.rimitech.sgr.models.Structure;
import com.rimitech.sgr.models.Users;
import com.rimitech.sgr.services.EquipementServiceImpl;
import com.rimitech.sgr.services.StructureServiceImpl;

@Controller
@RequestMapping(value="equipement")
public class EquipementController {
	
	   @Autowired
	   EquipementServiceImpl	EquipementService;
	   
	   @Autowired
	   StructureServiceImpl structures;
	   
		@RequestMapping(method=RequestMethod.GET)
		public ModelAndView	 index()
	    {
			
			return	new ModelAndView("equipement/list","equipements",EquipementService.findAll());
	    }

	    /**
	     * Show the form for creating a new resource.
	     *
	     * @return Response
	     */
		@RequestMapping(value="/add",method=RequestMethod.GET)
	    public	ModelAndView  create(ModelAndView	mv)
	    {
			
			mv.setViewName("equipement/add");
			mv.addObject("equipement",new Equipement());
			mv.addObject("idstructure", new Long(0));
			mv.addObject("structures",structures.findAll());
	    	return	mv;
	    }
		
		

		@RequestMapping(value="/add",method=RequestMethod.POST)
	    public ModelAndView store(@ModelAttribute("equipement") Equipement equipement,
	    		@ModelAttribute("idstructure") long idstructure)
	    {
			EquipementService.add(equipement, idstructure);
			return	new ModelAndView("redirect:/equipement");
	    }
		
		
		@RequestMapping(value="/{num}",method=RequestMethod.GET)
	    public ModelAndView show(@PathVariable("num") String num,ModelAndView	mv)
	    {
			//structureService
			mv.setViewName("equipement/detail");
			mv.addObject("equipement",EquipementService.findOne(num));
	    	return	mv;
	    }

	    /**
	     * Show the form for editing the specified resource.
	     *
	     * @param  int  
	     * @return Response
	     */
		@RequestMapping(value="/edit/{num}",method=RequestMethod.GET)
	    public ModelAndView edit(@PathVariable("num") String num,ModelAndView	mv)
	    {
			mv.setViewName("equipement/edit");
			mv.addObject("equipement",EquipementService.findOne(num));
			
	    	return	mv;
	    }
		
		@RequestMapping(value="/edit",method=RequestMethod.POST)
	    public ModelAndView update(@ModelAttribute("equipement")Equipement equipement)
	    {
			EquipementService.update(equipement);
			
			
			
	    	return	new ModelAndView("redirect:/equipement");
	    }

	   

	    /**
	     * Remove the specified resource from storage.
	     *
	     * @param  int  
	     * @return Response
	     */
		@RequestMapping(value="/supp/{id}",method=RequestMethod.GET)
	    public ModelAndView destroy(@PathVariable("id") String id)
	    {
			//structureService.delete(id);
			EquipementService.delete(id);
	    	return	new ModelAndView("redirect:/equipement");
	    	
	    }
		
		
		
		}
