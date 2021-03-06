package tn.hunterViews.domain;

import java.util.Date;
import javax.persistence.Entity;

/**
 * Formations generated by hbm2java
 */
@Entity
public class Formations{

	private Integer id;
	private User user;
	private Date dateEnd;
	private Date dateStart;
	private String ecole;

	public Formations() {
	}

	public Formations(Date dateEnd, Date dateStart, String ecole) {
		this.dateEnd = dateEnd;
		this.dateStart = dateStart;
		this.ecole = ecole;
	}

	public Formations(User user, Date dateEnd, Date dateStart, String ecole) {
		this.user = user;
		this.dateEnd = dateEnd;
		this.dateStart = dateStart;
		this.ecole = ecole;
	}

public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

		public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Date getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public String getEcole() {
		return this.ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

}
