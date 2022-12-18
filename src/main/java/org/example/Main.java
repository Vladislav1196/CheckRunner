package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1,"Mobile Phone", 12.99, false));
        products.add(new Product(2, "Computer", 89.65, true));
        products.add(new Product(3, "Printer", 45.00, false));

        ArrayList<DiscountCard> cards = new ArrayList<>();
        cards.add(new DiscountCard(1, "Alex",0.1));
        cards.add(new DiscountCard(2, "John", 0.2));

        String[] arguments = null;
        if(Reader.isFilePath(args)){
            arguments = Reader.readFromFile("E:\\input.txt");
        }
        else {
            arguments = args;
        }

        ArrayList<Purchase> purchases = Reader.readProductsFromCommandLine(arguments, products);
        DiscountCard usedCard = Reader.readDiscountCardFromCommandLine(arguments,cards);


        CashReceipt cashReceipt = new CashReceipt(purchases, usedCard);

        System.out.println(cashReceipt.printCashReceipt());

        Reader.writeToFile("E:\\text.txt",cashReceipt.printCashReceipt());
        String[] str = Reader.readFromFile("E:\\input.txt");



        //for (int i = 0; i<products.size(); i++){
        //    System.out.println(purchases.get(i).getProduct().getName() + " " +
        //            purchases.get(i).getQuantity());
        //}
        //System.out.println(usedCard != null ? usedCard.getName() : null);
        
    }
}