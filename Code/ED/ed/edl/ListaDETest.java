package ed.edl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ListaDETest
{
    @Test
    public void comprobarListaVacia(){
        ListaDE<Integer> lista=new ListaDE<Integer>();
        assertEquals("[]",lista.toString());
    }
    
    @Test
    public void insertarElementos(){
        ListaDE<Integer> lista=new ListaDE<Integer>();
        lista.insertar(1);
        lista.insertar(20);
        lista.insertar(3);
        assertEquals("[1, 20, 3]",lista.toString());
    }
    
    @Test
    public void eliminarInicio(){
        ListaDE<Integer> lista=new ListaDE<Integer>();
        lista.insertar(1);
        lista.insertar(20);
        lista.insertar(3);
        lista.eliminar(0);
        assertEquals("[20, 3]",lista.toString());
    }
    
    @Test
    public void eliminarDatoEnMedio(){
        ListaDE<Integer> lista=new ListaDE<Integer>();
        lista.insertar(1);
        lista.insertar(20);
        lista.insertar(3);
        
        lista.eliminar(1);
        
        assertEquals("[1, 3]",lista.toString());
    }
}
