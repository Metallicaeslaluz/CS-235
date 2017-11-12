package ed.ednl;
import ed.edl.Cola;//package ed.edl.Cola
import ed.edl.ListaSE;

public class ArbolBin<T>
{
    private T raiz;
    private ArbolBin<T> izq,der;
    public ArbolBin(){
        raiz = null;
        izq = der = null;
    }
    
    public ArbolBin(T raiz){
        this.raiz = raiz;
        izq = der = null;
    }
    
    public void insertarAmplitud(T dato){
        if(estaVacio()){
            this.raiz = dato;
        }else{
            Cola<ArbolBin<T>> cola = new Cola<ArbolBin<T>>();
            boolean insertado = false;
            cola.encolar(this);
            ArbolBin<T> act;
            while(!insertado){
                act = cola.decolar();
                if(act.izq==null){
                    act.izq = new ArbolBin<T>(dato); insertado = true;
                }else if(act.der==null){
                    act.der = new ArbolBin<T>(dato); insertado = true;
                }
                if(act.izq!=null) cola.encolar(act.izq);
                if(act.der!=null) cola.encolar(act.der);
            }
        }
    }
    
    public void revertirRamaMasCorta(){
        ListaSE<ListaSE<T>> ramas;
    }
    
    public ListaSE<ListaSE<T>> getRamas(){
        ListaSE<ListaSE<T>> ramas = new ListaSE<ListaSE<T>>();
        ListaSE<T> rama = new ListaSE<T>();
        buscarRamas(this,rama,ramas);
        return ramas;
    }
    
    private void buscarRamas(ArbolBin<T> arbol, ListaSE<T> rama, ListaSE<ListaSE<T>> ramas){
        if(!arbol.estaVacio()){
            rama.insertar(arbol.raiz);
            if(arbol.izq == null && arbol.der == null) ramas.insertar(rama);
            else{
                if(arbol.izq!=null) 
                    buscarRamas(arbol.izq, rama.clonar(), ramas);
                if(arbol.izq!=null) 
                    buscarRamas(arbol.der, rama.clonar(), ramas);
            }
        }
    }
    
    public boolean estaVacio(){
        return raiz == null;
    }
    
    
    
    
    
    
    
    
    
    
}
