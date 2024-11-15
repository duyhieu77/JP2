package Entity;

import java.time.LocalDate;

public class Statistic {
    private int id;
    private double percentClick;
    private double percentAddToCart;
    private double percentCheckOut;
    private LocalDate date;

    public Statistic(int id, double percentClick, double percentAddToCart, double percentCheckOut, LocalDate date) {
        this.id = id;
        this.percentClick = percentClick;
        this.percentAddToCart = percentAddToCart;
        this.percentCheckOut = percentCheckOut;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPercentClick() {
        return percentClick;
    }

    public void setPercentClick(double percentClick) {
        this.percentClick = percentClick;
    }

    public double getPercentAddToCart() {
        return percentAddToCart;
    }

    public void setPercentAddToCart(double percentAddToCart) {
        this.percentAddToCart = percentAddToCart;
    }

    public double getPercentCheckOut() {
        return percentCheckOut;
    }

    public void setPercentCheckOut(double percentCheckOut) {
        this.percentCheckOut = percentCheckOut;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return id + ";" + String.format("%.2f", percentClick) + ";" +
                String.format("%.2f", percentAddToCart) + ";" +
                String.format("%.2f", percentCheckOut) + ";" +
                date;
    }
}