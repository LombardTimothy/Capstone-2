package za.ac.cput.domain;

import java.util.Objects;

/* Base.java
 Entity for the Base
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/

public class Base {


    public enum BaseCrust{
        CRUSTY, NON_CRUSTY
    }

    public enum BaseThickness{
        THIN, THICK
    }
    public enum BaseTexture{
        LIGHT, CHEWY, DOUGHY, CRISPY, STRETCHY
    }


    private String baseId;
    private BaseCrust baseCrust;
    private BaseThickness baseThickness;
    private BaseTexture baseTexture;
    private double basePrice;

    private Base(){

    }

    private Base(Base.Builder builder){
        this.baseId = builder.baseId;
        this.baseCrust = builder.baseCrust;
        this.baseThickness = builder.baseThickness;
        this.baseTexture = builder.baseTexture;
        this.basePrice = builder.basePrice;
    }

    public String getBaseId() {
        return baseId;
    }

    public BaseCrust getBaseCrust() {
        return baseCrust;
    }

    public BaseThickness getBaseThickness() {
        return baseThickness;
    }

    public BaseTexture getBaseTexture() {
        return baseTexture;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public static class Builder {
        private String baseId;
        private BaseCrust baseCrust;
        private BaseThickness baseThickness;
        private BaseTexture baseTexture;
        private double basePrice;


        public Base.Builder setBaseId(String baseId) {
            this.baseId = baseId;
            return this;
        }


        public Base.Builder setBaseCrust(BaseCrust baseCrust){
            this.baseCrust = baseCrust;
            return this;
        }

        public Base.Builder setBaseThickness(BaseThickness baseThickness){
            this.baseThickness = baseThickness;
            return this;
        }

        public Base.Builder setBaseTexture(BaseTexture baseTexture){
            this.baseTexture = baseTexture;
            return this;
        }

        public Base.Builder setBasePrice(double basePrice){
            this.basePrice = basePrice;
            return this;
        }


        public Base.Builder copy(Base base) {
            this.baseId = base.baseId;
            this.baseCrust = base.baseCrust;
            this.baseThickness = base.baseThickness;
            this.baseTexture = base.baseTexture;
            this.basePrice = base.basePrice;
            return this;
        }


        public Base build() {
            return new Base(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return Double.compare(base.basePrice, basePrice) == 0 && Objects.equals(baseId, base.baseId) && baseCrust == base.baseCrust && baseThickness == base.baseThickness && baseTexture == base.baseTexture;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseId, baseCrust, baseThickness, baseTexture, basePrice);
    }

    @Override
    public String toString() {
        return "Base{" +
                "baseId='" + baseId + '\'' +
                ", baseCrust=" + baseCrust +
                ", baseThickness=" + baseThickness +
                ", baseTexture=" + baseTexture +
                ", basePrice=" + basePrice +
                '}';
    }
}
