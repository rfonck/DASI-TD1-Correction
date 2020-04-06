/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;

/**
 *
 * @author rfonc
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public  class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long Id;
    protected String Nom;
    protected String Prenom;
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date DateNaissance;
    protected String Adresse;
    protected String Email;
    protected int NumTel;
    protected String MotDePasse;

    public Utilisateur() {
    }

    public Utilisateur( String Nom, String Prenom, Date DateNaissance, String Adresse, String Email, int NumTel, String MotDePasse) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.DateNaissance = DateNaissance;
        this.Adresse = Adresse;
        this.Email = Email;
        this.NumTel = NumTel;
        this.MotDePasse = MotDePasse;
    }

    public Long getId() {
        return Id;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public Date getDateNaissance() {
        return DateNaissance;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "Id=" + Id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", DateNaissance=" + DateNaissance + ", Adresse=" + Adresse + ", Email=" + Email + ", NumTel=" + NumTel + ", MotDePasse=" + MotDePasse + '}';
    }

    public int getNumTel() {
        return NumTel;
    }

    public String getMotDePasse() {
        return MotDePasse;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setDateNaissance(Date DateNaissance) {
        this.DateNaissance = DateNaissance;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setNumTel(int NumTel) {
        this.NumTel = NumTel;
    }

    public void setMotDePasse(String MotDePasse) {
        this.MotDePasse = MotDePasse;
    }
    
    
    
    
    
}
