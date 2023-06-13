package za.ac.cput.factory;

import za.ac.cput.domain.Base;
import za.ac.cput.util.Helper;
/* BaseFactory.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
public class BaseFactory {

    public static Base buildBase( Base.BaseCrust baseCrust, Base.BaseThickness baseThickness, Base.BaseTexture baseTexture, double basePrice){
        if(Helper.isNullOrEmpty(String.valueOf(baseCrust)) || Helper.isNullOrEmpty(String.valueOf(baseThickness)) || Helper.isNullOrEmpty(String.valueOf(baseTexture)) || Helper.isNullOrEmpty(String.valueOf(basePrice))){
            return null;
        }

        String baseId = Helper.generateId();

        Base b = new Base.Builder().setBaseId(baseId).setBaseCrust(baseCrust).setBaseThickness(baseThickness).setBaseTexture(baseTexture).setBasePrice(basePrice).build();
        return b;
    }
}
