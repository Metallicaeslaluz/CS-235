import java.util.ArrayList;
public class E_1
{
   public ArrayList<String> combinaciones(int[]arr, int num){
       ArrayList<String> combs = combinar(arr,num,0,0,new int[arr.length]);
       System.out.println(combs);
       return combs;
   }
   private ArrayList<String> combinar(int[]arr,int num,int sum,
                                     int i,int[]cnt){
       ArrayList<String> combs = new ArrayList<String>();
       if(sum==num) 
          combs.add("{"+construirCombinacion(cnt,0).trim().replaceAll(" ",",")+"}");
       else if(i<arr.length){
           if(sum+arr[i]<=num){
               cnt[i]++;//marcar
               combs.addAll(combinar(arr,num,sum+arr[i],i,cnt));
               cnt[i]--;//desmarcar
           }
           combs.addAll(combinar(arr,num,sum,i+1,cnt));
       }
       return combs;                                  
   }
   private String construirCombinacion(int[]cnt,int i){
       String combinacion;
       if(i==cnt.length) combinacion="";
       else combinacion=cnt[i]+" "+construirCombinacion(cnt,i+1);
       return combinacion;
   }
}
