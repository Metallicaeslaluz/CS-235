
public class P_68
{
    public int cantCirculos(int n){
        int cant = 0, cantAnterior; 
        if(n == 1) cant = 1;
        else{
            cantAnterior = cantCirculos(n - 1);
            cant = cantAnterior + 3*n - 2;
        }
        
        return cant;
    }
}
