


/******************************************************************************
This problem was asked by Amazon.
Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.
*******************************************************************************/

import java.util.*;
    public class dcp29
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
                    new_s+= (""+c)+s.charAt(i);
                    c=1;
                }
            }
            return new_s;

        }
    }
