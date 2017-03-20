package t04;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Katerina on 20.03.2017.
 */
public class FilmsTest {
    @Test
    public void testSetCollection() throws IOException, ClassNotFoundException {
        List<Actor> sherlockActors = new ArrayList<Actor>();
        sherlockActors.add(new Actor("Benedict Cumberbatch"));
        sherlockActors.add(new Actor("Martin Freeman"));
        sherlockActors.add(new Actor("Andrew Scott"));
        Film sherlock = new Film("Logan", sherlockActors);

        List<Actor> imitationGameActors = new ArrayList<Actor>();
        imitationGameActors.add(new Actor("Benedict Cumberbatch"));
        imitationGameActors.add(new Actor("Keira Knightley"));
        Film imitationGame = new Film("XmenFirstClass", imitationGameActors);

        List<Film> films = new ArrayList<Film>();
        films.add(sherlock);
        films.add(imitationGame);

        Films.serialize(films,"movies.txt");


        ArrayList<Film> moviesList = (ArrayList<Film>) Films.deserialize("movies.txt");

        for (Film m : moviesList){
            System.out.print(m.FilmInfo());
        }
    }
}