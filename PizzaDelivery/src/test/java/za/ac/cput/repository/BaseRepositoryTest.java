package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Base;
import za.ac.cput.domain.Base;
import za.ac.cput.factory.BaseFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
/* BaseRepositoryTest.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
class BaseRepositoryTest {

    private static BaseRepository repo = BaseRepository.getBaseRepo();

    private static Base b = BaseFactory.buildBase( Base.BaseCrust.CRUSTY, Base.BaseThickness.THICK, Base.BaseTexture.CRISPY, 26);
    private static Base b2 = BaseFactory.buildBase( Base.BaseCrust.NON_CRUSTY, Base.BaseThickness.THICK, Base.BaseTexture.CRISPY, 18);

    @Test
    public void a_base_create(){
        Base created = repo.create(b);
        Base created1 = repo.create(b2);
        System.out.println(created + "\n" + created1 );
        assertNotNull(b);
        assertNotNull(b2);

    }

    @Test
    public void b_base_read(){
        Base read = repo.read(b.getBaseId());
        Base read1 = repo.read(b2.getBaseId());
        assertNotNull(read);
        assertNotNull(read1);
        System.out.println("Read " + read + "\n" + read1 );
    }

    @Test
    public void c_base_update(){
        Base updated = new Base.Builder().copy(b2).setBasePrice(22).build();
        assertNotNull(repo.update(updated));
        System.out.println(updated);
    }

    @Test
    public void d_base_delete(){
        boolean deleted = repo.delete(b.getBaseId());
        assertTrue(deleted);
        System.out.println("Delete " + true);//deleted
    }

    @Test
    public void e_base_getAll(){
        System.out.println(repo.getAll());

    }


}