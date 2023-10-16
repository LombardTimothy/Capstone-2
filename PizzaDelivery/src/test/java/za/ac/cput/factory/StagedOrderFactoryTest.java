package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
class StagedOrderFactoryTest {


        private static Address address = AddressFactory.buildAddress("21", "Jump Street", "West Olmstead", "Bikini Bottom", "California", "Crownlands", "0007", AddressType.RESIDENTIAL_HOME);

        private static Customer customer = CustomerFactory.buildCustomer("Thomas", "Lombardi","075 452 8339", address);

        private static LocalDate date = LocalDate.of(2023, 9, 17);

        private static LocalTime time = LocalTime.now();
        private static Pizzeria pizzeria = PizzeriaFactory.buildPizzaria("Hill Crest","Hotel Transalvania");
        private static Base base = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THIN, Base.BaseTexture.CRISPY, 20);
        private static Pizza pizza = PizzaFactory.createPizza(base, "Magherita pizza", "tomato sauce with fresh tomatoes, mozzarella cheese and basil which represent the colours of the Italian flag – white cheese, green basil and red tomato.", Pizza.Size.LARGE, false, 76, pizzeria);

        @Test
        public void StagedOrder_test(){
            StagedOrder order = StagedOrderFactory.createOrder( date, time,  customer,"2",pizza,40, StagedOrder.OrderStatus.SHIPPED, pizzeria);
            System.out.println(order.toString());
            assertNotNull(order);
        }

        @Test
        public void order_test_fail(){
            StagedOrder order = StagedOrderFactory.createOrder( date, time,  customer,"2",pizza,40, StagedOrder.OrderStatus.SHIPPED, pizzeria);
            System.out.println(order.toString());
            //assertNotNull(order);
            assertEquals(3, order.getCreateDate());
        }


        @Test
        public void order_equality_test(){
            Order order = OrderFactory.createOrder( date, time, customer, Order.OrderStatus.CLOSED, pizzeria);
            Order order1 = OrderFactory.createOrder( date,time, customer, Order.OrderStatus.NEW, pizzeria);
            if(order.equals(order1)){
                System.out.println("Both objects are equal");//true
            }else
                System.out.println("Both objects are not equal");//false
        }
    }
