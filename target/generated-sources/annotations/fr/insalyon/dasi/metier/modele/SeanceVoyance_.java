package fr.insalyon.dasi.metier.modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-06T18:40:53")
@StaticMetamodel(SeanceVoyance.class)
public class SeanceVoyance_ { 

    public static volatile SingularAttribute<SeanceVoyance, Date> debut;
    public static volatile SingularAttribute<SeanceVoyance, Long> idClient;
    public static volatile SingularAttribute<SeanceVoyance, Date> fin;
    public static volatile SingularAttribute<SeanceVoyance, Long> id;
    public static volatile SingularAttribute<SeanceVoyance, String> commentaire;
    public static volatile SingularAttribute<SeanceVoyance, Long> idEmploye;
    public static volatile SingularAttribute<SeanceVoyance, Long> idMedium;
    public static volatile SingularAttribute<SeanceVoyance, Boolean> enCours;

}