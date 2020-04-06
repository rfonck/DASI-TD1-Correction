/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import fr.insalyon.dasi.metier.modele.Utilisateur;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 *
 * @author rfonc
 */
@Entity
public class Employe extends Utilisateur implements Serializable {
    
    private  String Genre;
    private boolean ConsultationEnCours;
    private  int NombreSeance;

    public Employe() {
    }

    public Employe(String Nom, String Prenom, Calendar DateNaissance, String Adresse, String Email, int NumTel, String MotDePasse,String Genre, boolean ConsultationEnCours, int NombreSeance) {
        super(Nom, Prenom, DateNaissance, Adresse, Email, NumTel, MotDePasse);
        this.Genre = Genre;
        this.ConsultationEnCours = ConsultationEnCours;
        this.NombreSeance = NombreSeance;
    }


    public String getGenre() {
        return Genre;
    }

    public boolean isConsultationEnCours() {
        return ConsultationEnCours;
    }

    public int getNombreSeance() {
        return NombreSeance;
    }
    @Override
    public Long getId() {
        return Id;
    }
    @Override
    public String getNom() {
        return Nom;
    }
    @Override
    public String getPrenom() {
        return Prenom;
    }
    @Override
    public Calendar getDateNaissance() {
        return DateNaissance;
    }
    @Override
    public String getAdresse() {
        return Adresse;
    }
    @Override
    public String getEmail() {
        return Email;
    }
    @Override
    public int getNumTel() {
        return NumTel;
    }

    @Override
    public String getMotDePasse() {
        return MotDePasse;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public void setConsultationEnCours(boolean ConsultationEnCours) {
        this.ConsultationEnCours = ConsultationEnCours;
    }

    public void setNombreSeance(int NombreSeance) {
        this.NombreSeance = NombreSeance;
    }
    @Override
    public void setNom(String Nom) {
        this.Nom = Nom;
    }
    @Override
    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }
    @Override
    public void setDateNaissance(Calendar DateNaissance) {
        this.DateNaissance = DateNaissance;
    }
    @Override
    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }
    @Override
    public void setEmail(String Email) {
        this.Email = Email;
    }
    @Override
    public void setNumTel(int NumTel) {
        this.NumTel = NumTel;
    }
    @Override
    public void setMotDePasse(String MotDePasse) {
        this.MotDePasse = MotDePasse;
    }

    @Override
    public String toString() {
        return "Employe{" + "Genre=" + Genre + ", ConsultationEnCours=" + ConsultationEnCours + ", NombreSeance=" + NombreSeance + '}';
    }

}
