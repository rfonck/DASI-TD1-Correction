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


/**
 *
 * @author rfonc
 */


@Entity
public class Cartomancien extends Medium implements Serializable {

    private String denomination;
    private String presentation;

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    
    
    public String getDenomination() {
        return denomination;
    }

    public String getPresentation() {
        return presentation;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getPrenom() {
        return prenom;
    }

    @Override
    public String getSexe() {
        return sexe;
    }

    
    
    public Cartomancien() {
    }

    public Cartomancien(String denomination, String presentation, String nom, String prenom, String sexe) {
        super(nom, prenom, sexe);
        this.denomination = denomination;
        this.presentation = presentation;
    }

    @Override
    public String toString() {
        return "Cartomancien : id=" + super.id + ", nom=" + super.nom + ", prenom=" + super.prenom + ", sexe=" + super.sexe + ", denomination=" + denomination + ", presentation=" + presentation ;
    }
    

}
