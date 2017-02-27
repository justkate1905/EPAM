package epam.java.se;

/**
 * Created by Katerina on 27.02.2017.
 */
public class Stationery {
    private String stationeryName;
    private long price;

    public Stationery(){

    }
    public Stationery(String _stationeryName, long _price) {
        stationeryName = _stationeryName;
        price = _price;
    }

    public String getStationeryName() {
        return stationeryName;
    }

    public void setStationeryName(String stationeryName) {
        this.stationeryName = stationeryName;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPrice(){
        return price;
    }
}
