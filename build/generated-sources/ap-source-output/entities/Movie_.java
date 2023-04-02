package entities;

import entities.Showtime;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-31T14:22:41")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, String> duration;
    public static volatile CollectionAttribute<Movie, Showtime> showtimeCollection;
    public static volatile SingularAttribute<Movie, String> imageurl;
    public static volatile SingularAttribute<Movie, String> name;
    public static volatile SingularAttribute<Movie, String> description;
    public static volatile SingularAttribute<Movie, String> movieid;

}