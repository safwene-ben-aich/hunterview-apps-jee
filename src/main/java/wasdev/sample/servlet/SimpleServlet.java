package wasdev.sample.servlet;

import java.util.Date;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.management.Notification;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.hunterViews.business.CertificationBusiness;
import tn.hunterViews.business.FormationBusiness;
import tn.hunterViews.business.NotificationBusiness;
import tn.hunterViews.business.OfferBusiness;
import tn.hunterViews.business.PostBusiness;
import tn.hunterViews.business.SkillBusiness;
import tn.hunterViews.domain.Certification;
import tn.hunterViews.domain.Formations;
import tn.hunterViews.domain.Notifications;
import tn.hunterViews.domain.Offer;
import tn.hunterViews.domain.Post;
import tn.hunterViews.domain.Skill;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    
    
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().print("Hello World!");

		SkillBusiness SkBs = new SkillBusiness();
		PostBusiness PsBs = new PostBusiness();

		FormationBusiness forBusiness = new FormationBusiness();
        
        
        System.out.println("BEGIN !!!!!!!!");
        
        System.out.println("******* Offer*******");
         OfferBusiness offerBusiness = new OfferBusiness(); 
        
         System.out.println("******* findOfferById*******");

        Offer offerToFind = new Offer();
       // System.out.println(offerBusiness.findOfferById(42).getId());
        
        System.out.println("******* offerToUpdate*******");
      
        Offer offerToUpdate = new Offer(42,"/image/image",null,null,"test description","SALUT ","Web",1,true,200,null,null,null);
        System.out.println(offerBusiness.updateOffer(42, offerToUpdate));
        
        
        System.out.println("*******offerToAdd*******");

        Offer offerToAdd = new Offer("/image/image",null,null,"test description","test title","Web",1,true,200,null,null,null);  
        System.out.println(offerBusiness.createOffer(offerToAdd));
        
        System.out.println("*******offerDeleted*******");


        System.out.println(offerBusiness.deleteOffer(5));
        
        
        
        System.out.println("*******List<Offer>*******");

        
        List<Offer> nott =  offerBusiness.getOffer();
        
        for (int i=0 ; i<nott.size(); i++){ 
        	System.out.println(nott.get(i));
        }
           
     
        System.out.println("***********Notification**********");
 
        NotificationBusiness notificationBusiness = new NotificationBusiness();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		do {
			System.out.println("Veuillez entrer votre choix : \n"+
					"1 : Afficher la liste des notifications\n"+
					"2 : Ajouter une notification\n"+
					"3 : Modifier une notification\n"+
					"4 : Supprimer une notification\n"+
					"5 : Quitter ");
			String test = reader.readLine();
			choice = Integer.parseInt(test);
			
			switch (choice) {
			case 1:
					afficherNotifications(notificationBusiness);
				break;
			case 2:
					Notifications notificationsToAdd = new Notifications();
					System.out.println("Veuillez donner la date de la notification :");
					notificationsToAdd.setDate(reader.readLine());
					System.out.println("Veuillez donner le type de la notification :");
					notificationsToAdd.setType(Integer.parseInt(reader.readLine()));
					notificationsToAdd.setUserid(1);
					notificationsToAdd.setSeen(false);
					ajouterNotifications(notificationBusiness, notificationsToAdd);
				
				break;
			case 3:
				 Notifications notificationsToUpdate = new Notifications();
				 System.out.println("Veuillez donner la date de la notification :");
				 notificationsToUpdate.setDate(reader.readLine());
				 System.out.println("Veuillez donner le type de la notification :");
				 notificationsToUpdate.setType(Integer.parseInt(reader.readLine()));
				 notificationsToUpdate.setUserid(1);
				 System.out.println("Veuillez donner l'id de la notification :");
				 int id = Integer.parseInt(reader.readLine());
				 notificationsToUpdate.setId(id);
				 updateNotifications(notificationBusiness, notificationsToUpdate, id);
				break;
			case 4:
				System.out.println("Veuillez donner l'ID de la notification : ");
				deleteNotification(notificationBusiness, Integer.parseInt(reader.readLine()));
				break;

			default:
				break;
			}

		}while (choice != 5);
			System.out.println("BYE BYE !");

	
    
    
    
    
    System.out.println(
			"*************************************************** SKILL ***********************************************");

	System.out.println("******GET Skills******");

	List<Skill> skills = SkBs.getSkills();
	for (int i = 0; i < skills.size(); i++) {
		System.out.println(skills.get(i).getName());
	}
	System.out.println("******ADD Skill******");

	Skill skillToAdd = new Skill(15, null, 2, "bbbb", 1);
	System.out.println(SkBs.createSkill(skillToAdd));

	System.out.println("******UPDATE Skill******");

	Skill skillToUpdate = new Skill(15, null, 2, "asassass", 1);
	System.out.println(SkBs.updateSkill(15, skillToUpdate));

	System.out.println("******DELETE Skill******");

	System.out.println(SkBs.deleteSkill(15));

	System.out.println("*************************************************** POST ***********************************************");
	System.out.println("******GET Posts******");

	List<Post> post = PsBs.getPosts();
	for (int i = 0; i < post.size(); i++) {
		System.out.println(post.get(i).getDescription());
	}

	System.out.println("******ADD post******");

	//Timestamp dt = new Timestamp(System.currentTimeMillis());
	Post postToAdd = new Post(7,"2017-04-10T21:20:05", "Architeture CISCO", 1, 1);
	System.out.println(PsBs.createPost(postToAdd));
    System.out.println("******UPDATE post******");
    
       
    Post postToUpdate = new Post(1, null, " JEE", 1, 1);
    System.out.println(PsBs.updatePost(1, postToUpdate));
    
    System.out.println("******DELETE post******");

	System.out.println(PsBs.deletePost(2));

	System.out.println("*************************************************** FORMATIONS ***********************************************");
	FormationBusiness userBusiness = new FormationBusiness();

	List<Formations> users = userBusiness.getFormations();

	for (int i = 0; i < users.size(); i++) {
		System.out.println(users.get(i).getId());}
	}




	void afficherNotifications(NotificationBusiness notificationBusiness){
		List<Notifications> notifications = notificationBusiness.getNotification();
		for (int i=0; i<notifications.size(); i++){
			System.out.println(notifications.get(i).toString());
		}
	}

	void deleteNotification(NotificationBusiness notificationBusiness, int idToDelete){
		System.out.println(notificationBusiness.deleteNotification(1));
	}

	void ajouterNotifications(NotificationBusiness notificationBusiness,Notifications notificationToAdd){
		System.out.println(notificationBusiness.createNotification(notificationToAdd));
	}
	
	void updateNotifications(NotificationBusiness notificationBusiness,Notifications notificationToUpdate, int idToUpdate){
		System.out.println(notificationBusiness.updateNotification(idToUpdate, notificationToUpdate));
	}

        
        

}
