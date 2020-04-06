/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import java.util.Date;
import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;
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

    private TimeZone debut;
    
    private TimeZone fin;
    private Boolean enCours;
    private String commentaire;

    private long idClient;

    private long idEmploye;

    private long idMedium;    

    public SeanceVoyance(TimeZone debut, TimeZone fin, Boolean enCours, String commentaire, long idClient, long idEmploye, long idMedium) {
        this.debut = debut;
        this.fin = fin;
        this.enCours = enCours;
        this.commentaire = commentaire;
        this.idClient = idClient;
        this.idEmploye = idEmploye;
        this.idMedium = idMedium;
    }

    public SeanceVoyance(TimeZone debut, Client client, Employe employe, Medium medium) {
        this.debut = debut;
        this.idClient = client.getId();
        this.idEmploye = employe.getId();
        this.idMedium = medium.getId();
        this.enCours = true;
    }
    
    public void FinaliserSeance (String commentaire){
        this.commentaire  = commentaire;
        this.fin = Calendar.getInstance().getTimeZone(); 
        this.enCours = false;   
    }
    
    public Long getId() {
        return id;
    }

    public TimeZone getDebut() {
        return debut;
    }

    public TimeZone getFin() {
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



    public void setDebut(TimeZone debut) {
        this.debut = debut;
    }

    public void setFin(TimeZone fin) {
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
        this.fin = Calendar.getInstance().getTimeZone();
        this.enCours = false;
    }

    @Override
    public String toString() {
        return "SeanceVoyance{" + "id=" + id + ", debut=" + debut + ", fin=" + fin + ", enCours=" + enCours + ", commentaire=" + commentaire + ", idClient=" + idClient + ", idEmploye=" + idEmploye + ", idMedium=" + idMedium + '}';
    }


    

}
