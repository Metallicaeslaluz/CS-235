import java.util.ArrayList;
/**
"NO TE RINDAS AUN ESTAS A TIEMPO DE ALCANZAR Y COMENZAR DE NUEVO; ACEPTAR "+
"TUS SOMBRAS, ENTERRAR TUS MIEDOS, LIBERAR EL LASTRE, RETOMAR EL VUELO."+
"NO TE RINDAS QUE LA VIDA ES ESO, CONTINUAR EL VIAJE, PERSEGUIR TUS SUENOS,"+
"DESTRABAR EL TIEMPO, CORRER LOS ESCOMBROS Y DESTAPAR EL CIELO; NO TE RINDAS "+
"POR FAVOR, NO CEDAS AUNQUE EL FRIO QUEME AUNQUE EL MIEDO MUERDA, AUNQUE EL "+
"SOL SE ESCONDA Y SE CALLE EL VIENTO AUN HAY FUEGO EN TU ALMA AUN HAY VIDA EN "+
"TUS SUENOS."   
   
   */
public class P_104
{
    public ArrayList<String> generarReporte(String texto, int longi){
        ArrayList<String> reporte = new ArrayList<String>();
        buscarPalabras(0, "", texto, reporte, longi);
        System.out.println(reporte);
        return reporte;
    }
    
    private void buscarPalabras(int indice, String palabra, 
                                String texto, ArrayList<String> reporte,
                                int longi){
        if(indice == texto.length()){
            if(palabra.length() > longi && !reporte.contains(palabra))
                reporte.add(palabra);
        }else{
            char c = texto.charAt(indice);
            //if(c >= 'A' && c <= 'Z')
            if(Character.isLetter(c)){
                palabra += c;
                buscarPalabras(indice+1, palabra, texto, reporte, longi);                
            }else{
                if(palabra.length() > longi && !reporte.contains(palabra))
                   reporte.add(palabra);
                palabra = "";
                buscarPalabras(indice+1, palabra, texto, reporte, longi);
            }
        }
    }
}
