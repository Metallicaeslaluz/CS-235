

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ed.edl.ListaSE;

public class P_28Test
{
    @Test
    public void comprobarReporte(){
        ListaSE<String> registro = new ListaSE<String>();
        registro.insertar("hola?");
        registro.insertar("hola?");
        registro.insertar("hola?");
        registro.insertar("quien es la llama que llama?");
        registro.insertar("quien es la llama que llama?");
        registro.insertar("hola?");
        registro.insertar("quien es la llama que llama?");
        registro.insertar("quien es la llama que llama?");
        
        ListaSE<String> reporte = new ListaSE<String>();
        reporte.insertar("La llama 3");
        reporte.insertar("La llama 2");
        reporte.insertar("La llama 4");
        reporte.insertar("La llama 1");
        
        P_28 p_28 = new P_28();
        
        System.out.println(p_28.getReporte(registro));
        assertEquals(true, reporte.toString().equals(p_28.getReporte(registro).toString()));
        
    }
}
