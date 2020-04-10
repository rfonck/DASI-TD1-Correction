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
public class Spirite extends Medium implements Serializable  {
    
    private String denomination;
    private String presentation;
    private String support;

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public void setSupport(String support) {
        this.support = support;
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

    public String getSupport() {
        return support;
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

    public Spirite() {
    }

    public Spirite(String denomination, String presentation, String support, String nom, String prenom, String sexe) {
        super(nom, prenom, sexe);
        this.denomination = denomination;
        this.presentation = presentation;
        this.support = support;
    }

        @Override
    public String toString() {
        return "Spirite : id=" + super.id + ", nom=" + super.nom + ", prenom=" + super.prenom + ", sexe=" + super.sexe + ", denomination=" + denomination + ", presentation=" + presentation + ", support=" + support ;
    }
    
    

    
    
    
    
    
    
    
    
}
