package epam.java.se;

/**
 * Created by Katerina on 27.02.2017.
 */
public abstract class StationeryItem {
    public long price;
    public String nameOfItem;

    public long getPrice(){
        return getPrice();
    }
    public String getNameOfItem(){
        return nameOfItem;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }
}
