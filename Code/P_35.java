
public class P_35
{
    public int[] getFila(int n){
        int[]fila,filaAnt;
        if(n == 0) fila = new int[]{1};
        else if(n == 1) fila = new int[]{1,1};
        else{
            fila = new int[n+1];
            fila[0] = fila[n] = 1;
            filaAnt = getFila(n-1);
            sumarFilaAnt(1, fila, filaAnt);
        }
        return fila;
    }
    
    void sumarFilaAnt(int i, int[]fila, int[]filaAnt){
        if(i < filaAnt.length){
            fila[i] = filaAnt[i-1] + filaAnt[i];
            sumarFilaAnt(i+1, fila, filaAnt);
        }
    }
}
