import java.util.*;
    public class Main
    {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            System.out.println(runLength(s));
        }
        public static String runLength(String s){
            s+=" ";
            int c = 1;
            String new_s="";
            for(int i=0;i<s.length()-1;i++){
                if(s.charAt(i) == s.charAt(i+1))
                    c++;
                else{
                    new_s= (""+c)+s.charAt(i);
                    c=1;
                }
            }
            return new_s;

        }
    }

