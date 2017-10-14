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
            }
        }
    }
    /**
     * metodo que permite acceder al elemento de la posicion
     * pos
     * @param pos entero positivo
     * @return elemento de la posicion pos
     */
    public T acceder(int pos){
        return null;
    }
    public void reemplazar(int pos, T dato){
    }
    public void insertar(int pos, T dato){
    }
    public int longitud(){
        return 0;
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
}
