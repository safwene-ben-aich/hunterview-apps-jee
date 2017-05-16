package tn.hunterViews.business;

import java.util.List;

import javax.ejb.Remote;

import tn.hunterViews.domain.Offer;

@Remote
public interface OfferBusinessRemote {

	public List<Offer> getOffer();

	int createOffer(Offer offer);

	int updateOffer(int id, Offer offer);

	int deleteOffer(int id);

	//Offer findOfferById(int id);

}
