package ed.edl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListaCSETest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaCSETest
{
    @Test
    public void insertarPorDefecto(){
        ListaCSE<String> lista=new ListaCSE<String>();
        lista.insertar("ab");
        lista.insertar("cd");
        lista.insertar("ed");
        assertEquals("[ab, cd, ed]",lista.toString());
        
    }
    @Test
    public void eliminarPrimerElemento(){
        ListaCSE<String> lista=new ListaCSE<String>();
        lista.insertar("ab");
        lista.insertar("cd");
        lista.insertar("ed");
        lista.eliminar(0);
        assertEquals("[cd, ed]",lista.toString());
    }
    @Test
    public void eliminarListaDeUnSoloElemento(){
        ListaCSE<String> lista=new ListaCSE<String>();
        lista.insertar("ab");
        lista.eliminar(0);
        assertEquals("[]",lista.toString());
    }
    @Test
    public void eliminarElementoEnMedio(){
        ListaCSE<String> lista=new ListaCSE<String>();
        lista.insertar("ab");
        lista.insertar("cd");
        lista.insertar("ed");
        lista.eliminar(1);
        assertEquals("[ab, ed]",lista.toString());
    }
    @Test
    public void eliminarUltimo(){
        ListaCSE<String> lista=new ListaCSE<String>();
        lista.insertar("ab");
        lista.insertar("cd");
        lista.insertar("ed");
        lista.eliminar(2);
        assertEquals("[ab, cd]",lista.toString());
    }
    
    
    
    
    
    
    
    
    
    
}
