public class Day7 {

        public static void main(String[] args) {
            String s = "226";
            System.out.println(numDecodingsDp(s)); //output = 3;
        }


        public static int numDecodingsDp(String s) {
            if(s.charAt(0) == '0')
                return 0;

            if(s.length() == 1)
                return 1;

            int currPlusTwo = 1;
            int currPlusOne = s.charAt(s.length() - 1) == '0' ? 0 : 1;
            int current = 0;


            for (int i = s.length() - 2; i >= 0; i--) {
                if(s.charAt(i) == '0')
                    current = 0;
                else if((10 * (s.charAt(i) - 49 + 1) + (s.charAt(i+1) - 49 + 1)) <= 26)
                    current = currPlusOne + currPlusTwo;
                else
                    current = currPlusOne;

                currPlusTwo = currPlusOne;
                currPlusOne = current;
            }

            return current;
        }


    }

