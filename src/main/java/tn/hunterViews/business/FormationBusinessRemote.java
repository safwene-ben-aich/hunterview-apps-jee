package tn.hunterViews.business;

import java.util.List;

import javax.ejb.Remote;
import javax.management.Notification;

import tn.hunterViews.domain.Formations;

@Remote
public interface FormationBusinessRemote {
	public List<Formations> getFormations();
	int deleteFormation(int id);
	public int createFormation(Formations formation);
	int updateFormation(int id, Formations formation);
	//Formations findFormationByID(int id);
	
	
	
}
