/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.DiscriminatorColumn; 
import javax.persistence.DiscriminatorValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



/**
 *
 * @author rfonc
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED) 

public class Medium implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;
    protected String nom;
    protected String prenom;
    protected String sexe;

    public Medium(String nom, String prenom, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
    }

    public Medium() {
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    
    @Override
    public String toString() {
        return "Medium : id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe;
    }        
    

    
    
    
}
