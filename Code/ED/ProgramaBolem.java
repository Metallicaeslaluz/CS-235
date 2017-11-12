import ed.edl.ListaSE; //package
import java.util.PriorityQueue;

public class ProgramaBolem
{
    PriorityQueue<Pedido> registro;
    public ProgramaBolem(){
        registro = new PriorityQueue<Pedido>();
        
        registrarPedido(new Pedido("Minorista",100));
        registrarPedido(new Pedido("Minorista",10));
        registrarPedido(new Pedido("Mayorista",1000));
        registrarPedido(new Pedido("Minorista",20));
        registrarPedido(new Pedido("Mayorista",2000));
    }
    public void registrarPedido(Pedido pedido){
        registro.add(pedido);
    }
    public ListaSE<Pedido> listaPedidos(){
        ListaSE<Pedido> listaAtencion = new ListaSE<Pedido>();
        while(!registro.isEmpty()){
           listaAtencion.insertar(registro.poll());//decolar el pedido de registro y colocarlo en 
           //la lista
        }
        System.out.println(listaAtencion);
        return listaAtencion;
    }
    
    
    
    
    
}
