package model;

import ku.cs.models.DocumentTOB;
import org.junit.jupiter.api.Test;

public class DocumentTOBTest {
    @Test
    void testRandomDtb10Digit(){
        DocumentTOB randDtb_id = new DocumentTOB("");
        randDtb_id.generateDtb_id();
        System.out.println("result : "+ randDtb_id.getDtb_id());
    }
}
