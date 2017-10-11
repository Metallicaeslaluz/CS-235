package ed.edl;


/**
 * Write a description of class Lista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Lista<T>
{
    /**
     * metodo que permite decir el estado de la lista
     * @param 
     * @return si la lista esta vacia o no
     */
    public boolean vacia();
    /**
     * Metodo que permite insertar el dato al final
     * de la lista
     * @param dato es el elemento a insertar
     * @return nada
     */
    public void insertar(T dato);
    /**
     * Metodo que permite eliminar el dato de la posicion
     * pos de la lista
     * @param pos que es un numero entero positivo
     * @return nada
     */
    public void eliminar(int pos);
    /**
     * metodo que permite acceder al elemento de la posicion
     * pos
     * @param pos entero positivo
     * @return elemento de la posicion pos
     */
    public T acceder(int pos);
    public void reemplazar(int pos, T dato);
    public void insertar(int pos, T dato);
    public int longitud();
    public boolean igual(Lista<T> otra);
    public Lista<T> unir(Lista<T> otra);
    public boolean buscar(T dato);
    public int posicionDe(T dato);
    
}





