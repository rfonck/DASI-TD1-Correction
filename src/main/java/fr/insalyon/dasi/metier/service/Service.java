package fr.insalyon.dasi.metier.service;

import fr.insalyon.dasi.dao.ClientDao;
import fr.insalyon.dasi.dao.EmployeDao;
import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.dasi.dao.MediumDao;
import fr.insalyon.dasi.dao.SeanceVoyanceDao;
import fr.insalyon.dasi.metier.modele.Astrologue;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Spirite;
import fr.insalyon.dasi.metier.modele.SeanceVoyance;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DASI Team
 */
public class Service {

    protected ClientDao clientDao = new ClientDao();
    protected EmployeDao employeDao = new EmployeDao();
    protected SeanceVoyanceDao seanceVoyanceDao = new SeanceVoyanceDao();
    protected MediumDao mediumDao = new MediumDao();
    


    public Long inscrireEmploye(Employe employe) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            employeDao.creer(employe);
            JpaUtil.validerTransaction();
            resultat = employe.getId();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service inscrireClient(client)", ex);
            JpaUtil.annulerTransaction();
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
        
    public Long inscrireSeanceVoyance(SeanceVoyance seance) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            seanceVoyanceDao.creer(seance);
            JpaUtil.validerTransaction();
            resultat = seance.getId();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service inscrireClient(client)", ex);
            JpaUtil.annulerTransaction();
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
        
    public Long creerMedium(Medium seance) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            mediumDao.creer(seance);
            JpaUtil.validerTransaction();
            resultat = seance.getId();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service inscrireClient(client)", ex);
            JpaUtil.annulerTransaction();
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public Client rechercherClientParId(Long id) {
        Client resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = clientDao.chercherParId(id);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }

