import java.util.Stack;

public class P_13
{
    public String mensajeRestaurado(String msgEncriptado){
        String msg="";
        char letra;
        Stack<Character> pila = new Stack<Character>();//wrapped = envoltura para v.primitivas
        for(int i=0; i < msgEncriptado.length(); i++){
            letra = msgEncriptado.charAt(i);
            if(pila.isEmpty() || pila.peek() != letra) pila.push(letra);
            else pila.pop();
        }
        
        while(!pila.isEmpty()) msg = pila.pop() + msg;
        return msg;
    }
    
    
    
}
