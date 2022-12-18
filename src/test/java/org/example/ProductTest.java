package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getId() {
        Product pr = new Product(1,"Computer", 12.99, true);
        int id = 1;
        Assertions.assertEquals(id, pr.getId());
    }

    @Test
    void getPrice() {
        Product pr = new Product(1,"Computer", 12.99, true);
        double price= 12.99;
        Assertions.assertEquals(price, pr.getPrice());
    }

    @Test
    void getName() {
        Product pr = new Product(1,"Computer", 12.99, true);
        String str = "Computer";
        Assertions.assertEquals(str, pr.getName());
    }

    @Test
    void setName() {
        Product pr = new Product(1,"Computer", 12.99, true);
        String str = "Phone";

        pr.setName("Phone");
        Assertions.assertEquals(str, pr.getName());
    }

    @Test
    void setId() {
        Product pr = new Product(1,"Computer", 12.99, true);
        int id = 2;

        pr.setId(2);
        Assertions.assertEquals(id, pr.getId());
    }

    @Test
    void setPrice() {
        Product pr = new Product(1,"Computer", 12.99, true);
        double price= 15.00;

        pr.setPrice(15.00);
        Assertions.assertEquals(price, pr.getPrice());
    }

    @Test
    void isPromotional() {
        Product pr = new Product(1,"Computer", 12.99, true);
        Assertions.assertEquals(true, pr.isPromotional());
    }
}