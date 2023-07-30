package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Base;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
/* BaseFactoryTest.java
 Author: Timothy Lombard (220154856)
 Date: 30th July (last updated) 2023
*/
class BaseFactoryTest {

    private static Base b = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THICK, Base.BaseTexture.CRISPY, 26);
    private static Base b2 = BaseFactory.buildBase( Base.BaseCrust.NON_CRUSTY, Base.BaseThickness.THICK, Base.BaseTexture.CRISPY, 18);

    @Test
    public void success(){
        System.out.println(b.toString());
        assertNotNull(b);
    }

    @Test
    public void timeoutFail_test() {
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Thread.sleep(2000);
        });
        String crust = "crusty";
        String thick = "Thick";
        String text = "Chewy";
        double price = 17;
        assertEquals(crust, b.getCrust());
        assertEquals(thick, b.getThickness());
        assertEquals(text, b.getTexture());
        assertEquals(price, b.getPrice());
        System.out.println(b.toString());
    }

    @Disabled("Disabled test")
    @Test
    public void base_disable_test(){
        System.out.println(b.toString());
        assertNull(b);

    }

    @Test
    public void base_equality_test(){
        if(b.equals(b2)){
            System.out.println("Both objects are equal");//true

        }else
            System.out.println("Both objects are not equal");//false

    }


}