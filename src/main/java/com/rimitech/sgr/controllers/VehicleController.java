package com.rimitech.sgr.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rimitech.sgr.dao.StructureRepository;
import com.rimitech.sgr.models.Users;
import com.rimitech.sgr.models.Vehicle;
import com.rimitech.sgr.security.Account;
import com.rimitech.sgr.services.EquipementServiceImpl;
import com.rimitech.sgr.services.VehicleServiceImpl;

@Controller
@RequestMapping(value="objet")
public class VehicleController {
	
	   @Autowired
	   VehicleServiceImpl	vehicleService;
	   @Autowired
	   EquipementServiceImpl	equipementService;
	
		@RequestMapping(method=RequestMethod.GET)
		public ModelAndView	 index()
	    {
			
			return	new ModelAndView("objet/list","vehicles",vehicleService.findAll());
	    }

	    /**
	     * Show the form for creating a new resource.
	     *
	     * @return Response
	     */
		@RequestMapping(value="/add",method=RequestMethod.GET)
	    public	ModelAndView  create(ModelAndView	mv,Authentication auth)
	    {
			Account c = (Account) auth.getPrincipal();
			
		System.out.println(c.getUser().getStructure().getNom());
			mv.setViewName("objet/add");
			mv.addObject("vehicle",new Vehicle());
			mv.addObject("equipements",equipementService.findByEta(c.getUser().getStructure(),"DISPO"));
	    	return	mv;
	    }
		

	    /**
	     * Store a newly created resource in storage.
	     *
	     * @return Response
	     */
		@RequestMapping(value="/add",method=RequestMethod.POST)
	    public ModelAndView store(@ModelAttribute("vehicle") Vehicle vehicle,
	    		@ModelAttribute("idequipement") String idequipement)
	    {
			vehicleService.add(vehicle,idequipement);
			return	new ModelAndView("redirect:/objet");
	    }

	    /**
	     * Display the specified resource.
	     *
	     * @param  int  
	     * @return Response
	     */
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
	    public ModelAndView show(@PathVariable("id") String id,ModelAndView	mv)
	    {
			//vehicleService
			mv.setViewName("objet/detail");
			mv.addObject("vehicle",vehicleService.findOne(id));
	    	return	mv;//	new ModelAndView(,"id",id);
	    }

	    /**
	     * Show the form for editing the specified resource.
	     *
	     * @param  int  
	     * @return Response
	     */
		@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	    public ModelAndView edit(@PathVariable("id") String id,ModelAndView	mv)
	    {
			mv.setViewName("objet/edit");
			mv.addObject("vehicle",vehicleService.findOne(id));
			
	    	return	mv;
	    }
		
		@RequestMapping(value="/edit",method=RequestMethod.POST)
	    public ModelAndView update(@ModelAttribute("vehicle") Vehicle vehicle)
	    {
			//vehicleService.update(vehicle);
			
			
			
	    	return	new ModelAndView("redirect:/objet");
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
			//vehicleService.delete(id);
			vehicleService.delete(id);
	    	return	new ModelAndView("redirect:/objet");
	    	
	    }
		@RequestMapping(value="/track/{id}",method=RequestMethod.GET)
	    public ModelAndView track(@PathVariable("id") String id,ModelAndView	mv)
	    {
			mv.setViewName("track");
			mv.addObject("idObjet",id);
			
	    	return	mv;
	    	
	    }
		@RequestMapping(value="/track",method=RequestMethod.GET)
	    public ModelAndView tracks(@PathVariable("id") String id,ModelAndView	mv)
	    {
			mv.setViewName("track");
			mv.addObject("idObjet",id);
			
	    	return	mv;
	    	
	    }
		


}
