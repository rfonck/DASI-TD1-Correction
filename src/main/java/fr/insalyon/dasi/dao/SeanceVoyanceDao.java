package fr.insalyon.dasi.dao;

import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.SeanceVoyance;
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
    // modifier / supprimer  ... 
}
