package entities;

import entities.Movie;
import entities.Theater;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-31T14:22:41")
@StaticMetamodel(Showtime.class)
public class Showtime_ { 

    public static volatile SingularAttribute<Showtime, String> timeid;
    public static volatile SingularAttribute<Showtime, String> showtime;
    public static volatile SingularAttribute<Showtime, Theater> theaterid;
    public static volatile SingularAttribute<Showtime, Movie> movieid;

}