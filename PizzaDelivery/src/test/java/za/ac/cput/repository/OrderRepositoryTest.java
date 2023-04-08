package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.OrderFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/* OrderRepositoryTest.java
 Author: Timothy Lombard (220154856)
 Date: 8th April (last updated) 2023
*/

    @TestMethodOrder(MethodOrderer.MethodName.class)//runs the test cases in alphabetical order


    class OrderRepositoryTest {

        private static OrderRepository orderRepo = OrderRepository.getRepo();
        private static Address address = AddressFactory.buildAddress("9", "11th Road, HealthField", "Cape Town", "7945", "Western Cape", "South Africa");
        private static Customer customer = CustomerFactory.buildCustomer("Thomas", "Lombardi", address);
        private static LocalDate date = LocalDate.of(2023, 4, 17);
        private static LocalDate date1 = LocalDate.of(2023, 4, 29);
        private static LocalDate date2 = LocalDate.of(2023, 4, 8);
        private static Order order = OrderFactory.buildOrder(date, customer);
        private static Order order1 = OrderFactory.buildOrder(date1, customer);
        private static Order order2 = OrderFactory.buildOrder(date2, customer);



        @Test
        public void a_order_create(){
            Order created = orderRepo.create(order);
            Order created1 = orderRepo.create(order1);
            Order created2 = orderRepo.create(order2);
            System.out.println(created + "\n" + created1 + "\n" + created2);
            assertNotNull(order);
            assertNotNull(order1);
            assertNotNull(order2);
        }

        @Test
        public void b_order_read(){
            Order read = orderRepo.read(order.getOrderId());
            Order read1 = orderRepo.read(order1.getOrderId());
            Order read2 = orderRepo.read(order2.getOrderId());
            assertNotNull(read);
            assertNotNull(read1);
            assertNotNull(read2);
            System.out.println("Read " + read + "\n" + read1 + "\n" + read2);
        }

        @Test
        public void c_order_update(){
            LocalDate dateChange = LocalDate.of(2023, 4, 6);
            Order updated = new Order.Builder().copy(order2).setCreateDate(dateChange).setCustomer(customer).build();
            assertNotNull(orderRepo.update(updated));
            System.out.println(updated);
        }

        @Test
        public void d_order_delete(){
            boolean deleted = orderRepo.delete(order.getOrderId());
            assertTrue(deleted);
            System.out.println("Delete " + true);//deleted
        }

        @Test
        public void e_order_getAll(){
            System.out.println(orderRepo.getAll());

        }




    }

