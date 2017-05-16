package tn.hunterViews.services;

import java.util.List;

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
import tn.hunterViews.business.OfferBusiness;
import tn.hunterViews.business.OfferBusinessRemote;
import tn.hunterViews.domain.Offer;

@Path("/Offers")
public class OfferService {

	@EJB 
    OfferBusiness offerBusiness = new OfferBusiness(); 
	

	
	
	@GET
	@Path("/getOffer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response afficherOffer(){
		return Response.status(Status.OK).entity(offerBusiness.getOffer()).build();
		
	}
	

	@POST()
	@Path("/postOffer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ajouterOffer(Offer offer){
		
		if(offerBusiness.createOffer(offer)==200)
				return Response.status(Status.CREATED).build();
				return Response.status(Status.NOT_FOUND).build();
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteOffer(@PathParam("id") int id) {

		if (offerBusiness.deleteOffer(id) == 200)
		return Response.status(Status.OK).build();
		return Response.status(Status.NOT_FOUND).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOffer(@PathParam("id")int id,Offer offer) {

		int r = offerBusiness.updateOffer(id, offer);

		if (r == 200) {
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.NOT_MODIFIED).build();

	}
	
	
}
