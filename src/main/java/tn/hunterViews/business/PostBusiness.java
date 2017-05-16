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

import tn.hunterViews.domain.Post;

/**
 * Session Bean implementation class OfferBusiness
 */
@Stateless
public class PostBusiness implements PostBusinessRemote {

	@Override
	public List<Post> getPosts() {

		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget ps = target.path("postApi");
		List<Post> posts = ps.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Post>>(){}) ;

		cl.close();
		return posts;
	}
	
	
	@Override
	public int createPost(Post post) {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget ps = target.path("postApi");
		Response resp=ps.request().post(Entity.entity(post, MediaType.APPLICATION_JSON));
		//System.out.println(off.get);
		
		
		
		return resp.getStatus();
		
	}

	
	@Override
	public int updatePost(int id, Post post) {
	
			Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/postApi/"+id);
			return (target.request().build("PUT", Entity.entity(post, MediaType.APPLICATION_JSON)).invoke().getStatus());
		 
			
	}

    
	@Override
	public int deletePost(int id)  {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/postApi/"+id);
		return (target.request().delete().getStatus());
	}

	

/*
	@Override
	public Post findPostById(int id) {
		Client cl = ClientBuilder.newClient();
		WebTarget baseUrl = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/postApi/"+id);
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).get();
		Post post=response.readEntity(Post.class);
		
		
		
		response.close();
		cl.close();
		return post;
	}
*/

	
}
