package epam;

/**
 * Created by Katerina on 01.03.2017.
 */
public enum Disciplines {
    HISTORY("History",Integer.class),
    PROGRAMMING("Programming",Double.class),
    MATHEMATICS("Mathematics",Double.class),
    ENGLISH("English",Integer.class),
    PHYSIC("Physic",Double.class),
    PSYCHOLOGY("Psychology",Integer.class);

    Class type;
    String name;
    Disciplines(String _name,Class _type){
        type = _type;
        name = _name;
    }
    public Class getType(){
        return type;
    }

    public String getName(){
        return name;
    }

}
