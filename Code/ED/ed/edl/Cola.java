 package ed.edl;
public class Cola<T>
{
    protected NodoSE<T> frente,fin;
    public Cola(){
        frente = fin = null;
    }
    public boolean vacia(){
        return frente == null;
    }
    public void encolar(T d){
        NodoSE<T> p = new NodoSE<T>(d);
        if(vacia()){
            frente = fin = p;
        }
        else{
            fin.setSuc(p);
            fin = p;
        }
    }
    public T decolar(){
        T res = null;
        if(!vacia()){
            res = frente.getDato();
            frente = frente.getSuc();
        }
        return res;
    }
    public T ver(){
        T res = null;
        if(!vacia()){
            res = frente.getDato();
        }
        return res;
    }
    public String toString()
    {
        String ans = "";
        while(!vacia())
        {
            ans += decolar()+" "; 
        }
        ans = "["+ans.trim().replaceAll(" ", ", ")+"]";
        return ans;
    }
}
