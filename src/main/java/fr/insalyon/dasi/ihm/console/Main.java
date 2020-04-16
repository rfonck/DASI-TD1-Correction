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
import fr.insalyon.dasi.util.AstroTest;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DASI Team
 */
public class Main {

    public static void main(String[] args) {
         
        JpaUtil.init();
        
        Service service = new Service();
        service.InitialisationMediumsEmployes();
        Calendar aujourdhui = Calendar.getInstance();
        
        //test validation seance voyance
        System.out.println("-------------------------------------------- " ); 
        System.out.println("--------test de déroulement de séance------- " ); 
        System.out.println("-------------------------------------------- " ); 
        
        
        System.out.println("  " ); 
        System.out.println("1. Le client se connecte " ); 
        System.out.println("  " ); 
        
        
        Client inscrit = new Client("bastien","bertholom", aujourdhui, "INSA", "bastoche", 1234567890, "TruiteFumée");
        service.inscrireClient(inscrit);
        
        
        
        System.out.println("-------------------------------------------- " ); 
        System.out.println("--------test de déroulement de séance------- " ); 
        System.out.println("-------------------------------------------- " ); 
        
        System.out.println("  " ); 
        System.out.println("1. Le client se connecte " ); 
        System.out.println("  " ); 
        
        String email = "bastoche";
        String mdp = "TruiteFumée";
        
        String denomination = service.identifierUtilisateur(email, mdp);
        System.out.println("    -> " + denomination);
        
        Client client1 = service.connecterClient(email, mdp);
        System.out.println("    -> " + client1.toString());
        
        
        System.out.println("  " ); 
        System.out.println("2. Le client consulte son historique " ); 
        System.out.println("  " );
        
        List<SeanceVoyance> histo = service.ConsulterHistoriqueSeances(client1);
            
        for(int i = 0; i< histo.size() ; i++)
        {
                 System.out.println("       Séance de voyance n°  " + i +  " "+   histo.get(i).toString());
        }
        
        System.out.println("  " ); 
        System.out.println("3. Le client décide de demander à voir la liste des mediums " ); 
        System.out.println("  " );
                
        List<Medium> mediums = service.listerMedium();
        
        System.out.println("        nous vous proposons nos médiums : " );
        for(int i = 0; i< mediums.size() ; i++)
        {
                 System.out.println("       Médium n°  " + i +  " "+   mediums.get(i).toString());
        }
       
        
        System.out.println("  " ); 
        System.out.println("4. Il a choisi un médium pour sa consultation et le sollicite " ); 
        System.out.println("  " );
                
        Medium aSolliciter = service.rechercherMedium("Mme Irma");
        Employe apte = service.solliciterMedium(aSolliciter, client1);
        
        System.out.println("       L'employé " + apte.toString() + " va interpréter ce rôle");
        
       
        System.out.println("  " ); 
        System.out.println("5. Le medium accepte le job " ); 
        System.out.println("  " );

        SeanceVoyance seance = service.AccepterConsultation(client1, apte, aSolliciter);
        
        System.out.println("       L'objet séanceVoyance est crée et initialisé, l'heure de début est l'heure courante");
        
        System.out.println("  " ); 
        System.out.println("6. Soudain, le médium à un trou. Il demande à être aidé grâce à une prédiction générée informatiquement " ); 
        System.out.println("  " );
        
        List<String> prediction = service.generateurVoyance(client1, 1, 3, 2);
        
        for(int i = 0; i< prediction.size() ; i++)
        {
            System.out.println("       Prédiction n°  " + i +  " "+   prediction.get(i));
        }

        System.out.println("  " ); 
        System.out.println("7. La Séance touche à sa fin, l'employé saisit un commentaire et cloture la séance." ); 
        System.out.println("  " );        
        
        seance.setCommentaire("Je ressent des ondes très positives chez ce client");
        service.finSeance(seance);
        
        
        System.out.println("  " ); 
        System.out.println("8. TOP MEDIUUUUUM" ); 
        System.out.println("  " );
        
        List<Medium> top = service.topMedium();
        
        for(int i = 0; i< top.size() ; i++)
        {
            System.out.println("       Medium n°  " + i +  " "+   top.get(i).toString());
        }
        JpaUtil.destroy();
    }
}