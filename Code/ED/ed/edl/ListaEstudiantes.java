package ed.edl;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ListaEstudiantes
{
    ArrayList<Estudiante> lista;
    public ListaEstudiantes(){
        lista=new ArrayList<Estudiante>();
        lista.add(new Estudiante("Zedd Meals",20160354,6457));
        lista.add(new Estudiante("Lionel Messi",20160334,6453));
        lista.add(new Estudiante("Bob Mett",20170304,6777));
        lista.add(new Estudiante("Ana Perez",20170504,7742));
        lista.add(new Estudiante("Ana Perez",20160444,7742));
    }
    
    public void mostrarListaOrdenada(){
        PriorityQueue<Estudiante> colaPriori = new PriorityQueue<Estudiante>();
        System.out.println("...antes de ordenar");
        for(Estudiante e: lista){
            //add=encolar=offer
            colaPriori.add(e);
            System.out.println(e);
        }
        System.out.println("...despues de ordenar");
        while(!colaPriori.isEmpty()){
            System.out.println(colaPriori.poll());//poll()=decolar()
            //frente() = peek()
        }
    }
    
    public boolean buscarEstudiante(Estudiante e){
        return lista.contains(e);
    }    
}