    public Employe rechercherEmployeParMail(String mail) {
        Employe resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = employeDao.chercherParMail(mail);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
        
    public Client rechercherClientParMail(String mail) {
        Client resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = clientDao.chercherParMail(mail);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
        public Astrologue rechercherAstrologueParNom(String nom) {
        Astrologue resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = mediumDao.chercherParNomAstrologue(nom);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    


    public List<Client> listerClients() {
        List<Client> resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = clientDao.listerClients();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerClients()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }

    public Astrologue chercherAstrologueParId(long id) {
        Astrologue resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = mediumDao.chercherParIdAstrologue(id);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }

    
    /**
     * Service :  inscrireClient(Client nouveauClient)

description : Ce service va inscrire un client dans la base de donnée à partir des informations fournies.

Algorithme : On vérifie d’abord que les informations transmises sont correctes (numéro de téléphone répondant aux standards, email valide, date de naissance vraisemblable)
 
Si les vérifications sont passées avec succès, on inscrit le nouveau client dans la base de donnée. On renvoie alors un booléen true.

Sinon on renvoie un booléen false.**/
    
        public Long inscrireClient(Client client) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            clientDao.creer(client);
            JpaUtil.validerTransaction();
            resultat = client.getId();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service inscrireClient(client)", ex);
            JpaUtil.annulerTransaction();
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    /**

Service :  identifierUtilisateur(String email, string motDePasse)

description : Ce service identifie un utilisateur à partir de l’adresse mail et du mot de passe passés en paramètre. Il différencie les employés et les clients. 

Algorithme : On vérifie si l’adresse mail et le mot de passe sont associé à un utilisateur. 

Si un utilisateur existe on renvoie son type (String)
Sinon on renvoie un NULL **/
        
        
    public String identifierUtilisateur(String mail, String motDePasse) {
        String resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            // Recherche du client
            Client client = clientDao.chercherParMail(mail);
            if (client != null) {
                // Vérification du mot de passe
                if (client.getMotDePasse().equals(motDePasse)) {
                    resultat = "client";
                }
            }
            if(resultat == null){
                Employe employe = employeDao.chercherParMail(mail);
                if (employe != null) {
                    // Vérification du mot de passe
                    if (employe.getMotDePasse().equals(motDePasse)) {
                        resultat = "employe";
                    }
                }
            }
            
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service authentifierClient(mail,motDePasse)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
        
        /**

Service : connecterClient(String email, string motDePasse)

description : Renvoie le client associé à l’adresse mail et au mot de passe.Algorithme : Ce service réalise une sélection sur la table contenant les clients.Les contraintes sur la table imposent qu’un seul tuple sera retourné.Le service réalise un objet client grâce aux données récupérées.

Il renvoie ensuite cet objet.  
     * @param mail
     * @param motDePasse
     * @return 
**/
        public Client connecterClient(String mail, String motDePasse) {
        Client resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            // Recherche du client
            Client client = clientDao.chercherParMail(mail);
            if (client != null) {
                // Vérification du mot de passe
                if (client.getMotDePasse().equals(motDePasse)) {
                    resultat = client;
                }
            }
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service authentifierClient(mail,motDePasse)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    
    
    
    /**
Service : connecterClient(String email, string motDePasse)

description : Renvoie l’employé associé à l’adresse mail et au mot de passe.

Algorithme : Ce service réalise une sélection sur la table contenant les employés. Les contraintes sur la table imposent qu’un seul tuple sera retourné. Le service réalise un objet employe grâce aux données récupérées. Il renvoie ensuite cet objet.  
**/
    public Employe connecterEmploye(String mail, String motDePasse) {
        Employe resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            // Recherche du client
            Employe employe = employeDao.chercherParMail(mail);
            if (employe != null) {
                // Vérification du mot de passe
                if (employe.getMotDePasse().equals(motDePasse)) {
                    resultat = employe;
                }
            }
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service authentifierClient(mail,motDePasse)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
        
        
        /**
Service :  consulterListeMedium()


description :  Ce service permet de récupérer une liste contenant tous les médiums de la base de donnée et leurs caractéristiques.

Algorithme : Cet algorithme renvoie une liste complète d’objets “medium”. Ce sont des objets dont les données sont stockées dans la base de donnée du serveur.


* 
* 
    public List<Medium> listerMedium() {
        List<Medium> resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat.addALL(mediumDao.listerAstrologue());
            resultat.addALL(mediumDao.listerSpirite());
            resultat.addALL(mediumDao.listerCartomancien());
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerClients()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
   


    
    Service :  consulterHistoriqueSeances(Client client)

description : Cette fonction fournit l’historique des consultations du client passé en paramètre.

Algorithme : Ce service effectue une sélection dans la base de donnée de toutes les séances dont le client est celui passé en paramètre. On crée ensuite une liste d’objets “seanceVoyance” que l’on renvoie. 



Service : soliciterMedium(médium X, employe e)

description : Cette fonction permet de chercher l’employé le plus apte à faire la consultation. Renvoie un objet de type employé.

Algorithme : 
Un premier tri est fait selon le genre, puis l’employé avec le moins de consultations est renvoyé.
Si aucun employé n’est dispo renvoyer un employé vide


Service :  GenererProfilAstro(Client client)

description : Cette fonction renvoie un objet du type profilAstro personnalisé au client passé au paramètre.

Algorithme : Ce service réalise une requête au service web externe IfAstroNet et renvoie le résultat. 



Service :  soumettreNote(seanceVoyance seance, String commentaire)

description : Ce service ajoute le commentaire à la séance passé en paramètre.

Algorithme : Ce service crée ou modifie l’attribut Commentaire de l’objet seanceVoyance passé en commentaire pour lui donner la valeur du commentaire passé en paramètre.

Service :  string generateurVoyance (int noteAmour, int noteTravail , int noteSanté)

description : Prend les trois notes en paramètre et renvoie une prédiction adaptée

Algorithme : Pour chaque notes de chaque type (Amour, Travail, Santé) une phrase est associée. Il y a donc 12 phrases différentes à créer. 
La fonction renverra un string contenant toutes les prédictions.


Service : finSeance(seanceVoyance seance) 

description : Ce service archive la séance.

Algorithme : Ce service change l’attribut “fin” de l’objet séance passée en paramètre au Timestamp actuel, puis elle l’enregistre dans la base de donnée et la détruit. On renvoie true si la procédure s’est déroulée correctement et false sinon

     */
    
    
}
