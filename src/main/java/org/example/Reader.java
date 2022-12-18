package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Reader {
    private static int id;
    private static int quantity;

    static DiscountCard readDiscountCardFromCommandLine(String[] args, ArrayList<DiscountCard> cards){
        int cardId = 0;
        for (String arg : args) {
            String[] tmp = arg.split("-");
            try {
                if (tmp[0].equals("Card")) {
                    cardId = Integer.parseInt(tmp[1]);
                } else continue;
            } catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
            for (DiscountCard card : cards) {
                if (cardId == card.getId()) {
                    return card;
                }
            }
        }
        return null;
    }

    static ArrayList<Purchase>  readProductsFromCommandLine(String[] args, ArrayList<Product> products) {
        ArrayList<Purchase> list = new ArrayList<>();
        for (String arg : args) {
            String[] tmp = arg.split("-");
            id = 0;
            quantity = 0;
            try {
                id = Integer.parseInt(tmp[0]);
                quantity = Integer.parseInt(tmp[1]);
            } catch (NumberFormatException nfe) {
                if(!tmp[0].equals("Card"))
                    System.out.println("NumberFormatException: " + nfe.getMessage());
            }

            for (Product product : products) {
                if (id == product.getId()) {
                    list.add(new Purchase(product, quantity));
                }
            }
        }
        return list;
    }
    static void writeToFile(String path, StringBuilder str){

        try(FileWriter writer = new FileWriter(path, false))
        {
            writer.write(str.toString());
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    static String[] readFromFile(String path){

        String str = "";
        try(FileReader reader = new FileReader(path))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                str += Character.toString((char)c);
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return str.split(" ");
    }

    static boolean isFilePath(String[] args) {
        return args.length == 1 && args[0].endsWith(".txt");
    }
}
