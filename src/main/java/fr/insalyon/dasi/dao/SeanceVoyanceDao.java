package fr.insalyon.dasi.dao;

import fr.insalyon.dasi.metier.modele.SeanceVoyance;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author DASI Team
 */
public class SeanceVoyanceDao {
    
    public void creer(SeanceVoyance employe) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(employe);
    }
    
    public SeanceVoyance chercherParId(Long seanceVoyanceId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(SeanceVoyance.class, seanceVoyanceId); // renvoie null si l'identifiant n'existe pas
    }
    
    public List<SeanceVoyance> listerSeanceVoyance() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<SeanceVoyance> query = em.createQuery("SELECT * FROM ROUTE.SEANCEVOYANCE", SeanceVoyance.class);
        return query.getResultList();
    }
    
    // modifier / supprimer  ... 
}
