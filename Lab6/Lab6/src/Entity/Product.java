package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Product {
    private int id;
    private int clicks;
    private int addToCart;
    private int checkOut;
    private LocalDate date;

    public Product() {;}

    public Product(int id, int clicks, int addToCart, int checkOut, LocalDate date) {
        this.id = id;
        this.clicks = clicks;
        this.addToCart = addToCart;
        this.checkOut = checkOut;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getAddToCart() {
        return addToCart;
    }

    public void setAddToCart(int addToCart) {
        this.addToCart = addToCart;
    }

    public int getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", clicks=" + clicks +
                ", addToCart=" + addToCart +
                ", checkOut=" + checkOut +
                ", date=" + date +
                '}';
    }
}
