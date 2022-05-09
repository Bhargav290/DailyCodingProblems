#Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.#
import java.lang.*;
class MaximumSum {
       
        int findMaxSum(int []arr, int n)
        {
            int incl = arr[0];
            int excl = 0;
            int excl_new;
            int i;

            for (i = 1; i < n; i++) {
                excl_new = Math.max(incl, excl);
                incl = excl + arr[i];
                excl = excl_new;
            }


            return Math.max(incl, excl);
        }


        public static void main(String[] args)
        {
            MaximumSum sum = new MaximumSum();
            int []arr = new int[] { 2,4,6,2,5};
            int N = arr.length;

            System.out.println(
                    sum.findMaxSum(arr, N));
        }
    }

