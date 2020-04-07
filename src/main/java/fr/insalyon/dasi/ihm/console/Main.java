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
                
        Calendar aujourdhui = Calendar.getInstance(); 
        
        Medium aurel = new Spirite("jsp", "bgdlacalle", "boulecristale","nom", "prenom", "sexe");
        System.out.println("-> " + aurel.toString());        

        Medium jj = new Astrologue("charlatan", "jsp", "bgdlacalle", "boulecristale", "nom", "prenom", "sexe");
        System.out.println("-> " + jj.toString());   
        
        Medium bastien = new Cartomancien( "bgdlacalle", "cartes", "nom", "prenom", "sexe");
        System.out.println("-> " + bastien.toString());   
         
        TimeZone heure = aujourdhui.getTimeZone();
        
        Employe thomas  = new Employe( "Nom", "Prenom", aujourdhui, "Adresse", "Email", 1029384756, "MotDePasse" ,"je me définit comme une sorte de fusion entre la tièdeur d'une soirée d'automne et la bise de printemps qui caresse les fleurs de cerisiers.",false,12);
        
        Client JjLeRageux = new Client( "meldrum", "jj", aujourdhui, "efae", "zefjaepip", 123456789, "MotDePasse","cancer", "pinguin","ane", "blanc cassé");
        
        Client Mario = new Client( "G", "mario", aujourdhui, "bouh", "aaah", 123456789, "MotDePasse","cancer", "mario","mario", "blanc cassé");
       
        SeanceVoyance voy1 = new SeanceVoyance(heure, heure, false, "commentaire", 123, 22, 22);

        Client Matteo = new Client( "dumont", "mateeo", aujourdhui, "iii", "eee", 123456789, "MotDePasse","cancer", "mateo","mateo", "blanc cassé");
       

        Service service = new Service();

        service.inscrireClient(Matteo);
        service.inscrireEmploye(thomas);
        
        JpaUtil.destroy();
  
      
        
    }
}