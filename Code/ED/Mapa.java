import ed.ednl.ArbolBin;
import ed.edl.ListaSE;
public class Mapa
{
    ArbolBin<Pueblo> cuencaBora;
    public Mapa(){
        cuencaBora = new ArbolBin<Pueblo>(new Pueblo("Notar",0));
    }
    
    public void agregarPueblo(Pueblo puebloAnt, Pueblo puebloAct){
        cuencaBora.insertarPares(puebloAnt, puebloAct);
    }
    
    public ListaSE<Pueblo> getListaPueblos(int tiempoX){
        return getListaPueblos(this.cuencaBora, new ListaSE<Pueblo>(), tiempoX);
    }
    
    private ListaSE<Pueblo> getListaPueblos(ArbolBin<Pueblo> cuencaBora, ListaSE<Pueblo> listaPueblos,
                                 int tiempoX){
        ListaSE<Pueblo> res = listaPueblos,pueblosIzq,pueblosDer;
        pueblosIzq = new ListaSE<Pueblo>();
        pueblosDer = new ListaSE<Pueblo>();
        int tiempoNecesitado;
        Pueblo pueblo;
        if(cuencaBora!=null){
            pueblo = cuencaBora.getRaiz();
            tiempoNecesitado = pueblo.getTiempo();
            if(tiempoX >= tiempoNecesitado){
                listaPueblos.insertar(pueblo); 
                tiempoX -= pueblo.getTiempo();
            }                
            if(cuencaBora.getIzq()!=null) 
                pueblosIzq = getListaPueblos(cuencaBora.getIzq(), listaPueblos.clonar(), tiempoX);
            if(cuencaBora.getDer()!=null) 
                pueblosDer = getListaPueblos(cuencaBora.getDer(), listaPueblos.clonar(), tiempoX);
            res = res.listaMayorLogitud(res, pueblosIzq);
            res = res.listaMayorLogitud(res, pueblosDer);
        }
        return res;
    }
    
    
}
