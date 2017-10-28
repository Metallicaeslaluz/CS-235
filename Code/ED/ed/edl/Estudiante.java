package ed.edl;

public class Estudiante implements Comparable<Estudiante> {
        private int codigoSis;
        private String nombre;
        private int ci;
        private int nota;
        
        public Estudiante(String nombre, int codigoSis, int ci){
            this.nombre=nombre;
            this.codigoSis=codigoSis;
            this.ci=ci;
        }
        
        public void asignarNota(int nota){
            this.nota=nota;
        }
        
        public boolean equals(Object o){
            boolean equals = false;//same=iguales
            if(o instanceof Estudiante){
                Estudiante otro = (Estudiante)(o);
                equals = otro.nombre.equals(this.nombre) && otro.codigoSis==this.codigoSis &&
                         otro.ci==this.ci;
            }
            return equals;
        }
        
        public int compareTo(Estudiante otro){
            if(this.nombre.compareTo(otro.nombre)==0)
                return this.codigoSis - otro.codigoSis;
            else return this.nombre.compareTo(otro.nombre);
        }
        
        public String toString(){
            return "Nombre: "+nombre+ " \n"+
                    "CodSis: " + codigoSis  +"\n"+
                    "CI: "+ci;
        }
        
    }