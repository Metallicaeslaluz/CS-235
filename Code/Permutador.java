import java.util.ArrayList;
/***
{"a","b","c","d"} -> 2
{"b","a","d","c"} -> 1
{"a","e","d","c","b"} -> 0
   
   */
public class Permutador
{
    public ArrayList<String> generarPermutaciones(String[]lista){
        ArrayList<String> perms = new ArrayList<String>();
        return perms;
    }
    //primero mayor del ultimo par ordenado = pmu
    public String[] proximaPermutacion(String[]lista){
        int mupo = buscarIndiceDelMenorDelUPO(0, lista),pmu;
        if(mupo > -1){
            pmu = buscarIndicePrimerMayorQueUPO(lista.length-1, mupo, lista);
            swap(mupo, pmu, lista);
            invertir(lista.length-1, mupo+1, lista);
        }        
        return lista;
    }
    
    void swap(int i, int j, String[]lista){
        String temp = lista[i];
        lista[i] = lista[j];
        lista[j] = temp;
    }
    
    void invertir(int der, int izq, String[]lista){
        if(izq < der){
            swap(izq, der, lista);
            invertir(der-1, izq+1, lista);
        }
    }
    
    //UPO = ultimo par ordenado creciente
    //mupo = menor del ultimo par ordenando creciente
    public int buscarIndicePrimerMayorQueUPO(int i, int mupo, String[]lista){
        int indice = -1;
        if(mupo < i){
            if(lista[i].compareTo(lista[mupo]) > 0) indice = i;
            else indice = buscarIndicePrimerMayorQueUPO(i-1, mupo, lista);
        }
        return indice;
    }
    
    public int buscarIndiceDelMenorDelUPO(int i, String[]lista){
        int indice;
        if(i==lista.length - 1) indice = -1;
        else{
            indice = buscarIndiceDelMenorDelUPO(i+1, lista);
            /*compareTo compara dos cadenas de acuerdo a quien lo llama
            si la cadena lista[i] es menor que la candena lista[i+1] la respuesta debe ser menor 
            a cero*/
            if(lista[i].compareTo(lista[i+1]) < 0  && indice == -1) indice = i;
        }
        return indice;
    }
    
    
    
    
    
    
    
}
