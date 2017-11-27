

public class Pueblo
{
    private String nombre;
    private int tiempo;
    public Pueblo(String nombre, int tiempo){
        this.nombre = nombre;
        this.tiempo = tiempo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getTiempo(){
        return tiempo;
    }
    
    public String toString(){
        return nombre;
    }
    @Override 
    public boolean equals(Object otro){
        Pueblo pueblo = (Pueblo)otro;
        return this.nombre.equals(pueblo.nombre);
    }
}
