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
    
    public void insertarPares(T padre, T dato){
        if(this.raiz.equals(padre)){
            if(izq==null) izq = new ArbolBin<T>(dato);
            else if(der==null) der = new ArbolBin<T>(dato);
        }else{
            if(izq!=null) izq.insertarPares(padre,dato);
            if(der!=null) der.insertarPares(padre,dato);
        }
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
        ListaSE<T> ramaMC = getRamaMasCorta();
        revertirRamaMasCorta(this,ramaMC,0,ramaMC.longitud()-1);
    }
    
    private void revertirRamaMasCorta(ArbolBin<T> arbol,ListaSE<T> ramaMC, 
                                    int prim, int ult){
        if(arbol!=null){
            if(ult > -1){
                if(arbol.raiz.equals(ramaMC.acceder(prim))){
                    arbol.raiz = ramaMC.acceder(ult);
                    if(arbol.izq!=null) 
                        revertirRamaMasCorta(arbol.izq,ramaMC, prim+1, ult-1);
                    if(arbol.der!=null) 
                        revertirRamaMasCorta(arbol.der,ramaMC, prim+1, ult-1);
                }
            }
        }
    }
    
    public ListaSE<T> getRamaMasCorta(){
        ListaSE<T> ramaMC = new ListaSE<T>(),rama;
        ListaSE<ListaSE<T>> ramas = getRamas();
        if(ramas.longitud()>0) ramaMC = ramas.acceder(0);
        for(int indiceRama = 1; indiceRama < ramas.longitud(); indiceRama++){
            rama = ramas.acceder(indiceRama);
            if(rama.longitud() < ramaMC.longitud()) 
                ramaMC = rama;
        }
        return ramaMC;
    }
    
    public ListaSE<ListaSE<T>> getRamas(){
        ListaSE<ListaSE<T>> ramas = new ListaSE<ListaSE<T>>();
        ListaSE<T> rama = new ListaSE<T>();
        buscarRamas(this,rama,ramas);
        return ramas;
    }    
    
    private void buscarRamas(ArbolBin<T> arbol, ListaSE<T> rama, ListaSE<ListaSE<T>> ramas){
        if(arbol!=null){
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
    
    public T getRaiz(){
        return raiz;
    }
    
    public ArbolBin<T> getIzq(){
        return izq;
    }
    
    public ArbolBin<T> getDer(){
        return der;
    }
    
    public boolean estaVacio(){
        return raiz == null;
    }
    
    
    
    
    
    
    
    
    
    
}
