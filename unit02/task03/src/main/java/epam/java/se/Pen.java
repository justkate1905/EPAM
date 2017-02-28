package epam.java.se;

/**
 * Created by Katerina on 27.02.2017.
 */
public class Pen extends StationeryItem {
    private String colorOfInk;
    private float thicknessOfLine;
    private String type;

    {
        nameOfItem = "Pen";
    }
    public Pen(){
        colorOfInk = "String";
        thicknessOfLine = 0.4f;
        type = "auto";
    }

    public Pen(String _colorOfInk, float _thicknessOfLine, String _type, long _price) {
        if(!_colorOfInk.equals("") && _colorOfInk != null) {
            if(_thicknessOfLine < 0.1F) {
                throw new IllegalArgumentException("Input thickness is less then possible!");
            }
            else if(_price <= 0L) {
                throw new IllegalArgumentException("Input price have to be positive");
            }
            else if(_type.equals("") || _type != null) {
                throw new IllegalArgumentException("Type of pen can\'t be empty!");
            }
            else {
                colorOfInk = _colorOfInk;
                thicknessOfLine = _thicknessOfLine;
                type = _type;
                price = _price;
            }
        } else {
            throw new IllegalArgumentException("Illegal color of ink! It have to be not empty");
        }
    }

    public String getColorOfInk() {
        return colorOfInk;
    }

    public float getThicknessOfLine() {
        return thicknessOfLine;
    }

    public String getType() {
        return type;
    }

    public void setColorOfInk(String colorOfInk) {
        this.colorOfInk = colorOfInk;
    }

    public void setThicknessOfLine(float thicknessOfLine) {
        this.thicknessOfLine = thicknessOfLine;
    }

    public void setType(String type) {
        this.type = type;
    }
}
