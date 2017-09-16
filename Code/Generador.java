import java.util.ArrayList;
public class Generador
{
    //s = start e = end
    ArrayList<Integer> getPolidivisbles(int k){
        ArrayList<Integer> polidivisibles = new ArrayList<Integer>();
        int ini,fin;
        ini = (int)Math.pow(10,k-1);
        fin = (int)Math.pow(10,k) - 1;
        generarPolidivisibles(ini, fin, polidivisibles);
        System.out.println(polidivisibles);
        return polidivisibles;
    }
    
    void generarPolidivisibles(int ini, int fin, ArrayList<Integer> polidivisibles){
        if(ini <= fin){
            //ini = n (ini+"").length() = i
            if(esPolidivisible(ini, (ini+"").length()))
                polidivisibles.add(ini);
            generarPolidivisibles(ini+1, fin, polidivisibles);
        }
    }
    boolean esPolidivisible(int n, int i){
        boolean res = false;
        if(i == 1) res = true;
        else{
            if(n%i != 0) res = false;
            else res = esPolidivisible(n/10, i-1);
        }
        return res;
    }
}
