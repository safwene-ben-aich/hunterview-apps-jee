package tn.hunterViews.business;

import java.util.List;

import javax.ejb.Remote;

import tn.hunterViews.domain.Certification;

@Remote
public interface CertificationBusinessRemote {
	
	public List<Certification> getCertification();

	int createCertification(Certification certification);

	int updateCertification(int id, Certification certification);

	int deleteCertification(int id);

	//Certification findCertificationById(int id);


}
