package epam.java.se;

/**
 * Created by Katerina on 27.02.2017.
 */
public class Planner extends NoteBook {
    private int year;

    {
        nameOfItem = "Planner";
        year = 2017;
    }

    public Planner() {
    }

    public Planner(long _price, int _width, int _length, int _numberOfPages) {
        if (_price <= 0L) {
            throw new IllegalArgumentException("Input price have to be positive");
        }
        else if (_width <= 0L || _length <= 0L) {
            throw new IllegalArgumentException("Input sizes must be positive!");
        }
        else if (_numberOfPages <= 0) {
            throw new IllegalArgumentException("Number of pages must be positive!");
        }
        else {
            price = _price;
            width = _width;
            length = _length;
            numberOfPages = _numberOfPages;
        }
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
