package org.sid.web;

import org.sid.dao.MatchDAO;
import org.sid.entities.Match;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchRestService   {

	private MatchDAO matchDAO = MatchDAO.getInstance();
	
	@RequestMapping (value="/matchs/{id}",method=RequestMethod.GET)
	public String getMatch(@PathVariable Long id){
		return matchDAO.getMatch(id) ;
	}
	
	@RequestMapping (value="/names/{nom}",method=RequestMethod.GET)
	public String getByName(@PathVariable String nom){
		return matchDAO.getByName(nom);
	}
	
	@RequestMapping (value="/matchs",method=RequestMethod.GET)
	public String getMatchs(){
		return matchDAO.getMatchEnCoursList();
	}
	
	@RequestMapping (value="/matchs", consumes = "application/json",method=RequestMethod.POST)
	public  void save(@RequestBody Match m){
		 matchDAO.createMatch(m);
	}
}
