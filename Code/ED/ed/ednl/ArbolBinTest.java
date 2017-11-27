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
        
        assertEquals("[[1, 2, 4], [1, 2, 5], [1, 3]]", arbol.getRamas().toString());
    }
    
    @Test
    public void ramaMasCorta(){
        ArbolBin<Integer> arbol = new ArbolBin<Integer>(60);
        arbol.insertarPares(60,30);
        arbol.insertarPares(60,63);
        arbol.insertarPares(30,20);
        arbol.insertarPares(20,18);
        arbol.insertarPares(18,10);
        arbol.insertarPares(30,54);
        arbol.insertarPares(54,42);
        arbol.insertarPares(42,35);
        arbol.insertarPares(42,47);
        arbol.insertarPares(35,40);
        arbol.insertarPares(63,74);
        arbol.insertarPares(74,70);
        arbol.insertarPares(74,87);
        arbol.insertarPares(87,91);
        assertEquals("[60, 63, 74, 70]", arbol.getRamaMasCorta().toString());
    }
    
    @Test
    public void revertirRamaMasCortav_1(){
        ArbolBin<Integer> arbol = new ArbolBin<Integer>(60);
        arbol.insertarPares(60,30);
        arbol.insertarPares(60,63);
        arbol.insertarPares(30,20);
        arbol.insertarPares(20,18);
        arbol.insertarPares(18,10);
        arbol.insertarPares(30,54);
        arbol.insertarPares(54,42);
        arbol.insertarPares(42,35);
        arbol.insertarPares(42,47);
        arbol.insertarPares(35,40);
        arbol.insertarPares(63,74);
        arbol.insertarPares(74,70);
        arbol.insertarPares(74,87);
        arbol.insertarPares(87,91);
        System.out.println(arbol.getRamaMasCorta());
        arbol.revertirRamaMasCorta();
        System.out.println(arbol.getRamaMasCorta());
        assertEquals("[70, 74, 63, 60]", arbol.getRamaMasCorta().toString());
    }
    
    
    
    
    
    
    
}
