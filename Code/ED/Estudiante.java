public class Estudiante{
        private int codigoSis;
        private String nombre;
        private int ci;
        public Estudiante(String nombre, int codigoSis, int ci){
            this.nombre=nombre;
            this.codigoSis=codigoSis;
            this.ci=ci;
        }
        
        @Override
        public boolean equals(Object o){
            boolean equals = false;//same=iguales
            if(o instanceof Estudiante){
                Estudiante otro = (Estudiante)(o);
                equals = otro.nombre.equals(this.nombre) && otro.codigoSis==this.codigoSis &&
                         otro.ci==this.ci;
            }
            return equals;
        }
    }