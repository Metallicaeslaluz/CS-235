package ed.edl;


/**
 * Write a description of class ListaCSE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaCSE<T> implements Lista<T>
{
    private NodoSE<T> ini;
    public ListaCSE(){
        ini=null;
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
            ini = new NodoSE<T>(dato);
            ini.setSuc(ini);
        }
        else{
            NodoSE<T> ult=ultimo();
            NodoSE<T> nuevo=new NodoSE<T>(dato);
            ult.setSuc(nuevo);
            nuevo.setSuc(ini);
        }
    }
    
    public NodoSE<T> ultimo(){
        NodoSE<T> act;
        act=ini;
        if(!vacia()){
            while(act.getSuc()!=ini) act=act.getSuc();
        }
        return act;
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
                NodoSE<T> ult=ultimo();
                if(ult==ini) ini=null;
                else{
                    ult.setSuc(ini.getSuc());
                    ini = ini.getSuc();
                }
            }else{
                NodoSE<T> act=ini;
                pos--;
                while((pos--)!=0)act=act.getSuc();
                act.setSuc(act.getSuc().getSuc());
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
        String cad="";
        NodoSE<T> act=ini;
        if(!vacia()){
            do{
                cad=cad+act.getDato()+" ";
                act=act.getSuc();
            }while(act!=ini);
        }
        cad = cad.trim();
        cad = "["+cad.replace(" ", ", ") + "]";
        return cad;
    }
    
    
    
    
}
