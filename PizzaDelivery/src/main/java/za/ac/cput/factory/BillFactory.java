package za.ac.cput.factory;

import za.ac.cput.util.Helper;
import za.ac.cput.domain.Bill;

public class BillFactory {

    public static Bill createBill(String orderDateAndTime, String menuItems, Double quantity, Double unitPrice, Double subtotal, Double taxes, Double discounts, Double total){
        if(Helper.isNullOrEmpty(orderDateAndTime)|| Helper.isNullOrEmpty(menuItems)){
            return null;
        }

        if(Helper.isNullOrEmpty(String.valueOf(quantity)) || Helper.isNullOrEmpty(String.valueOf(unitPrice)) || Helper.isNullOrEmpty(String.valueOf(subtotal)) || Helper.isNullOrEmpty(String.valueOf(taxes)) || Helper.isNullOrEmpty(String.valueOf(discounts)) || Helper.isNullOrEmpty(String.valueOf(total))){
            return null;
        }

        String orderId = Helper.generateId();

        Bill em = new Bill.Builder().setOrderDateAndTime(orderDateAndTime).setOrderId(orderId).setMenuItems(menuItems)
                .setQuantity(quantity).setUnitPrice(unitPrice).setSubtotal(subtotal).setTaxes(taxes).setDiscounts(discounts)
                .setTotal(total)
                .build();
        return em;
    }


}
