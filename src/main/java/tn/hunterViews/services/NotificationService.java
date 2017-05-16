package tn.hunterViews.services;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBs;
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
import tn.hunterViews.business.NotificationBusiness;
import tn.hunterViews.business.NotificationBusinessRemote;
import tn.hunterViews.domain.Notifications;;



@Path("/Notifications")
public class NotificationService {
	
	@EJB
	NotificationBusiness notificationBusiness = new NotificationBusiness();
	
	@GET
	@Path("/getNotifications")
	@Produces(MediaType.APPLICATION_JSON)
	public Response afficherNotification(){
		return Response.status(Status.OK).entity(notificationBusiness.getNotification()).build();
	}
	
	
	@POST()
	@Path("/postNotifications")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ajouterNotification(Notifications notifications){
		if (notificationBusiness.createNotification(notifications) == 200)
			return Response.status(Status.CREATED).build();
			return Response.status(Status.NOT_FOUND).build();
	}
	
	
	
	
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteNotification(@PathParam("id") int id) {
	
			if (notificationBusiness.deleteNotification(id) == 200)
				return Response.status(Status.OK).build();
				return Response.status(Status.NOT_FOUND).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateNotification(@PathParam("id")int id, Notifications notifications){
		int response = notificationBusiness.updateNotification(id, notifications);
		if (response == 200)
			return Response.status(Status.OK).build();
			return Response.status(Status.NOT_MODIFIED).build();
	}
	
	
	
}










