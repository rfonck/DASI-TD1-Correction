package fr.insalyon.dasi.metier.modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-06T18:40:53")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile SingularAttribute<Utilisateur, String> Prenom;
    public static volatile SingularAttribute<Utilisateur, String> Adresse;
    public static volatile SingularAttribute<Utilisateur, String> MotDePasse;
    public static volatile SingularAttribute<Utilisateur, String> Email;
    public static volatile SingularAttribute<Utilisateur, Date> DateNaissance;
    public static volatile SingularAttribute<Utilisateur, Integer> NumTel;
    public static volatile SingularAttribute<Utilisateur, Long> Id;
    public static volatile SingularAttribute<Utilisateur, String> Nom;

}