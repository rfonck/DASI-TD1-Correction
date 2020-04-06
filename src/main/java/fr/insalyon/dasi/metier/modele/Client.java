package fr.insalyon.dasi.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;

import java.util.Date;

/**
 *
 * @author DASI Team
 */

@Entity
public class Client extends Utilisateur implements Serializable {

    private String signeAstrologique;
    private String signeChinois;
    private String animalTotem;
    private String couleurBonheur;

    public void setSigneAstrologique(String signeAstrologique) {
        this.signeAstrologique = signeAstrologique;
    }

    public void setSigneChinois(String signeChinois) {
        this.signeChinois = signeChinois;
    }

    public void setAnimalTotem(String animalTotem) {
        this.animalTotem = animalTotem;
    }

    public void setCouleurBonheur(String couleurBonheur) {
        this.couleurBonheur = couleurBonheur;
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
    public void setDateNaissance(Date DateNaissance) {
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

    public String getSigneAstrologique() {
        return signeAstrologique;
    }

    public String getSigneChinois() {
        return signeChinois;
    }

    public String getAnimalTotem() {
        return animalTotem;
    }

    public String getCouleurBonheur() {
        return couleurBonheur;
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
    public Date getDateNaissance() {
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

    public Client() {
    
    }

    public Client(String Nom, String Prenom, Date DateNaissance, String Adresse, String Email, int NumTel, String MotDePasse,String signeAstrologique, String signeChinois, String animalTotem, String couleurBonheur) {
        super(Nom, Prenom, DateNaissance, Adresse, Email, NumTel, MotDePasse);
        this.signeAstrologique = signeAstrologique;
        this.signeChinois = signeChinois;
        this.animalTotem = animalTotem;
        this.couleurBonheur = couleurBonheur;
    }

    @Override
    public String toString() {
        return "Iencli{" + "Id=" + Id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", DateNaissance=" + DateNaissance + ", Adresse=" + Adresse + ", Email=" + Email + ", NumTel=" + NumTel + ", MotDePasse=" + MotDePasse + ", signeAstrologique=" + signeAstrologique + ", signeChinois=" + signeChinois + ", animalTotem=" + animalTotem + ", couleurBonheur=" + couleurBonheur + '}';
    }

}
