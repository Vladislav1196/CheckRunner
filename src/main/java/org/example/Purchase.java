package org.example;

public class Purchase {
    private Product product;
    private int quantity;

    public Purchase(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public  double getTotalPrice(){
        double price = product.getPrice()*this.quantity;
        if(product.isPromotional())
            price -= 0.1 * price;
        return price;
    }
}

