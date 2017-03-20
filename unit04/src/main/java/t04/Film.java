package t04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Katerina on 20.03.2017.
 */
public class Film implements Serializable {

    private String nameOfFilm;
    private List<Actor> mainActors;

    public Film(String name, List<Actor> actors) {
        nameOfFilm = name;
        mainActors = actors;
    }

    public void addActors(Actor... actors) {
        mainActors.addAll(Arrays.asList(actors));
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Actor mainActor : mainActors) {
            hash += mainActor.getName().hashCode();
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Film film = (Film) obj;

        if (film.getNameOfFilm() == null) {
            return false;
        }
        if (!(film.getNameOfFilm().equals(nameOfFilm))) {
            return false;
        } else {
            if (film.getMainActors() == null) {
                return false;
            }
            List<Actor> otherActors = film.getMainActors();
            for (int i = 0; i < mainActors.size(); i++) {
                if (otherActors.get(i).getName() == null) {
                    return false;
                } else if (!otherActors.get(i).getName().equals(mainActors.get(i).getName())) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Actor> getMainActors() {
        return new ArrayList<Actor>(mainActors);
    }

    public String getNameOfFilm() {
        return nameOfFilm;
    }

    public String FilmInfo() {
        StringBuilder info = new StringBuilder();

        info.append("Main actors: \n");
        for (Actor mainActor : mainActors) {
            info.append(mainActor.getName()+ "\n");
        }

        return info.toString();
    }
}
