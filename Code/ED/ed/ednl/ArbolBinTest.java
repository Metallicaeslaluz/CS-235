package ed.ednl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArbolBinTest
{
    @Test
    public void getRamas(){
        ArbolBin<Integer> arbol = new ArbolBin<Integer>();
        for(int num = 1; num <= 5; num++) arbol.insertarAmplitud(num);
        System.out.println(arbol.getRamas());
        assertEquals("[[1, 2, 4], [1, 2, 5], [1, 3]]", arbol.getRamas().toString());
    }
}
