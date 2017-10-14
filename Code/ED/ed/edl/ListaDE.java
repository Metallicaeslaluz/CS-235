package ed.edl;


/**
 * Write a description of class ListaDE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaDE<T> implements Lista<T>
{
    private NodoDE<T> ini;
    
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
        if(vacia()) ini = new NodoDE<T>(dato);
        else{
            NodoDE<T> act=ini;
            NodoDE<T> nuevo=new NodoDE<T>(dato);
            while(act.getSuc()!=null) act = act.getSuc();
            act.setSuc(nuevo);
            nuevo.setAnt(act);
            //insertar(act,nuevo);
        }
    }
    
    public void insertar(NodoDE<T> act, NodoDE<T> nuevo){
        if(act.getSuc()==null){
            act.setSuc(nuevo);
            nuevo.setAnt(act);
        }else insertar(act.getSuc(), nuevo);
    }
    /**
     * Metodo que permite eliminar el dato de la posicion
     * pos de la lista
     * @param pos que es un numero entero positivo
     * @return nada
     */
    public void eliminar(int pos){
        if(!vacia()){
            if(pos==0) ini = ini.getSuc();
            else{
                NodoDE<T> act=ini,antAct,sucAct;//el actual es el nodo a eliminar
                while(pos!=0 && act!=null){
                    act=act.getSuc();
                    pos--;
                }
                antAct=act.getAnt();
                sucAct=act.getSuc();
                
                antAct.setSuc(sucAct);
                if(sucAct!=null) sucAct.setAnt(antAct);
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
        String cad="";//act=actual=navegador
        NodoDE<T> act=ini;
        while(act!=null){
            cad = cad + act.getDato()+" ";
            act=act.getSuc();
        }
        cad=cad.trim();
        cad=cad.replaceAll(" ", ", ");
        cad="["+cad+"]";
        return cad;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
