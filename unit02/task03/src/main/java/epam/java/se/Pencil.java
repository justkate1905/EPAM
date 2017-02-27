package epam.java.se;

/**
 * Created by Katerina on 27.02.2017.
 */
public class Pencil extends StationeryItem {
    private String color;
    private String hardness;

    {
        nameOfItem = "Pencil";
    }

    public Pencil() {
        price = 15;
        color = "Black";
        hardness = "2B";
    }

    public Pencil(String _color, String _hardness, long _price) {
        if (_color.equals("") || _color == null) {
            throw new IllegalArgumentException("Illegal color of pencil! It have to be not empty");
        }
        else if (_hardness.equals("") || _hardness == null) {
            throw new IllegalArgumentException("Illegal hardness of ink! It have to be not empty");
        }
        else if(_price <=0){
            throw new IllegalArgumentException("Input price have to be positive");
        }
        else {
            price = _price;
            color = _color;
            hardness = _hardness;
        }
    }
}
