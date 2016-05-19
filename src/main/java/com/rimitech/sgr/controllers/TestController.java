package com.rimitech.sgr.controllers;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rimitech.sgr.dao.StructureRepository;
import com.rimitech.sgr.dao.SuiviRepository;
import com.rimitech.sgr.models.Equipement;
import com.rimitech.sgr.models.Suivi;
import com.rimitech.sgr.models.Users;
import com.rimitech.sgr.services.EquipementServiceImpl;
import com.rimitech.sgr.services.UsersServiceImpl;



@RestController
public class TestController {

	

	@Autowired
	SuiviRepository suivi;
	
	@Autowired
	 MessageSource messageSource;
	
		@SuppressWarnings("deprecation")
		@RequestMapping(value="/test",method=RequestMethod.GET)
	    public	ModelAndView index(ModelAndView	mv) 
    {
	
			Date d=new Date("05/03/2016 15:45:25");
			Date a=new Date("05/03/2016 17:14:19");

			List<Suivi> ss=suivi.findByMatricule_MatriculeAndDateTimeBetweenOrderByDateTimeDesc("DK-8490-AM",d,a);
			if(ss.isEmpty()){
				System.out.println("--");
				}else{
					System.out.println("-_-");
					System.out.println(ss.size());
				}
			
//			Users u=users.findOne("0317132092");
//			users.addRoleToUser(u,"ADMINS");
			
		//	List<Equipement> qs=repo.findByEta(srepo.findOne((long) 1), "D");
		//	System.out.print(messageSource.getMessage("hello.content", null, Locale.US));
	    	return	new ModelAndView("tracks");
	    }
		@RequestMapping(value="/data",method=RequestMethod.GET)
		public ResponseEntity<String> getALL()
	    {
			
			JSONArray featureList = new JSONArray();
			JSONObject type=new JSONObject();
		//	JSONObject path=new JSONObject();
		//	path.put("", value);
		//	{"geometry":{"coordinates":,"type":"Point"},"type":"Feature","properties":""}
			Date d=new Date("05/03/2016 15:45:25");
			Date a=new Date("05/03/2016 16:50:25");
		
			List<Suivi> ss=suivi.findByMatricule_MatriculeAndDateTimeBetweenOrderByDateTimeDesc("DK-8490-AM",d,a);
		     for (Suivi  obj : ss) {
		    	
		            featureList.put(obj.getJson());
		        }
		     type.put("type", "FeatureCollection")
					.put("features", featureList);
					
			//EquipementService.add(equipement, idstructure);
			return	new ResponseEntity<String>(type.toString(),HttpStatus.OK);
	    }
		
		@RequestMapping(value="/map",method=RequestMethod.GET)
		public ModelAndView get()
	    {return new ModelAndView("test");
	    }
		
		

}
