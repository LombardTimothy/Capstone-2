package za.ac.cput.factory;
/*
DriverFactoryTest.java
Author: Azhar Allie Mohammed (217250513)
Date: 04/04/2023
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Driver;

import static org.junit.jupiter.api.Assertions.*;

class DriverFactoryTest {
    @Test
    public void test(){
        Driver driver = DriverFactory.createDriver();
        assertNotNull(driver);
    }

}