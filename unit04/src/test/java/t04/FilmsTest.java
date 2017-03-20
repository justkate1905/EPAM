package t04;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

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

        Films.serialize(films,"collection.txt");


        ArrayList<Film> moviesList = (ArrayList<Film>) Films.deserialize("collection.txt");

        for (Film m : moviesList){
            System.out.print(m.filmInfo());
        }
    }
    @Test
    public void getCollectionTest() throws IOException, ClassNotFoundException {

        ArrayList<Film> moviesList = (ArrayList<Film>) Films.deserialize("collection.txt");

        for (Film m : moviesList) {
            System.out.print(m.filmInfo());
        }
    }

    @Test
    public void testAddToCollection() throws IOException, ClassNotFoundException {

        ArrayList<Film> moviesList = (ArrayList<Film>) Films.deserialize("collection.txt");

        List<Actor> aBeautifulMindActors = new ArrayList<Actor>();
        aBeautifulMindActors.add(new Actor("Russell Crowe"));
        aBeautifulMindActors.add(new Actor("Ed Harris"));
        aBeautifulMindActors.add(new Actor("Jennifer Connelly "));

        Film aBeautifulMind = new Film("A Beautiful mind", aBeautifulMindActors);

        moviesList.add(aBeautifulMind);

        assertTrue(moviesList.contains(aBeautifulMind));

    }

    @Test
    public void testRemoveFromCollection() throws IOException, ClassNotFoundException {


        List<Actor> sherlockActors = new ArrayList<Actor>();
        sherlockActors.add(new Actor("Benedict Cumberbatch"));
        sherlockActors.add(new Actor("Martin Freeman"));
        sherlockActors.add(new Actor("Andrew Scott"));

        Film sherlock = new Film("Logan", sherlockActors);

        ArrayList<Film> moviesList = (ArrayList<Film>) Films.deserialize("collection.txt");

        moviesList.remove(sherlock);

        assertFalse(moviesList.contains(sherlock));

    }
}