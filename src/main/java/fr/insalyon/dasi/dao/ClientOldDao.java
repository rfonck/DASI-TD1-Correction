package fr.insalyon.dasi.dao;

import fr.insalyon.dasi.metier.modele.ClientOld;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author DASI Team
 */
public class ClientOldDao {
    
    public void creer(ClientOld client) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(client);
    }
    
    public ClientOld chercherParId(Long clientId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(ClientOld.class, clientId); // renvoie null si l'identifiant n'existe pas
    }
    
    public ClientOld chercherParMail(String clientMail) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<ClientOld> query = em.createQuery("SELECT c FROM Client c WHERE c.mail = :mail", ClientOld.class);
        query.setParameter("mail", clientMail); // correspond au paramètre ":mail" dans la requête
        List<ClientOld> clients = query.getResultList();
        ClientOld result = null;
        if (!clients.isEmpty()) {
            result = clients.get(0); // premier de la liste
        }
        return result;
    }
    
    public List<ClientOld> listerClients() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<ClientOld> query = em.createQuery("SELECT c FROM Client c ORDER BY c.nom ASC, c.prenom ASC", ClientOld.class);
        return query.getResultList();
    }
    
    // modifier / supprimer  ... 
}
