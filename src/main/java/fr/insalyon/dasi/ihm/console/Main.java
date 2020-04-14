package fr.insalyon.dasi.ihm.console;

import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.modele.Utilisateur;
import fr.insalyon.dasi.metier.modele.SeanceVoyance;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Spirite;
import fr.insalyon.dasi.metier.modele.Cartomancien;
import fr.insalyon.dasi.metier.modele.Astrologue;
import fr.insalyon.dasi.metier.service.Service;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author DASI Team
 */
public class Main {

    public static void main(String[] args) {
         
        JpaUtil.init();
        
        /** tests de création d'objets **/
        System.out.println("-------- tests de création d'objets -------- " );
        Calendar aujourdhui = Calendar.getInstance(); 
       
        
        Employe thomas  = new Employe( "Nom", "Prenom", aujourdhui, "Adresse", "Email", 1029384756, "MotDePasse" ,"F",false,12);
        
        Employe michou  = new Employe( "Blaze", "Prenom", aujourdhui, "Adresse", "Yoyoyo", 1029384756, "MotDePasse" ,"F",false,4);
        
        Client JjLeRageux = new Client( "meldrum", "jj", aujourdhui, "efae", "zefjaepip", 123456789, "MotDePasse","cancer", "pinguin","ane", "blanc cassé");
        
        Client Mario = new Client( "G", "mario", aujourdhui, "bouh", "aaah", 123456789, "MotDePasse","cancer", "mario","mario", "blanc cassé");
       
        Client Matteo = new Client( "dumont", "mateeo", aujourdhui, "iii", "eee", 123456789, "MotDePasse","cancer", "mateo","mateo", "blanc cassé");
       

        /** test de services **/
        System.out.println("-------- test de services -------- " );
        
        
        Service service = new Service();

        service.inscrireClient(Matteo);
        service.InitialisationMediumsEmployes();    
        long bite  = 1;
        
        Client iencli = service.rechercherClientParId(bite);
        Client client = service.rechercherClientParMail("eee");       
        Employe emplo = service.rechercherEmployeParMail("Email");
        Astrologue astro = service.chercherAstrologueParId(bite);
     
        //test de création et persistance d'objets
        System.out.println("-------- test de création et persistance d'objets -------- " );
        
        Calendar debut = Calendar.getInstance();
        SeanceVoyance seance = new SeanceVoyance(debut,  debut, true, "commentaire", client, emplo, astro);
        Long lid;
        lid = service.inscrireSeanceVoyance(seance); 
        
        //test d'authentification et connexion
        System.out.println("-------- test d'authentification et connexion -------- " );
        
        String username = "Email";
        String motdePasse = "MotDePasse";
        
        String un = service.identifierUtilisateur(username, motdePasse);
        System.out.println("-> " + un);
        if(un.equals("client")){
            Client hello = service.connecterClient(username, motdePasse);
            System.out.println("-> " + hello.toString());
            
            
        }
        else if(un.equals("employe")){
            Employe hello = service.connecterEmploye(username, motdePasse);
            System.out.println("-> " + hello.toString());  
        }
        
        //test de listage de medium 
        System.out.println("-------- test de listage de medium  -------- " );        
        List<Medium> listeCharlo = service.listerMedium();
        for(int i=0; i< listeCharlo.size(); i++ ){
            System.out.println("-> " + listeCharlo.get(i).toString()); 
        }
        
        
        //test de l'historique des voyances d'un utilisateur 
        System.out.println("-------- test de l'historique des voyances d'un utilisateur   -------- " );  
        List<SeanceVoyance> musolini = service.ConsulterHistoriqueSeances(client);
        for(int i=0; i< musolini.size(); i++ ){
            System.out.println("-> " + musolini.get(i).toString()); 
        }
        Medium jj = service.rechercherMedium("Serena");
        //test recherche employe
        System.out.println("-------- test recherche employe  -------- " ); 
        Employe lemploye = service.solliciterMedium(jj);
        System.out.println("-> " + lemploye.toString());
        
        //test recherche medium
        Medium racli = service.rechercherMedium("Mme Irma");
        System.out.println("-> " + racli.toString());
        
        //test validation seance voyance
        System.out.println("-------- test modif seance voyance  -------- " ); 
        SeanceVoyance newseance = service.rechercherSeanceVoyanceParId(lid);
        service.AccepterConsultation(newseance, lemploye);
        Employe ronaldo = service.rechercherEmployeParMail(lemploye.getEmail());
        System.out.println("-> " + ronaldo.toString());
        
        JpaUtil.destroy();
    }
}