/***
 
{{1,-1,2,4,6,7,8},
{-3,1,6,7,-1,-1,-4},
{6,5,3,3,2,8,-5},
{3,6,8,-4,6,7,1}}
   
   */
public class P_105
{
    private int[][]matriz;
    public RutaNum mejorRuta(int xIni, int yIni, int xFin, int yFin, int[][]matriz){
        this.matriz = matriz;
        RutaNum ruta =  backtracking(xIni,yIni,xFin,yFin);
        System.out.println(ruta);
        return ruta;
    }
    
    private RutaNum backtracking(int fil, int col, int xFin, int yFin){
        RutaNum ruta = new RutaNum(0,""),NO,NE,SO,SE,mejorRuta;
        int aux;
        if(fil == xFin && col == yFin){
           ruta = new RutaNum(matriz[fil][col],matriz[fil][col]+"");
        }else{
            if(validar(fil,col)){
                ruta = new RutaNum(matriz[fil][col],matriz[fil][col]+"");
                aux = matriz[fil][col];
                matriz[fil][col] = -1;//marcar o visitar
                NO = backtracking(fil-1, col-1, xFin, yFin);
                NE = backtracking(fil-1, col+1, xFin, yFin);
                SE = backtracking(fil+1, col+1, xFin, yFin);
                SO = backtracking(fil+1, col-1, xFin, yFin);
                mejorRuta = mejorRuta(mejorRuta(NO, NE), mejorRuta(SE, SO));
                ruta.incSum(mejorRuta.getSuma());
                ruta.incCamino(mejorRuta.getCamino());
                matriz[fil][col] = aux;//desmarcar = no visitado
            }
        }
        return ruta;
    }
    
    private RutaNum mejorRuta(RutaNum a, RutaNum b){
        return a.getSuma() > b.getSuma() ? a:b;
        //if(a.getSuma() > b.getSuma()) res = a;
        //else res = b;
    }
    
    private boolean validar(int fil, int col){
        boolean valido = fil > -1 && fil < matriz.length && col > -1 && col < matriz[0].length;
        if(valido) valido = matriz[fil][col] > -1;//valida que el valor sea > -1(positivo)
        return valido;
    }
    
    
    public class RutaNum
    {
        private int sum;
        private String camino;
        public RutaNum(int sum, String camino){
            this.sum = sum;
            this.camino = camino;
        }
        
        public int getSuma(){
            return sum;
        }
        
        public String getCamino(){
            return camino;
        }
        
        public void incSum(int val){
            sum += val;
        }
        
        public void incCamino(String s){
            camino += " " + s;
        }
        
        public String toString(){
            return "sum = " + sum + "; camino = " + camino.replaceAll(" ", "+");
        }
    }

}
