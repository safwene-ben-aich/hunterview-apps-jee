package tn.hunterViews.services;


import tn.hunterViews.business.CertificationBusinessRemote;
import tn.hunterViews.business.CertificationBusiness;
import tn.hunterViews.domain.Certification;
import tn.hunterViews.domain.Offer;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/Certifications")
public class CertificationService {
	@EJB 
    CertificationBusiness certificationBusiness = new CertificationBusiness(); 
	
	@GET
	@Path("/getCertification")
	@Produces(MediaType.APPLICATION_JSON)
	public Response afficherCertification(){
		return Response.status(Status.OK).entity(certificationBusiness.getCertification()).build();
		
	}
	
	@POST()
	@Path("/postCertif")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ajouterCertif(Certification certification){
		
		if(certificationBusiness.createCertification(certification)==200)
				return Response.status(Status.CREATED).build();
		 return Response.status(Status.NOT_FOUND).build();
	}


	

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteCertification(@PathParam("id") int id) {

		if (certificationBusiness.deleteCertification(id) == 200)
		return Response.status(Status.OK).build();
		return Response.status(Status.NOT_FOUND).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCertification(@PathParam("id")int id,Certification Certification) {

		int r = certificationBusiness.updateCertification(id, Certification);

		if (r == 200) {
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.NOT_MODIFIED).build();

	}

}
