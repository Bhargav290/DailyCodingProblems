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

