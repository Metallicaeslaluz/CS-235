package ed.edl;


/**
 * Write a description of class NodoSE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoSE<T>
{
    private T         dato;
    private NodoSE<T> suc;
    public NodoSE(T dato){
        this.dato = dato;
        suc=null;
    }
    public T getDato(){
       return dato; 
    }
    public NodoSE<T> getSuc(){
        return suc;
    }
    public void setSuc(NodoSE<T> suc){
        this.suc = suc;
    }
    public void setDato(T dato){
        this.dato=dato;
    }
}
