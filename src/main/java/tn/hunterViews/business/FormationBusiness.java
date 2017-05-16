package tn.hunterViews.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.management.Notification;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.hunterViews.domain.Formations;

/**
 * Session Bean implementation class FormationBusiness
 */
@Stateless
@LocalBean
public class FormationBusiness implements FormationBusinessRemote {

    /**
     * Default constructor. 
     */
    public FormationBusiness() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Formations> getFormations() {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget formation = target.path("formationApi");
		List<Formations> formations = formation.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Formations>>(){}) ;
		cl.close();
		return formations;
	}
	
	@Override
	public int deleteFormation(int id)  {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/formationApi/"+id);
		return (target.request().delete().getStatus());
	}

	@Override
	public int createFormation(Formations formations) {
		Client cl = ClientBuilder.newClient();
		System.out.println(formations.getId());
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget formation = target.path("formationApi");
		Response resp=formation.request().post(Entity.entity(formations, MediaType.APPLICATION_JSON));
		return resp.getStatus();
		}

	@Override
	public int updateFormation(int id, Formations formations) {
		
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/formationApi/"+id);
		return (target.request().build("PUT", Entity.entity(formations, MediaType.APPLICATION_JSON)).invoke().getStatus());
	}
/*
	@Override
	public Formations findFormationByID(int id) {
		Client cl = ClientBuilder.newClient();
		WebTarget baseUrl = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/formationApi/"+id);
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).get();
		Formations formations=response.readEntity(Formations.class);
		
		response.close();
		cl.close();
		return formations;
	}
	
	*/
	
	
	

}
