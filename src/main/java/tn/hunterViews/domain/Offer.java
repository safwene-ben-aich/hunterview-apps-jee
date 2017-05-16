package tn.hunterViews.domain;

import java.util.Date;

public class Offer {

	private int id;
	private String Image ;
	private Date dateEnd ;
	private Date dateStart;
	private String description;
	private String title ;
	private String typeOffer ;
	private int seen ;
	private boolean state ;
	private double salary;
	private User user;
	private Post posts;
	private Evaluations evaluations;

	
	public Post getPosts() {
		return posts;
	}
	public void setPosts(Post posts) {
		this.posts = posts;
	}
	public Evaluations getEvaluations() {
		return evaluations;
	}
	public void setEvaluations(Evaluations evaluations) {
		this.evaluations = evaluations;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTypeOffer() {
		return typeOffer;
	}
	public void setTypeOffer(String typeOffer) {
		this.typeOffer = typeOffer;
	}
	public int getSeen() {
		return seen;
	}
	public void setSeen(int seen) {
		this.seen = seen;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Offer(String image, Date dateEnd, Date dateStart, String description, String title, String typeOffer,
			int seen, boolean state, double salary, User user, Post posts, Evaluations evaluations) {
		super();
		
		Image = image;
		this.dateEnd = dateEnd;
		this.dateStart = dateStart;
		this.description = description;
		this.title = title;
		this.typeOffer = typeOffer;
		this.seen = seen;
		this.state = state;
	 	this.salary = salary;
	 	this.user = user;
	 	this.posts = posts;
	 	this.evaluations = evaluations;
	}
	
	public Offer(int id,String image, Date dateEnd, Date dateStart, String description, String title, String typeOffer,
			int seen, boolean state, double salary, User user, Post posts, Evaluations evaluations) {
		super();
		
		Image = image;
		this.id=id;
		this.dateEnd = dateEnd;
		this.dateStart = dateStart;
		this.description = description;
		this.title = title;
		this.typeOffer = typeOffer;
		this.seen = seen;
		this.state = state;
	 	this.salary = salary;
	 	this.user = user;
	 	this.posts = posts;
	 	this.evaluations = evaluations;
	}
	public Offer() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	

	
}
