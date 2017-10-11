package ed.edl;


/**
 * Write a description of class ListaCDE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaCDE<T> implements Lista<T>
{
    private NodoDE<T> ini;
    
    /**
     * metodo que permite decir el estado de la lista
     * @param 
     * @return si la lista esta vacia o no
     */
    public boolean vacia(){
        return false;
    }
    /**
     * Metodo que permite insertar el dato al final
     * de la lista
     * @param dato es el elemento a insertar
     * @return nada
     */
    public void insertar(T dato){
    }
    /**
     * Metodo que permite eliminar el dato de la posicion
     * pos de la lista
     * @param pos que es un numero entero positivo
     * @return nada
     */
    public void eliminar(int pos){
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

}
