package fr.insalyon.dasi.dao;

import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.SeanceVoyance;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author DASI Team
 */
public class SeanceVoyanceDao {
    
    public void creer(SeanceVoyance seance) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(seance);
    }
    
    public SeanceVoyance chercherParId(Long seanceVoyanceId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(SeanceVoyance.class, seanceVoyanceId); // renvoie null si l'identifiant n'existe pas
    }
    
    public List<SeanceVoyance> listerSeanceVoyance() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<SeanceVoyance> query = em.createQuery("SELECT c FROM SeanceVoyance c ", SeanceVoyance.class);
        return query.getResultList();
    }
    static public List<SeanceVoyance> listerSeanceVoyanceParClient(Client client) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<SeanceVoyance> query = em.createQuery("SELECT c FROM SeanceVoyance c WHERE c.client = :clt", SeanceVoyance.class);
        query.setParameter("clt", client);
        return query.getResultList();
    }

    static public List<SeanceVoyance> listerSeanceVoyanceParEmploye(Employe employe) {
    EntityManager em = JpaUtil.obtenirContextePersistance();
    TypedQuery<SeanceVoyance> query = em.createQuery("SELECT c FROM SeanceVoyance c WHERE c.employe = :employe", SeanceVoyance.class);
    query.setParameter("employe", employe);
    return query.getResultList();
    }
    
    static public List<SeanceVoyance> listerSeanceVoyanceParMedium(Medium medium) {
    EntityManager em = JpaUtil.obtenirContextePersistance();
    TypedQuery<SeanceVoyance> query = em.createQuery("SELECT c FROM SeanceVoyance c WHERE c.medium = :medium", SeanceVoyance.class);
    query.setParameter("medium", medium);
    return query.getResultList();
    }
    
    public int accepterSeance(SeanceVoyance seance){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<SeanceVoyance> query = em.createQuery("UPDATE SeanceVoyance c SET c.enCours = true, c.employe = :employe, c.debut = :debut WHERE c.id = :id", SeanceVoyance.class);
        query.setParameter("id", seance.getId()); // correspond au paramètre ":mail" dans la requête
        query.setParameter("employe", seance.getEmploye());
        query.setParameter("debut", Calendar.getInstance());
        int n = query.executeUpdate();
        return n;
    }
    // modifier / supprimer  ... 
}
