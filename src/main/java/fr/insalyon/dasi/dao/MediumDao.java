package fr.insalyon.dasi.dao;

import fr.insalyon.dasi.metier.modele.Medium;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author DASI Team
 */
public class MediumDao {
    
    public void creer(Medium mediums) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(mediums);
    }
    
    public Medium chercherParId(Long mediumsId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Medium.class, mediumsId); // renvoie null si l'identifiant n'existe pas
    }
    
    
    public List<Medium> listerMediums() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Medium> query = em.createQuery("SELECT * FROM ROUTE.Medium", Medium.class);
        return query.getResultList();
    }
    
    // modifier / supprimer  ... 
}
