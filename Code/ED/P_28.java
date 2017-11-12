import ed.edl.ListaSE;
import java.util.Stack;

public class P_28
{
    public ListaSE<String> getReporte(ListaSE<String> registro){
        ListaSE<String> reporte = new ListaSE<String>();
        Stack<Integer> pila = new Stack<Integer>();
        int ordenMsg = 1;
        for(int posMsg = 0; posMsg < registro.longitud(); posMsg++){
            if(registro.acceder(posMsg).equals("hola?")){
                pila.push(ordenMsg);
                ordenMsg++;
            }else reporte.insertar("La llama "+pila.pop());
        }
        return reporte;
    }
    
    
    
    
    
    
    
    
    
    
}
