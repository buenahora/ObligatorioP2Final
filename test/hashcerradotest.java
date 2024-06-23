import Classes.Cancion;
import Classes.Exceptions.HashExceptions.DuplicateKeyHash;
import uy.edu.um.prog2.adt.closedhash.ClosedHashImpl;
import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.closedhash.DuplicateKey;

import static org.junit.Assert.*;
public class hashcerradotest {
    ClosedHashImpl<Integer, String> hash;
    @Before
    public void setup(){
        hash = new ClosedHashImpl<>(1000);
    }
    @Test
    public void testInsertar() throws DuplicateKey {
        hash.insertar(1, "primero");
        assertEquals(1,hash.getSize());
        hash.insertar(3, "segundo");
        assertEquals(2,hash.getSize());
    }

    @Test(expected = DuplicateKey.class)
    public void testInsertarDuplicado() throws DuplicateKey {
        hash.insertar(1, "Primero");
        hash.insertar(1, "Primero");

    }
    @Test
    public void testPertenece() throws DuplicateKey {
        hash.insertar(10, "Primero");
        hash.insertar(5, "Segundo");
        hash.insertar(7, "Tercero");
        assertTrue(hash.contains(10));
        assertTrue(hash.contains(5));
        assertTrue(hash.contains(7));
        assertFalse(hash.contains(3));
    }
    @Test
    public void testEliminar() throws DuplicateKey {
        hash.insertar(10, "Primero");
        hash.insertar(5, "Segundo");
        hash.insertar(7, "Tercero");
        hash.delete(10);
        assertFalse(hash.contains(10));
        hash.delete(5);
        assertFalse(hash.contains(5));
        hash.delete(7);
        assertFalse(hash.contains(7));
    }
    @Test
    public void testExpandirTabla() throws DuplicateKey {
        for (int i = 0; i < 1000; i++) {
            hash.insertar(i, "Cancion" + i);
        }
        assertEquals(1000, hash.getSize());

        hash.insertar(1000, "Cancion1000");
        assertEquals(1001, hash.getSize());
    }
}
