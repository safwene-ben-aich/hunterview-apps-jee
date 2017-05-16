package tn.hunterViews.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import tn.hunterViews.domain.Offer;
/**
 * Session Bean implementation class OfferBusiness
 */
@Stateless
public class OfferBusiness implements OfferBusinessRemote {

	@Override
	public List<Offer> getOffer() {

		Client cl = ClientBuilder.newClient();

		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget off = target.path("offerApi");
		List<Offer> offers = off.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Offer>>(){}) ;

		
		cl.close();
		return offers;
	}
	
	
	@Override
	public int createOffer(Offer offer) {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget off = target.path("offerApi");
		Response resp=off.request().post(Entity.entity(offer, MediaType.APPLICATION_JSON));
				
		return resp.getStatus();
		
	}

	
	@Override
	public int updateOffer(int id, Offer offer) {
	
			Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/offerApi/"+id);
			return (target.request().build("PUT", Entity.entity(offer, MediaType.APPLICATION_JSON)).invoke().getStatus());
		 
			
	}

    
	@Override
	public int deleteOffer(int id)  {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/offerApi/"+id);
		return (target.request().delete().getStatus());
	}

	
	
	

/*

	@Override
	public Offer findOfferById(int id) {
		Client cl = ClientBuilder.newClient();
		WebTarget baseUrl = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/offerApi/"+id);
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).get();
		Offer offer=response.readEntity(Offer.class);
		
		
		
		response.close();
		cl.close();
		return offer;
	}

*/
	
}
