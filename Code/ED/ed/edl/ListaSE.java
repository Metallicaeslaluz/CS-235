package ed.edl;


/**
 * Write a description of class ListaSE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaSE<T> implements Lista<T>
{
    private T          ini;
    private ListaSE<T> sig;
    /**
     * metodo constructor de la ListaSE*/
    public ListaSE(){
        ini=null; sig=null;
    }  
    /**
     * metodo constructor de la ListaSE*/
    public ListaSE(T ini){
        this.ini=ini;
        sig=new ListaSE();
    }
    /**
     * metodo que permite decir el estado de la lista
     * @param 
     * @return si la lista esta vacia o no
     */
    public boolean vacia(){
        return ini==null;
    }
    /**
     * Metodo que permite insertar el dato al final
     * de la lista
     * @param dato es el elemento a insertar
     * @return nada
     */
    public void insertar(T dato){
        if(vacia()){
            ini=dato; sig=new ListaSE<T>();
        }else sig.insertar(dato);
    }
    /**
     * Metodo que permite eliminar el dato de la posicion
     * pos de la lista
     * @param pos que es un numero entero positivo
     * @return nada
     */
    public void eliminar(int pos){
        if(!vacia()){
            if(pos==0){
                this.ini=sig.ini;
                this.sig=sig.sig;
            }else{
                eliminarRec(pos-1);
            }
        }
    }
    
    private void eliminarRec(int pos){
        if(pos==0) this.sig = sig.sig;
        else sig.eliminarRec(pos-1);
    }
    
    /**
     * Eliminar por igualdad de atributos**/
    public void eliminar(T dato){
        if(!vacia()){
            if(ini.equals(dato)){
                this.ini=sig.ini;
                this.sig=sig.sig;
            }else{
                eliminarRec(dato);
            }
        }
    }
    
    private void eliminarRec(T dato){
        if(!sig.vacia()){
            if(sig.ini.equals(dato)) this.sig = sig.sig;
            else sig.eliminarRec(dato);
        }
    }
    
    /**
     * metodo que permite acceder al elemento de la posicion
     * pos
     * @param pos entero positivo
     * @return elemento de la posicion pos
     */
    public T acceder(int pos){
        T res = null;
        if(!vacia()){
            if(pos == 0) res = ini;
            else res = sig.acceder(pos-1);
        }
        return res;
    }
    public void reemplazar(int pos, T dato){
    }
    public void insertar(int pos, T dato){
    }
    public int longitud(){
        int longitud=0;
        if(!vacia()) longitud = 1 + sig.longitud();
        return longitud;
    }
    public boolean igual(Lista<T> otra){
        return false;
    }
    public Lista<T> unir(Lista<T> otra){
        return null;
    }
    public boolean buscar(T dato){
        return false;
    }
    public int posicionDe(T dato){
        return 0;
    }
    public String toString(){
        String s="";
        ListaSE<T> act=this;
        s=act.vacia()?"":act.ini+"";
        act=act.sig;
        while(!act.vacia()){
            s+="#"+act.ini;
            act=act.sig;    
        }
        s="["+s.replace("#",", ")+"]";
        return s;
    }
    
    public ListaSE<T> clonar(){
        ListaSE<T> clon = new ListaSE<T>();
        for(int indice = 0; indice<longitud(); indice++){
            clon.insertar(acceder(indice));
        }
        return clon;
    }
    
    public ListaSE<T> listaMayorLogitud(ListaSE<T> a, ListaSE<T> b){
        return a.longitud() > b.longitud() ? a:b;
    }
    
    
    
    
}
