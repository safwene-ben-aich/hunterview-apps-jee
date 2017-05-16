package tn.hunterViews.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.hunterViews.domain.Evaluations;
import tn.hunterViews.domain.Offer;

/**
 * Session Bean implementation class EvaluationBusiness
 */
@Stateless
@LocalBean
public class EvaluationBusiness implements EvaluationBusinessRemote {
	@Override
	public List<Evaluations> getEvaluation() {

		Client cl = ClientBuilder.newClient();

		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget ev = target.path("evaluationApi");
		List<Evaluations> evaluations = ev.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Evaluations>>(){}) ;

		
		cl.close();
		return evaluations;
	}
	
	
	@Override
	public int createEvaluation(Evaluations evaluation) {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget evv = target.path("evaluationApi");
		Response resp=evv.request().post(Entity.entity(evaluation, MediaType.APPLICATION_JSON));
				
		return resp.getStatus();
		
	}

	
	@Override
	public int updateEvaluation(int id, Evaluations evaluation) {
	
			Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/evaluationApi/"+id);
			return (target.request().build("PUT", Entity.entity(evaluation, MediaType.APPLICATION_JSON)).invoke().getStatus());
		 
			
	}

    
	@Override
	public int deleteEvaluation(int id)  {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/evaluationApi/"+id);
		return (target.request().delete().getStatus());
	}

	
	/*
	@Override
	public Evaluations findEvaluationById(int id) {
		Client cl = ClientBuilder.newClient();
		WebTarget baseUrl = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/evaluationApi/"+id);
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).get();
		Evaluations eval=response.readEntity(Evaluations.class);
		
		
		
		response.close();
		cl.close();
		return eval;
	}*/
	
}