package org.example;

public class Product {
    private int id;
    private double price;
    private String name;
    private boolean promotional;

    public Product(int id, String name, double price, boolean promotional){
        this.id = id;
        this.price = price;
        this.name = name;
        this.promotional = promotional;
    }

    public int getId(){
        return id;
    }
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public boolean isPromotional() {
        return promotional;
    }

}
