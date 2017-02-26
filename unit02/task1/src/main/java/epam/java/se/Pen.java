package epam.java.se;

/**
 * Created by Katerina on 26.02.2017.
 */
public class Pen extends Object {
    private String colorOfInk;
    private float thicknessOfLine;
    private String type;
    private long price;

    public Pen() {
        colorOfInk = "Blue";
        thicknessOfLine = 0.5f;
        type = "mechanic";
        price = 50;
    }

    public Pen(String _colorOfInk, float _thicknessOfLine, String _type, long _price) {
        if (_colorOfInk.equals("") || _colorOfInk == null) {
            throw new IllegalArgumentException("Illegal color of ink! It have to be not empty");
        } else if (_thicknessOfLine < 0.1f) {
            throw new IllegalArgumentException("Input thickness is less then possible!");
        } else if (_price <= 0) {
            throw new IllegalArgumentException("Input price have to be positive");
        } else if (_type.equals("") || _type == null) {
            throw new IllegalArgumentException("Type of pen can't be empty!");
        }
        colorOfInk = _colorOfInk;
        thicknessOfLine = _thicknessOfLine;
        type = _type;
        price = _price;
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
        Pen pen = (Pen) obj;
        if (thicknessOfLine != pen.thicknessOfLine || price != pen.price) {
            return false;
        }
        if (!colorOfInk.equals(pen.colorOfInk)) {
            return false;
        }
        if (!type.equals(pen.type)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = (int) price * 47 + (int) thicknessOfLine * 47 + colorOfInk.hashCode() + type.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        String info = "{Price: " + price
                + "; Color of ink: " + colorOfInk
                + "; Type: " + type
                + "; Thickness of line: "+thicknessOfLine
                +"}";
        return info;
    }

}
