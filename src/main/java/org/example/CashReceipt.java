package org.example;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CashReceipt {
    private ArrayList<Purchase> checkList;
    private DiscountCard discountCard;

    public CashReceipt(ArrayList<Purchase> checkList, DiscountCard discountCard) {
        this.checkList = checkList;
        this.discountCard = discountCard;
    }

    public StringBuilder printCashReceipt(){
        StringBuilder cash = new StringBuilder("               CASH RECEIPT                 \n" +
                                               "--------------------------------------------\n" +
                                               "QTY     Name            Price          Total\n");
        String str;
        for (Purchase purchase : checkList) {
             str = purchase.getQuantity() + "    " + purchase.getProduct().getName()
                    + "      " + purchase.getProduct().getPrice() +
                    "      " +
                    purchase.getTotalPrice() + "\n";
            cash.append(str);
        }
        double total = 0;

        for(Purchase purchase: checkList) {
            total += purchase.getTotalPrice();
        }

        cash.append("--------------------------------------------\n");

        double discount = total;
        if(discountCard != null){
            total = (1.0 - discountCard.getValue()) * total;
            discount -=total;
            str = "DISCOUNT                  " + new DecimalFormat("#0.00").format(discount) + "\n";
            cash.append(str);
        }

        str = "TOTAL                        " + new DecimalFormat("#0.00").format(total);
        cash.append(str);

        return cash;
    }
}
