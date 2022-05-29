import java.util.ArrayList;

    public class dcp22{
        public static ArrayList<String> findOriginalSentence(String[] dict, String sentence){
            String s = "";
            ArrayList<String> ans = new ArrayList<>();

            for(int i=0;i < sentence.length();i++){
                s = s + sentence.charAt(i);
                for(String str:dict){
                    if(s.equals(str)){
                        ans.add(s);
                        s = "";
                    }
                }
            }

            if(ans.size() == 0){
                return null;
            }
            return ans;
        }

        public static void main(String[] args){
            String[] dict = {"quick", "brown", "the", "fox"};
            String sentence = "thequickbrownfox";
            ArrayList<String> ans = findOriginalSentence(dict,sentence);
            System.out.println(ans);
        }
    }

