import java.util.ArrayList;
/***

{
{'A','A','*','V',V','V'},
{'V','A',A','V','A','*'},
{'V','V','V','V','A','A'},
{'A','*','N','N','A','A'},
{'A','A','N','N','A','A'},
{'N','N','N','N','A','A'}}
   
{"AA*VVVV","AAVVAA*","VVVVAAA","AA*VA*A","AAVAAAA"}

"AA*VVVV"
"AAVVAA*"
"VVVVAAA"
"AA*VA*A"
"AAVAAAA"

   */
public class P_79
{
    public void mostrarNido(String[]lineas){
        char[][]mapa = new char[lineas.length][lineas[0].length()];
        int i = 0;
        for(String s: lineas) mapa[i++] = s.toCharArray();
        //System.out.println(backtraking(0, 2, mapa));
        System.out.println(getMejorNido(mapa));
    }
    Nido mejor;
    Nido getMejorNido(char[][]mapa){
       Nido mejor = new Nido(-1,-1);
       ArrayList<Nido> nidos = buscarNidos(0,0,mapa);
       mejorNido(nidos,mapa,mejor,0);
       return mejor;
    }
    
    void mejorNido(ArrayList<Nido> nidos, char[][]mapa, Nido mejor, int id){
        if(id < nidos.size()){
            Nido nido = nidos.get(id);
            int vecA = backtraking(nido.fila(), nido.columna(), mapa);
            //System.out.println(vecA);
            nido.setCantVec(vecA);
            if(nido.cantVecA() > mejor.cantVecA()){
                mejor.setCantVec(nido.cantVecA());
                mejor.fil = nido.fila();
                mejor.col = nido.columna();
            }
            mejorNido(nidos, mapa, mejor, id+1);
        }
    }
    
    int backtraking(int fil, int col, char[][]mapa){
        int cantVecA = 0;
        char temp;
        if(validar(fil, col, mapa)){
            if(mapa[fil][col] == 'A') cantVecA = 1;
            temp = mapa[fil][col];
            mapa[fil][col] = '-';//marcar
            cantVecA += backtraking(fil-1, col, mapa);
            cantVecA += backtraking(fil+1, col, mapa);
            cantVecA += backtraking(fil, col-1, mapa);
            cantVecA += backtraking(fil, col+1, mapa);
            //mapa[fil][col] = temp;//desmarcar
        }
        return cantVecA;
    }
    
    boolean validar(int fil, int col, char[][]mapa){
        boolean valido = fil > -1 && fil < mapa.length && col > -1 && col < mapa[0].length;
        if(valido) valido = mapa[fil][col] == 'A' || mapa[fil][col] == '*';
        return valido;
    }
    
    ArrayList<Nido> buscarNidos(int fil, int col, char[][]mapa){
        ArrayList<Nido> nidos = new ArrayList<Nido>();
        if(fil < mapa.length){
            if(col < mapa[0].length){
               if(mapa[fil][col] == '*') nidos.add(new Nido(fil,col));
               nidos.addAll(buscarNidos(fil, col+1, mapa));
            }else nidos.addAll(buscarNidos(fil+1, 0, mapa));
        }
        return nidos;
    }  
    
    
    public class Nido{
        int fil,col,cantVec;
        public Nido(int fil, int col){
            this.fil = fil;
            this.col = col;
            cantVec = 0;
        }
        
        public void setCantVec(int nuevaCantVec){
            cantVec = nuevaCantVec;
        }
        
        public int fila(){
            return fil;
        }
        
        public int columna(){
            return col;
        }
        
        public int cantVecA(){
            return cantVec;
        }
        
        public String toString(){
            return "("+fil+","+col+")";
        }
        
        public Nido clonar(){
            Nido clon = new Nido(fil,col);
            clon.setCantVec(cantVec);
            return clon;
        }
    }
}
