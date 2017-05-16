package tn.hunterViews.business;

import java.util.List;

import javax.ejb.Remote;
import javax.management.Notification;

import tn.hunterViews.domain.Notifications;
import tn.hunterViews.domain.Offer;

@Remote
public interface NotificationBusinessRemote {
	public List<Notifications> getNotification();
	int deleteNotification(int id);
	public int createNotification(Notifications notifications);
	int updateNotification(int id, Notifications notifications);
	//Notifications findNotificationByID(int id);
	
	
	
}
