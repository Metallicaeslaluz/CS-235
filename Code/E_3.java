
public class E_3
{
    public String estadoFinal(int cantFases, String estado){
        String res="";
        if(cantFases==0) res = estado;
        else{
            String inverso=invertir(estado,0);
            res = estadoFinal(cantFases-1, estado.substring(0, estado.length()-1)+inverso+"C");
        }
        return res;
    }
    
    private String invertir(String estado, int ind){
        String res="";
        if(ind < estado.length() - 1){
            if(estado.charAt(ind)=='N') res = 'A'+invertir(estado, ind+1);
            else res = 'N'+ invertir(estado, ind+1);
        }
        return res;
    }
}
