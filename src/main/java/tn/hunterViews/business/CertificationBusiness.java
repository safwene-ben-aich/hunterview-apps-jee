package tn.hunterViews.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;


import tn.hunterViews.domain.Certification;
import tn.hunterViews.domain.Offer;

/**
 * Session Bean implementation class CertificationBusiness
 */
@Stateless
@LocalBean
public class CertificationBusiness implements CertificationBusinessRemote {

    /**
     * Default constructor. 
     */
	@Override
	public List<Certification> getCertification() {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget off = target.path("certificationApi");
		List<Certification> certifications = off.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Certification>>(){}) ;
		cl.close();
		return certifications;
	}
	
	
	
	

	@Override
	public int createCertification(Certification certification) {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget off = target.path("certificationApi");
		Response resp=off.request().post(Entity.entity(certification, MediaType.APPLICATION_JSON));
				
		return resp.getStatus();
		
	}
	
	
	@Override
	public int updateCertification(int id, Certification certification) {
	
			Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/certificationApi/"+id);
			return (target.request().build("PUT", Entity.entity(certification, MediaType.APPLICATION_JSON)).invoke().getStatus());		 		
	}
    
	@Override
	public int deleteCertification(int id)  {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/certificationApi/"+id);
		return (target.request().delete().getStatus());
	}
/*
	@Override
	public Certification findCertificationById(int id) {
		Client cl = ClientBuilder.newClient();
		WebTarget baseUrl = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/certificationApi/"+id);
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).get();
		Certification certification=response.readEntity(Certification.class);
		response.close();
		cl.close();
		return certification;
	}


*/
	
}
