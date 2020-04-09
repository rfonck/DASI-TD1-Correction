package fr.insalyon.dasi.dao;

import fr.insalyon.dasi.metier.modele.Astrologue;
import fr.insalyon.dasi.metier.modele.Cartomancien;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Spirite;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    
    public void creerMedium (Cartomancien carto){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(carto);
    }
    
    public void creerMedium (Astrologue astro){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(astro);
    }
    
    public void creerMedium (Spirite sprite){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(sprite);
    }
    
    
    public Medium chercherParId(Long mediumsId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Medium.class, mediumsId); // renvoie null si l'identifiant n'existe pas
    }
    
    public Spirite chercherParIdSpirite(Long spiriteId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Spirite.class, spiriteId); // renvoie null si l'identifiant n'existe pas
    }
    
    public Cartomancien chercherParIdCartomancien(Long cartomancienId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Cartomancien.class, cartomancienId); // renvoie null si l'identifiant n'existe pas
    }
    
    public Astrologue chercherParIdAstrologue(Long astroId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Astrologue.class, astroId); // renvoie null si l'identifiant n'existe pas
    }
    
        public Astrologue chercherParNomAstrologue(String nom) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Astrologue> query = em.createQuery("SELECT a FROM Utilisateur a WHERE a.nom = :nom", Astrologue.class);
        query.setParameter("nom", nom); // correspond au paramètre ":mail" dans la requête
        List<Astrologue> clients = query.getResultList();
        Astrologue result = null;
        if (!clients.isEmpty()) {
            result = clients.get(0); // premier de la liste
        }
        return result;
    }
    
    public List<Astrologue> listerAstrologue() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Astrologue> query = em.createQuery("SELECT m FROM Astrologue m ", Astrologue.class);
        return query.getResultList();
    }
    
    public List<Cartomancien> listerCartomancien() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Cartomancien> query = em.createQuery("SELECT m FROM Cartomancien m", Cartomancien.class);
        return query.getResultList();
    }
    
    public List<Spirite> listerSpirite() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Spirite> query = em.createQuery("SELECT m FROM Spirite m ", Spirite.class);
        return query.getResultList();
    }    
    
    public List<Medium> listerMediums() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        String ordre = "SELECT m FROM Medium m ";
        Query query = em.createQuery(ordre);
        List<Medium> lst = query.getResultList();
        return query.getResultList();
    }
    
    
    // modifier / supprimer  ... 
}
