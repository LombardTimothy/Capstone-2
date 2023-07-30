package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Base;
import za.ac.cput.factory.BaseFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
/* BaseServiceImplTest.java
 Author: Timothy Lombard (220154856)
 Date: 30th July (last updated) 2023
*/

@SpringBootTest
class BaseServiceImplTest {

    @Autowired
    private BaseServiceImpl service;

    private static Base b = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THICK, Base.BaseTexture.CRISPY, 26);
    private static Base b2 = BaseFactory.buildBase( Base.BaseCrust.NON_CRUSTY, Base.BaseThickness.THICK, Base.BaseTexture.CRISPY, 18);

    @Test
    public void a_base_create(){
        Base created = service.create(b);
        Base created1 = service.create(b2);
        assertEquals(b.getBaseId(), created.getBaseId());
        assertEquals(b2.getBaseId(), created1.getBaseId());
        System.out.println(created + "\n" + created1 );

    }

    @Test
    public void b_base_read(){
        Base read = service.read(b.getBaseId());
        Base read1 = service.read(b2.getBaseId());
        assertNotNull(read);
        assertNotNull(read1);
        System.out.println("Read " + read + "\n" + read1 );
    }

    @Test
    public void c_base_update(){
        Base newBase = new Base.Builder().copy(b2).setPrice(22).build();
        Base updated = service.update(newBase);
        assertEquals(newBase.getPrice(), updated.getPrice());
        System.out.println(updated);
    }

    @Disabled
    @Test
    public void d_base_delete(){
        boolean deleted = service.delete(b.getBaseId());
        assertTrue(deleted);
        System.out.println("Delete " + true);//deleted
    }

    @Test
    public void e_base_getAll(){
        System.out.println(service.getAll());

    }

}