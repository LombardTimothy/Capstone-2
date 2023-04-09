package za.ac.cput.domain;

public class LoyaltyCustomer {
    private String loyaltyCustomerId;
    private String customerId;
    private Double loyaltyPoint;
    private String dateJoined;

    private LoyaltyCustomer(Builder builder){
        this.loyaltyCustomerId = builder.loyaltyCustomerId;
        this.customerId = builder.customerId;
        this.loyaltyPoint = builder.loyaltyPoint;
        this.dateJoined = builder.dateJoined;

    }
    public String getLoyaltyCustomerId() {
        return loyaltyCustomerId;
    }

    public Double getLoyaltyPoint() {
        return loyaltyPoint;
    }


    public String getDateJoined() {
        return dateJoined;
    }


    @Override
    public String toString() {
        return "LoyaltyCustomer{" +
                "LoyaltyCustomerId='" + loyaltyCustomerId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", loyaltyPoint=" + loyaltyPoint +
                ", dateJoined='" + dateJoined + '\'' +
                '}';
    }

    public static class Builder{

        private String loyaltyCustomerId;
        private String customerId;
        private Double loyaltyPoint;
        private String dateJoined;

        public Builder setLoyaltyCustomerId(String loyaltyCustomerId) {
            this.loyaltyCustomerId = this.loyaltyCustomerId;
            return this;
        }

        public Builder setCustomerId(String customerId) {
            this.customerId = this.customerId;
            return this;
        }

        public Builder setLoyaltyPoint(Double loyaltyPoint) {
            this.loyaltyPoint = loyaltyPoint;
            return this;
        }


        public Builder setDateJoined(String dateJoined) {
            this.dateJoined = dateJoined;
            return this;
        }


        public Builder copy(LoyaltyCustomer loyaltyCustomer){
            this.loyaltyCustomerId = loyaltyCustomer.loyaltyCustomerId;
            this.customerId = loyaltyCustomer.customerId;
            this.loyaltyPoint = loyaltyCustomer.loyaltyPoint;
            this.dateJoined = loyaltyCustomer.dateJoined;
            return this;
        }
        public LoyaltyCustomer build(){
            return new LoyaltyCustomer(this);
        }
    }
}

