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
import java.util.Date;
import java.util.List;
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

        /**test de création d'objets **/
        Medium aurel = new Spirite("jsp", "bgdlacalle", "boulecristale","nom", "prenom", "sexe");
        System.out.println("-> " + aurel.toString());        

        Medium jj = new Astrologue("charlatan", "jsp", "bgdlacalle", "boulecristale", "nom", "prenom", "sexe");
        System.out.println("-> " + jj.toString());   
        
        Medium bastien = new Cartomancien( "bgdlacalle", "cartes", "nom", "prenom", "sexe");
        System.out.println("-> " + bastien.toString());   
        
        Date aujourdhui = new Date(System.currentTimeMillis()); 
        
        Employe thomas  = new Employe("je me définit comme une sorte de fusion entre la tièdeur d'une soirée d'automne et la bise de printemps qui caresse les fleurs de cerisiers.",false, 12,"Nom", "Prenom", aujourdhui, "Adresse", "Email", 1029384756, "MotDePasse");
        Client JjLeRageux = new Client( "meldrum", "jj", aujourdhui, "efae", "zefjaepip", 123456789, "MotDePasse","cancer", "pinguin","ane", "blanc cassé");
        Client Mario = new Client( "G", "mario", aujourdhui, "bouh", "aaah", 123456789, "MotDePasse","cancer", "mario","mario", "blanc cassé");
        
        SeanceVoyance voy1 = new SeanceVoyance(aujourdhui, aujourdhui, false, "commentaire", 123, 22, 22);

        
        /**test de persistances **/  
        
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("UTILISATEURS_PU");
        EntityManager em1 = emf1.createEntityManager();      
        
        try {
            em1.getTransaction().begin();
            em1.persist(JjLeRageux);
            em1.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service", ex);
            try {
                em1.getTransaction().rollback();
            }
            catch (IllegalStateException ex2) {
                // Ignorer cette exception...
            }
        } finally {
            em1.close();
        }

        
        
        
        
        
        EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("MEDIUM_PU");
        EntityManager em2 = emf2.createEntityManager();      
        
        try {
            em2.getTransaction().begin();
            em2.persist(bastien);
            em2.persist(jj);
            em2.persist(aurel);
            em2.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service", ex);
            try {
                em2.getTransaction().rollback();
            }
            catch (IllegalStateException ex2) {
                // Ignorer cette exception...
            }
        } finally {
            em2.close();
        }

        
        
        EntityManagerFactory emf3 = Persistence.createEntityManagerFactory("SEANCEVOYANCE_PU");
        EntityManager em3 = emf3.createEntityManager();      
        
        try {
            em3.getTransaction().begin();
            em3.persist(voy1);
            em3.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service", ex);
            try {
                em3.getTransaction().rollback();
            }
            catch (IllegalStateException ex2) {
                // Ignorer cette exception...
            }
        } finally {
            em3.close();
        }
        
        
    }
}