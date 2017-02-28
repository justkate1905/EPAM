package task03;

/**
 * Created by Katerina on 27.02.2017.
 */
public class NoteBook extends StationeryItem {
    protected int width;
    protected int length;
    protected int numberOfPages;
    {
        nameOfItem = "Notebook";
    }
    public NoteBook(){
        price = 20;
        width = 25;
        length = 30;
        numberOfPages = 80;
    }

    public NoteBook(long _price, int _width, int _length, int _numberOfPages) {
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

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
