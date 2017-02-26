package epam.java.se;

public class Pen {
    private String colorOfInk;
    private float thicknessOfLine;
    private String type;
    private long price;

    public Pen() {
        this.colorOfInk = "Blue";
        this.thicknessOfLine = 0.5F;
        this.type = "mechanic";
        this.price = 50L;
    }

    public Pen(String _colorOfInk, float _thicknessOfLine, String _type, long _price) {
        if(!_colorOfInk.equals("") && _colorOfInk != null) {
            if(_thicknessOfLine < 0.1F) {
                throw new IllegalArgumentException("Input thickness is less then possible!");
            } else if(_price <= 0L) {
                throw new IllegalArgumentException("Input price have to be positive");
            } else if(!_type.equals("") && _type != null) {
                this.colorOfInk = _colorOfInk;
                this.thicknessOfLine = _thicknessOfLine;
                this.type = _type;
                this.price = _price;
            } else {
                throw new IllegalArgumentException("Type of pen can\'t be empty!");
            }
        } else {
            throw new IllegalArgumentException("Illegal color of ink! It have to be not empty");
        }
    }

    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(obj == null) {
            return false;
        } else if(this.getClass() != obj.getClass()) {
            return false;
        }
            Pen pen = (Pen)obj;
            if(thicknessOfLine != pen.thicknessOfLine){
                return false;
            }
            if(price != pen.price){
                return false;
            }
            if(!this.colorOfInk.equals(pen.colorOfInk)){
                return false;
            }
            if(!this.type.equals(pen.type)){
                return false;
            }
            return true;

    }

    public int hashCode() {
        int hash = (int)price * 47
                + (int)thicknessOfLine * 47
                + colorOfInk.hashCode()
                + type.hashCode();
        return hash;
    }

    public String toString() {
        String info = "{Price: " + this.price
                + "; Color of ink: " + this.colorOfInk
                + "; Type: " + this.type
                + "; Thickness of line: " + this.thicknessOfLine
                + "}";
        return info;
    }
}
