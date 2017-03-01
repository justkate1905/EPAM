package task03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Katerina on 27.02.2017.
 */
public class StarterStationeryKit {
    private List<StationeryItem> starterKit;

    public StarterStationeryKit(){
        starterKit = new ArrayList<StationeryItem>();
        starterKit.add(new NoteBook());
        starterKit.add(new Pen());
        starterKit.add(new Planner());
        starterKit.add(new Pencil());
    }
    public List<StationeryItem> getStarterKit(){
        return Collections.unmodifiableList(starterKit);
    }
}
