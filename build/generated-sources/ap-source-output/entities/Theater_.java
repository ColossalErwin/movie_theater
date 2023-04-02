package entities;

import entities.Showtime;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-31T14:22:41")
@StaticMetamodel(Theater.class)
public class Theater_ { 

    public static volatile CollectionAttribute<Theater, Showtime> showtimeCollection;
    public static volatile SingularAttribute<Theater, String> phone;
    public static volatile SingularAttribute<Theater, String> street;
    public static volatile SingularAttribute<Theater, String> theaterid;
    public static volatile SingularAttribute<Theater, String> imageurl;
    public static volatile SingularAttribute<Theater, String> name;

}