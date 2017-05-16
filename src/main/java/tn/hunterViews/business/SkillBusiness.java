package tn.hunterViews.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.hunterViews.domain.Skill;
/**
 * Session Bean implementation class OfferBusiness
 */
@Stateless
public class SkillBusiness implements SkillBusinessRemote {

	@Override
	public List<Skill> getSkills() {

		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget sk = target.path("skillApi");
		List<Skill> skills = sk.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Skill>>(){}) ;

		cl.close();
		return skills;
	}
	
	
	@Override
	public int createSkill(Skill skill) {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget sk = target.path("skillApi");
		Response resp=sk.request().post(Entity.entity(skill, MediaType.APPLICATION_JSON));
		//System.out.println(off.get);
		
		
		
		return resp.getStatus();
		
	}

	
	@Override
	public int updateSkill(int id, Skill skill) {
	
			Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/skillApi/"+id);
			return (target.request().build("PUT", Entity.entity(skill, MediaType.APPLICATION_JSON)).invoke().getStatus());
		 
			
	}

    
	@Override
	public int deleteSkill(int id)  {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/skillApi/"+id);
		return (target.request().delete().getStatus());
	}

	

/*
	@Override
	public Skill findSkillById(int id) {
		Client cl = ClientBuilder.newClient();
		WebTarget baseUrl = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/skillApi/"+id);
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).get();
		Skill skill=response.readEntity(Skill.class);
		
		
		
		response.close();
		cl.close();
		return skill;
	}*/


	
}
