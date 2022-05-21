import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


    class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            String line = br.readLine();
            String[] strs = line.trim().split(" ");

            ArrayList<Integer> list = new ArrayList<>();
            for (String str : strs) {
                list.add(Integer.parseInt(str));
            }

            String k = br.readLine();
            int windowLength = Integer.parseInt(k);

            maxValueOfEachSubArray(list,windowLength);
        }

        private static void maxValueOfEachSubArray(ArrayList<Integer> list,int windowLength) {
            ArrayList<Integer> window = new ArrayList<>(windowLength);
            for(int i=0; i<windowLength;i++)
                window.add(list.get(i));

            if(list.size()>windowLength){
                for(int i=0 ; i<list.size()-windowLength ; i++){
                    System.out.println(Collections.max(window));
                    window.remove(0);
                    window.add(list.get(i+windowLength));
                }
                System.out.println(Collections.max(window));
            }
            else
                System.out.println(Collections.max(list));

        }
    }
