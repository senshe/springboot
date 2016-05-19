package com.rimitech.sgr.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rimitech.sgr.dto.SuiviDto;
import com.rimitech.sgr.models.Suivi;
import com.rimitech.sgr.security.Account;
import com.rimitech.sgr.services.SuiviService;


@RestController
@Controller
@RequestMapping(value="suiviapi")
public class SuiviRestApi {

	@Autowired
	SuiviService suivis;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
    public ResponseEntity<SuiviDto> store(@RequestBody SuiviDto dto	)
    {
		
		//System.out.println(dto.);
		suivis.create(dto);
		//EquipementService.add(equipement, idstructure);
		return	new ResponseEntity<SuiviDto>(dto,HttpStatus.OK);
    }
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
    public ResponseEntity<String> get()
    {
		
		
		return	new ResponseEntity<String>("hahaaaaaaaay l7amdoulilah",HttpStatus.OK);
    }
	
	@RequestMapping(method=RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity<String> getALL()
    {
		
		JSONArray featureList = new JSONArray();
		JSONObject type=new JSONObject();
	//	JSONObject path=new JSONObject();
	//	path.put("", value);
	//	{"geometry":{"coordinates":,"type":"Point"},"type":"Feature","properties":""}
		
	     for (Suivi  obj : suivis.findAll()) {
	    	
	            featureList.put(obj.getJson());
	        }
	     type.put("type", "FeatureCollection")
				.put("features", featureList);
				
		//EquipementService.add(equipement, idstructure);
		return	new ResponseEntity<String>(type.toString(),HttpStatus.OK);
    }
	
	@RequestMapping(value="/{num}",method=RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity<String> track(@PathVariable("num") String num)
    {
		
		JSONArray featureList = new JSONArray();
		JSONObject type=new JSONObject();
            featureList.put(suivis.findLastPosistionByNum(num).getJson());
            type.put("type", "FeatureCollection")
			.put("features", featureList);
				

		return	new ResponseEntity<String>(type.toString(),HttpStatus.OK);
    }
	
	@RequestMapping(value="/get/{matricule}",method=RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity<String> get(@PathVariable("matricule") String matricule)
    {
		
		return	new ResponseEntity<String>(suivis.findLastPosistionByMatricule(matricule).getJson().toString(),HttpStatus.OK);
    }
	
	@RequestMapping(value="/get",method=RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity<String> last(Authentication auth)
    {
		Account   c= (Account) auth.getPrincipal();
		
		
		//return	new ResponseEntity<String>();
		JSONArray featureList = new JSONArray();
		JSONObject type=new JSONObject();
	     for (Suivi  obj : suivis.findLastPosistions(c.getUser().getStructure())) {
	            featureList.put(obj.getJson());
	        }
	     type.put("type", "FeatureCollection")
				.put("features", featureList);
				
		//EquipementService.add(equipement, idstructure);
		return	new ResponseEntity<String>(type.toString(),HttpStatus.OK);
    }
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
    public String test()
    {
		SuiviDto dto=new SuiviDto();
		dto.setAltitude((float) 27.2000);
	//	dto.setDateTime(new Date("26/04/16 23:14:52"));
		dto.setDescr("bla bla");
		dto.setEta("0");
		dto.setExpediteur("33152081");
		dto.setLat("14.684230");
		dto.setLon("-17.458164");
		dto.setVitess((float)0.2408);
		
		suivis.create(dto);
		//EquipementService.add(equipement, idstructure);
		return	"ok";
    }
}














