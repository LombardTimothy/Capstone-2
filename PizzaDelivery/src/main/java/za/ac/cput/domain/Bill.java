package za.ac.cput.domain;

public class Bill {
    private String orderDateAndTime;
    private String orderId;
    private String menuItems;
    private Double quantity;
    private Double unitPrice;
    private Double subtotal;
    private Double taxes;
    private Double discounts ;
    private Double total;
    private Bill(Builder builder){
        this.orderDateAndTime = builder.orderDateAndTime;
        this.orderId = builder.orderId;
        this.menuItems = builder.menuItems;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
        this.subtotal = builder.subtotal;
        this.taxes = builder.taxes;
        this.discounts = builder.discounts;
        this.total = builder.total;

    }
    public String getOrderDateAndTime() {
        return orderDateAndTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getMenuItems() {
        return menuItems;
    }


    public Double getQuantity() {
        return quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Double getTaxes() {
        return taxes;
    }

    public Double getDiscounts() {
        return discounts;
    }

    public Double getTotal() {
        return total;
    }


    @Override
    public String toString() {
        return "Bill{" +
                "orderDateAndTime='" + orderDateAndTime + '\'' +
                ", orderId='" + orderId + '\'' +
                ", menuItems='" + menuItems + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", subtotal=" + subtotal +
                ", taxes=" + taxes +
                ", discounts=" + discounts +
                ", total=" + total +
                '}';
    }

    public static class Builder{
        private String orderDateAndTime;
        private String orderId;
        private String menuItems;
        private Double quantity;
        private Double unitPrice;
        private Double subtotal;
        private Double taxes;
        private Double discounts ;
        private Double total;

        public Builder setOrderDateAndTime(String orderDateAndTime) {
            this.orderDateAndTime = orderDateAndTime;
            return this;
        }

        public Builder setOrderId(String orderId) {
            this.orderId = this.orderId;
            return this;
        }

        public Builder setMenuItems(String menuItems) {
            this.menuItems = menuItems;
            return this;
        }


        public Builder setQuantity(Double quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setUnitPrice(Double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder setSubtotal(Double subtotal) {
            this.subtotal = subtotal;
            return this;
        }

        public Builder setTaxes(Double taxes) {
            this.taxes = taxes;
            return this;
        }

        public Builder setDiscounts(Double discounts) {
            this.discounts = discounts;
            return this;
        }

        public Builder setTotal(Double total) {
            this.total = total;
            return this;
        }

        public Builder copy(Bill bill){
            this.orderDateAndTime = bill.orderDateAndTime;
            this.orderId = bill.orderId;
            this.menuItems = bill.menuItems;
            this.quantity = bill.quantity;
            this.unitPrice = bill.unitPrice;
            this.subtotal = bill.subtotal;
            this.taxes = bill.taxes;
            this.discounts = bill.discounts;
            this.total = bill.total;
            return this;
        }
        public Bill build(){
            return new Bill(this);
        }
    }
}


