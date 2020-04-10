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
import static fr.insalyon.dasi.metier.modele.SeanceVoyance_.medium;
import fr.insalyon.dasi.metier.service.Service;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        
        Medium aurel = new Spirite("Gwenaëlle", "Spécialiste des grandes conversations au-delà de TOUTES les frontières.", "Boule de cristal","nom", "prenom", "F");       

        Medium romain = new Spirite("Professeur Tran", "Marc de café, boule de cristal, oreilles de lapin", "Votre avenir est devant vous: regardons-le ensemble!", "nom", "prenom", "H");
        
        Medium jj = new Astrologue("Serena", "École Normale Supérieure d’Astrologie (ENS-Astro)", "2006", "Basée  à  Champigny-sur-Marne, Serena vous révèlera votre  avenir  pour éclairer  votre passé.", "nom", "prenom", "F");   
        
        Medium bastien = new Cartomancien( "Mme Irma", "Comprenez votre entourage grâce à mes cartes! Résultats rapides.", "nom", "prenom", "F"); 
        
        Medium agathe = new Cartomancien( "Endora", "Mes cartes répondront à toutes vos questions personnelles.", "nom", "prenom", "F"); 
        
        TimeZone heure = aujourdhui.getTimeZone();
        
        Employe thomas  = new Employe( "Nom", "Prenom", aujourdhui, "Adresse", "Email", 1029384756, "MotDePasse" ,"F",false,12);
        
        Employe michou  = new Employe( "Blaze", "Prenom", aujourdhui, "Adresse", "Yoyoyo", 1029384756, "MotDePasse" ,"F",false,4);
        
        Client JjLeRageux = new Client( "meldrum", "jj", aujourdhui, "efae", "zefjaepip", 123456789, "MotDePasse","cancer", "pinguin","ane", "blanc cassé");
        
        Client Mario = new Client( "G", "mario", aujourdhui, "bouh", "aaah", 123456789, "MotDePasse","cancer", "mario","mario", "blanc cassé");
       
        Client Matteo = new Client( "dumont", "mateeo", aujourdhui, "iii", "eee", 123456789, "MotDePasse","cancer", "mateo","mateo", "blanc cassé");
       

        /** test de services **/
        System.out.println("-------- test de services -------- " );
        
        
        Service service = new Service();

        service.inscrireClient(Matteo);
        service.inscrireEmploye(thomas);
        service.inscrireEmploye(michou);
        service.creerMedium(jj);
        service.creerMedium(agathe);
        service.creerMedium(romain);
        service.creerMedium(bastien);
        service.creerMedium(aurel);        
        long bite  = 1;
        
        Client iencli = service.rechercherClientParId(bite);
        Client client = service.rechercherClientParMail("eee");       
        Employe emplo = service.rechercherEmployeParMail("Email");
        Astrologue astro = service.chercherAstrologueParId(bite);
     
        //test de création et persistance d'objets
        System.out.println("-------- test de création et persistance d'objets -------- " );
        
        Calendar debut = Calendar.getInstance();
        SeanceVoyance seance = new SeanceVoyance(debut,  debut, true, "commentaire", client, emplo, astro);
        
        service.inscrireSeanceVoyance(seance); 
        
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
        
        //test recherche employe
        System.out.println("-------- test recherche employe  -------- " ); 
        Employe lemploye = service.solliciterMedium(jj);
        System.out.println("-> " + lemploye.toString());
        JpaUtil.destroy();
        

        
    }
}