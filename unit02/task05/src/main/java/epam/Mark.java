package epam;

/**
 * Created by Katerina on 01.03.2017.
 */
public abstract  class Mark<T extends Number>{
    public T mark;

    public Mark(T _mark){
        mark = _mark;
    }
    public T getMark(){
        return mark;
    }

    public void setMark(T _mark){
        mark = _mark;
    }
}
