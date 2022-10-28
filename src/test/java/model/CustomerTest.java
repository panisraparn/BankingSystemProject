package model;

import ku.cs.models.Customer;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    @Test
    void testRandCtm_id(){
        Customer customer1 = new Customer("1104200178882","Panisra","Wongbubpa","image1","1","0999259459","home1","workplace1","123456789123456");
        customer1.setCtm_id();
        System.out.println(customer1.toString());
    }
}
