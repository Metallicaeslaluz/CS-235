

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MapaTest
{
    @Test
    public void testListaPueblos(){
        Mapa map = new Mapa();
        Pueblo p1 = new Pueblo("Notar",0);
        Pueblo p2 = new Pueblo("NejoCo",15);
        Pueblo p3 = new Pueblo("NoAs",30);
        Pueblo p4 = new Pueblo("DillaR",60);
        Pueblo p5 = new Pueblo("Onom",40);
        Pueblo p6 = new Pueblo("ABo",50);
        Pueblo p7 = new Pueblo("Noel",10);
        Pueblo p8 = new Pueblo("NoRe",20);
        Pueblo p9 = new Pueblo("MaPu",100);
        Pueblo p10 = new Pueblo("DoPar",35);
        Pueblo p11 = new Pueblo("TeraPan",40);
        Pueblo p12 = new Pueblo("GreTi",20);
        map.agregarPueblo(p1,p2);
        map.agregarPueblo(p2,p3);
        map.agregarPueblo(p2,p4);
        map.agregarPueblo(p4,p5);
        map.agregarPueblo(p5,p6);
        map.agregarPueblo(p1,p7);
        map.agregarPueblo(p7,p8);
        map.agregarPueblo(p7,p9);
        map.agregarPueblo(p9,p10);
        map.agregarPueblo(p9,p11);
        map.agregarPueblo(p11,p12);
        
        System.out.println(map.getListaPueblos(120));
        //System.out.println(map.cuencaBora.getRamas());
        assertEquals("[Notar, NejoCo, DillaR, Onom]",map.getListaPueblos(120).toString());
        
    }
}
