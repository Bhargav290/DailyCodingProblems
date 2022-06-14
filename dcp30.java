/*
You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.
Compute how many units of water remain trapped on the map in O(N) time and O(1) space.
For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.
Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
*/
import java.util.Scanner;
    public class dcp30{
        static int computeCapacity(int[] ar,int n){
            int sum = 0;
            for(int i = 1;i< n-1;i++)
            {
                int leftMax = ar[i-1];
                for(int j=0;j<i;j++)
                {
                    leftMax = Math.max(leftMax,ar[j]);
                }
                int rightMax = ar[i+1];
                for(int j=i+1;j<n;j++)
                {
                    rightMax = Math.max(rightMax,ar[j]);
                }
                sum += Math.min(leftMax,rightMax) - ar[i];
            }
            return sum;
        }
        public static void main(String args[])
        {
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            int[] ar = new int[n];
            for(int i = 0;i < n; i++)
            {
                ar[i] = s.nextInt();
            }
            int result =  computeCapacity(ar,n);
            System.out.println("Total Capacity : "+result);
            s.close();
        }
    }

