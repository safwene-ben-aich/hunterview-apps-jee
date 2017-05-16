package tn.hunterViews.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.management.Notification;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.hunterViews.domain.Notifications;
import tn.hunterViews.domain.Offer;

/**
 * Session Bean implementation class NotificationBusiness
 */
@Stateless
@LocalBean
public class NotificationBusiness implements NotificationBusinessRemote {

    /**
     * Default constructor. 
     */
    public NotificationBusiness() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Notifications> getNotification() {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget notification = target.path("notificationApi");
		List<Notifications> notifications = notification.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Notifications>>(){}) ;
		cl.close();
		return notifications;
	}
	
	@Override
	public int deleteNotification(int id)  {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/notificationApi/"+id);
		return (target.request().delete().getStatus());
	}

	@Override
	public int createNotification(Notifications notifications) {
		Client cl = ClientBuilder.newClient();
		System.out.println(notifications.getUserid());
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api");
		WebTarget notification = target.path("notificationApi");
		Response resp=notification.request().post(Entity.entity(notifications, MediaType.APPLICATION_JSON));
		return resp.getStatus();
		}

	@Override
	public int updateNotification(int id, Notifications notifications) {
		
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/notificationApi/"+id);
		return (target.request().build("PUT", Entity.entity(notifications, MediaType.APPLICATION_JSON)).invoke().getStatus());
	}
/*
	@Override
	public Notifications findNotificationByID(int id) {
		Client cl = ClientBuilder.newClient();
		WebTarget baseUrl = cl.target("http://pihunterviewsdotnet.mybluemix.net/api/notificationApi/"+id);
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).get();
		Notifications notifications=response.readEntity(Notifications.class);
		
		response.close();
		cl.close();
		return notifications;
	}
	
	*/
	
	
	

}
