package epam.java.se;

import java.util.ArrayList;

/**
 * Created by Katerina on 27.02.2017.
 */
public class StarterStationeryKit {
    private ArrayList<StationeryItem> starterKit;

    public StarterStationeryKit(){
        starterKit = new ArrayList<StationeryItem>();
        
        starterKit.add(new NoteBook());
        starterKit.add(new Pen());
        starterKit.add(new Planner());
        starterKit.add(new Pencil());

    }
}
