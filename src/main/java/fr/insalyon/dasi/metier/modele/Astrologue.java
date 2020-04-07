/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;
import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author rfonc
 */
@Entity
public class Astrologue extends Medium implements Serializable {
    
    private String denomination;
    private String formation;
    private String promotion;
    private String presentation;

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    
    
    public String getDenomination() {
        return denomination;
    }

    public String getFormation() {
        return formation;
    }

    public String getPromotion() {
        return promotion;
    }

    public String getPresentation() {
        return presentation;
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

    
    
    public Astrologue() {
    }

    
    
    public Astrologue(String denomination, String formation, String promotion, String presentation, String nom, String prenom, String sexe) {
        super(nom, prenom, sexe);
        this.denomination = denomination;
        this.formation = formation;
        this.promotion = promotion;
        this.presentation = presentation;
    }

   @Override
    public String toString() {
        return "Astrologue : id=" + id + ", nom=" + super.nom + ", prenom=" + super.prenom + ", sexe=" + super.sexe + ", denomination=" + denomination + ", formation=" + formation + ", promotion=" + promotion +  ", presentation=" + presentation ;
    }
    
}
