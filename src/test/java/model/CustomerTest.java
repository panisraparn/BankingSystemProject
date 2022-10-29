package model;

import ku.cs.models.Customer;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    void testGenerrateCtmid(){
        //gennerate ctm_id
        Customer randomCtm_id = new Customer("0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
        String ctm_idStr = randomCtm_id.generateCtm_id();
        System.out.println("ctm_idStr1" + ctm_idStr);
    }


}
