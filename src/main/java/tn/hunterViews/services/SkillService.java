package tn.hunterViews.services;

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
import tn.hunterViews.business.SkillBusiness;
import tn.hunterViews.domain.Skill;

@Path("/Skills")
public class SkillService {

	@EJB 
    SkillBusiness skillBusiness = new SkillBusiness(); 
	

	
	
	@GET
	@Path("/getSkills")
	@Produces(MediaType.APPLICATION_JSON)
	public Response afficherSkill(){
		return Response.status(Status.OK).entity(skillBusiness.getSkills()).build();
		
	}
	
	

	@POST()
	@Path("/postSkill")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ajouterSkill(Skill skill){
		
		if(skillBusiness.createSkill(skill)==200)
				return Response.status(Status.CREATED).build();
				return Response.status(Status.NOT_FOUND).build();
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteSkill(@PathParam("id") int id) {

		if (skillBusiness.deleteSkill(id) == 200)
		return Response.status(Status.OK).build();
		return Response.status(Status.NOT_FOUND).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSkill(@PathParam("id")int id,Skill skill) {

		int r = skillBusiness.updateSkill(id, skill);

		if (r == 200) {
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.NOT_MODIFIED).build();

	}
	
	
}
