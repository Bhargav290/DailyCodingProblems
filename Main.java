/******************************************************************************
This problem was asked by Facebook.
Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
For example, given the string "([])[]({})", you should return true.
Given the string "([)]" or "((()", you should return false.
*******************************************************************************/
import java.util.*;

    public class Main
    {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            String line =s.next();
            System.out.println(balancedParenthesis(line)?"Balanced":"Not Balanced");
        }
        public static boolean balancedParenthesis(String line){
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<line.length();i++){
                char ch = line.charAt(i);
                if(ch == '[' || ch == '(' || ch == '{'){
                    stack.push(ch);
                    continue;
                }
                if(stack.isEmpty())
                    return false;
                char verify = stack.pop();
                switch(ch){
                    case ')':if(verify != '(') return false;
                        break;
                    case '}':if(verify != '{') return false;
                        break;
                    case ']':if(verify != '[') return false;
                        break;
                }
            }
            return stack.isEmpty();
        }
    }
