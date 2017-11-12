
public class Pedido implements Comparable<Pedido>
{
    private int cantidad;
    private String tipo;
    public Pedido(String tipo, int cantidad){
        this.tipo = tipo;
        this.cantidad = cantidad;
    }
    
    public int cantidad(){
        return cantidad;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public int compareTo(Pedido otro){//another
       int criterio = 0;
       if(this.tipo.equals("Mayorista")&&otro.tipo.equals("Minorista"))
            criterio = -1;
       if(this.tipo.equals("Minorista")&&otro.tipo.equals("Mayorista"))
            criterio = 1;
       return criterio;
    }
    
    public String toString(){
        return tipo+"  "+cantidad;
    }
    
    
    
    
    
    
    
    
    
    
    
}
