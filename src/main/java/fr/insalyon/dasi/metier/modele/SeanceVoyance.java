/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
/**
 *
 * @author rfonc
 */
@Entity
public class SeanceVoyance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date debut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fin;
    private Boolean enCours;
    private String commentaire;

    private long idClient;

    private long idEmploye;

    private long idMedium;    

    public Long getId() {
        return id;
    }

    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
        return fin;
    }

    public Boolean getEnCours() {
        return enCours;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public long getIdClient() {
        return idClient;
    }

    public long getIdEmploye() {
        return idEmploye;
    }

    public long getIdMedium() {
        return idMedium;
    }



    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public void setEnCours(Boolean enCours) {
        this.enCours = enCours;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public void setIdEmploye(long idEmploye) {
        this.idEmploye = idEmploye;
    }

    public void setIdMedium(long idMedium) {
        this.idMedium = idMedium;
    }

    public SeanceVoyance(Date debut, Date fin, Boolean enCours, String commentaire, long idClient, long idEmploye, long idMedium) {
        this.debut = debut;
        this.fin = fin;
        this.enCours = enCours;
        this.commentaire = commentaire;
        this.idClient = idClient;
        this.idEmploye = idEmploye;
        this.idMedium = idMedium;
    }

    public SeanceVoyance(Date debut, Client client, Employe employe, Medium medium) {
        this.debut = debut;
        this.idClient = client.getId();
        this.idEmploye = employe.getId();
        this.idMedium = medium.getId();
        this.enCours = true;
    }
    
    public void FinaliserSeance (String commentaire){
        this.commentaire  = commentaire;
        this.fin = new Date(System.currentTimeMillis()); 
        this.enCours = false;   
    }
            
    public void addClient(Client client){
         this.idClient = client.getId();       
        
    }
         
    public void addMedium(Medium medium){
         this.idClient = medium.getId();       
        
    }

    public void addEmploye(Employe employe){
         this.idClient = employe.getId();       
        
    }

   



    public SeanceVoyance() {
    }


    public void ajout_commentaire(String note) {
        this.commentaire = note;
    }

    public void fin_seance() {
        this.fin = new Date();
        this.enCours = false;
    }

    @Override

    public String toString() {
        return "SeanceVoyance{" + "id=" + id + ", debut=" + debut + ", fin=" + fin + ", enCours=" + enCours + ", commentaire=" + commentaire + ", idClient=" + idClient + ", idEmploye=" + idEmploye + ", idMedium=" + idMedium + '}';
    }

    

}
