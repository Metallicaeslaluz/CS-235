import java.io.*;
import java.util.*;
/***
6 9
M 70 A 30 V 20 M 45 M 34 M 32 M 43 M 23 M 10
A 10 M 34 V 20 N 65 M 70 N 10 N 30 M 45 N 45
N 10 A 30 V 20 M 45 M 34 M 32 M 43 M 23 M 10
A 10 A 34 M 20 N 65 M 70 N 10 N 30 M 65 N 65
A 70 A 30 V 20 M 40 N 34 M 32 M 43 M 23 M 20
N 10 M 34 M 20 N 60 M 90 V 10 N 30 M 45 N 59
M
*/
public class P_109{
	Parcela[][]registro;

	public static void main(String[]arg) throws IOException{
		new P_109().read();
	}

	public void read() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int nroFilas,nroCols,i,j;
		nroFilas = Integer.parseInt(st.nextToken());
		nroCols = Integer.parseInt(st.nextToken());
		registro = new Parcela[nroFilas][nroCols];
		for(i = 0; i < nroFilas; i++){
			st = new StringTokenizer(in.readLine());
			for(j = 0; j < nroCols; j++){
				registro[i][j] = new Parcela(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));				
			}
		}
		char tipo = in.readLine().charAt(0);
		System.out.println(buscarMejorPosicion(tipo));
	}

	public Posicion buscarMejorPosicion(char tipo){
		return buscarMejorPosicion(0,0,tipo);
	}

	private Posicion buscarMejorPosicion(int fil, int col, char tipo){
		Posicion pos = new Posicion(0,-1,-1), posB;
		if(fil < registro.length){
			if(col < registro[0].length){
				posB = backtrakingMP(fil,col,tipo);
				pos = buscarMejorPosicion(fil,col+1,tipo);
				pos = mejorPosicion(pos,posB);
			}else{
				pos = mejorPosicion(pos, buscarMejorPosicion(fil+1,0,tipo));
			} 
		}
		return pos;
	}

	//MP = mejor posiscion
	private Posicion backtrakingMP(int fil, int col, char tipo){
		Posicion pos = new Posicion(0,fil,col),posArr,posAba,posDer,posIzq,mejorPos;
		if(puedeCosechar(fil,col,tipo)){
			registro[fil][col].marcar();
			pos.incCant(registro[fil][col].cant());
			posArr = backtrakingMP(fil-1,col,tipo);
			posAba = backtrakingMP(fil+1,col,tipo);
			posIzq = backtrakingMP(fil,col-1,tipo);
			posDer = backtrakingMP(fil,col+1,tipo);
			mejorPos = mejorPosicion(posArr,posAba);
			mejorPos = mejorPosicion(mejorPosicion(posIzq,posDer),mejorPos);
			pos.incCant(mejorPos.cantRec());
			registro[fil][col].desmarcar();
		}
		return pos;
	}	

	private boolean puedeCosechar(int fil, int col, char tipo){
		boolean puede = false;
		if(fil > -1 && fil < registro.length && col > -1 && col < registro[0].length){
			if(!registro[fil][col].marcado() && registro[fil][col].tipo() == tipo) 
				puede = true;
		}
		return puede;
	}

	private Posicion mejorPosicion(Posicion a, Posicion b){
		return a.cantRec() > b.cantRec() ? a:b;
	}

	class Parcela{
		char tipo;//tipo de uva
		int cant;//cant = cantidad de uva
		boolean marcado;
		public Parcela(char tipo, int cant){
			this.tipo = tipo;
			this.cant = cant;
			marcado = false;
		}

		public char tipo(){
			return tipo;
		}

		public int cant(){
			return cant;
		}

		public boolean marcado(){
			return marcado;
		}

		public void marcar(){
			marcado = true;
		}

		public void desmarcar(){
			marcado = false;
		}

		public String toString(){
			return "(" + tipo + ","+ cant + ")";
		}
	}

	class Posicion{
		/*cantRec = cantidad recolectada de uvas
		fil = fila, col = columna*/
		int cantRec,fil,col;
		public Posicion(int cantRec, int fil, int col){
			this.cantRec = cantRec;
			this.fil = fil;
			this.col = col;
		}

		public void incCant(int cant){
			cantRec += cant;
		}	

		public int cantRec(){
			return cantRec;
		}

		public String toString(){
			return "Pos = ("+fil +","+col+")"+" CantRec = " + cantRec;
		}
	}
}