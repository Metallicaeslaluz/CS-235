
import java.util.ArrayList;

public class ListaEstudiantes
{
    ArrayList<Estudiante> lista;
    public ListaEstudiantes(){
        lista=new ArrayList<Estudiante>();
        lista.add(new Estudiante("Bob Mett",20170304,6777));
        lista.add(new Estudiante("Ana Perez",20170504,7742));
        lista.add(new Estudiante("Lionel Messi",20160334,6453));
    }
    
    public boolean buscarEstudiante(Estudiante e){
        return lista.contains(e);
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
