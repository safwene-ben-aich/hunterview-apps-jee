package tn.hunterViews.business;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.management.Notification;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.hunterViews.domain.User;

/**
 * Session Bean implementation class FormationBusiness
 */
@Stateless
@LocalBean
public class UserBusiness implements UserBusinessRemote {

    /**
     * Default constructor. 
     */
    public UserBusiness() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<User> getUsers() {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget user = target.path("userApi");
		List<User> users = user.request(MediaType.APPLICATION_JSON).get(new GenericType<List<User>>(){}) ;
		cl.close();
		return users;
	}
	
	@Override
	public int deleteUser(int id)  {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/userApi/"+id);
		return (target.request().delete().getStatus());
	}

	@Override
	public int createUser(User user) {
		Client cl = ClientBuilder.newClient();
		System.out.println(user.getId());
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget users = target.path("userApi");
		Response resp=users.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
		return resp.getStatus();
		}

	@Override
	public int updateUser(int id, User user) {
		
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/userApi/"+id);
		return (target.request().build("PUT", Entity.entity(user, MediaType.APPLICATION_JSON)).invoke().getStatus());
	}

	/*@Override
	public User findUserByID(int id) {
		Client cl = ClientBuilder.newClient();
		WebTarget baseUrl = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/userApi/"+id);
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).get();
		User users=response.readEntity(User.class);
		
		response.close();
		cl.close();
		return users;
	}
	*/
	

	
	
	

}
