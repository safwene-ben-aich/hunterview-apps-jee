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
import tn.hunterViews.business.PostBusiness;
import tn.hunterViews.domain.Post;

@Path("/Post")
public class PostService {

	@EJB 
    PostBusiness postBusiness = new PostBusiness(); 
	
	

	
	
	@GET
	@Path("/getPost")
	@Produces(MediaType.APPLICATION_JSON)
	public Response afficherPost(){
		return Response.status(Status.OK).entity(postBusiness.getPosts()).build();
		
	}
	
	

	@POST()
	@Path("/postPost")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ajouterPost(Post post){
		
		if(postBusiness.createPost(post)==200)
				return Response.status(Status.CREATED).build();
				return Response.status(Status.NOT_FOUND).build();
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeletePost(@PathParam("id") int id) {

		if (postBusiness.deletePost(id) == 200)
		return Response.status(Status.OK).build();
		return Response.status(Status.NOT_FOUND).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePost(@PathParam("id")int id,Post post) {

		int r = postBusiness.updatePost(id, post);

		if (r == 200) {
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.NOT_MODIFIED).build();

	}
	
	
}
