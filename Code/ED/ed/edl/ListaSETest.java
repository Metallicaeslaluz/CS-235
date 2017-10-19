package ed.edl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaSETest
{
    @Test
    public void eliminarUnDatoTAdelante(){
        ListaSE<Integer> nums = new ListaSE<Integer>();
        nums.insertar(12); nums.insertar(5); nums.insertar(66);// nums = [12, 5, 66]
        nums.eliminar(0);
        assertEquals("[5, 66]",nums.toString());
    }    
    
    @Test
    public void eliminarUnDatoTentreMedioOExtremoDerecho(){
        ListaSE<Integer> nums = new ListaSE<Integer>();
        nums.insertar(12); nums.insertar(5); nums.insertar(66);//[12, 5, 66]
        nums.eliminar(1);
        assertEquals("[12, 66]",nums.toString());
    }    
    
    @Test
    public void eliminarUltimoDato(){
        ListaSE<Integer> nums = new ListaSE<Integer>();
        nums.insertar(12); nums.insertar(5); nums.insertar(66);//[12, 5, 66]
        nums.eliminar(2);
        assertEquals("[12, 5]",nums.toString());
    }
    
    @Test
    public void eliminarDatoPorEquals(){
        ListaSE<Estudiante> listaEs = new ListaSE<Estudiante>();
        listaEs.insertar(new Estudiante("Bob Mett",20170304,6777));
        listaEs.insertar(new Estudiante("Ana Perez",20170504,7742));
        listaEs.insertar(new Estudiante("Lionel Messi",20160334,6453));
        
        Estudiante esEliminar = new Estudiante("Cristiano Messi",20160334,6453);
        listaEs.eliminar(esEliminar);
        
        assertEquals(3,listaEs.longitud());
    }
    
    @Test
    public void insertarLista(){
       ListaSE<Point2D> recta=new ListaSE<Point2D>();
       recta.insertar(new Point2D(1,2));
       recta.insertar(new Point2D(2,2));
       recta.insertar(new Point2D(3,3));    
       assertEquals(recta.toString(),"[(1,2), (2,2), (3,3)]");
    }
    
    @Test
    public void insertarListaDeLista(){
       ListaSE<Point2D> recta=new ListaSE<Point2D>();
       recta.insertar(new Point2D(1,2));
       recta.insertar(new Point2D(2,2));
       recta.insertar(new Point2D(3,3)); 
       ListaSE<ListaSE<Point2D>> rectas=new ListaSE<ListaSE<Point2D>>();
       rectas.insertar(recta);
       rectas.insertar(recta);
       assertEquals(rectas.toString(),"[[(1,2), (2,2), (3,3)], [(1,2), (2,2), (3,3)]]");
    }
    
    public class Point2D{
        int x,y;
        public Point2D(int x, int y){
            this.x=x; this.y=y;
        }
        public String toString(){
            return "("+x+","+y+")";
        }
    }
    
    public class Estudiante{
        private int codigoSis;
        private String nombre;
        private int ci;
        public Estudiante(String nombre, int codigoSis, int ci){
            this.nombre=nombre;
            this.codigoSis=codigoSis;
            this.ci=ci;
        }
        
        @Override
        public boolean equals(Object o){
            boolean equals = false;//same=iguales
            if(o instanceof Estudiante){
                Estudiante otro = (Estudiante)(o);
                equals = otro.nombre.equals(this.nombre) && otro.codigoSis==this.codigoSis &&
                         otro.ci==this.ci;
            }
            return equals;
        }
    }
}
