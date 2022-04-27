import java.util.*;
public class daily1 {
    static boolean checkpairs(int A[],int n, int sum){
        int l, r;
        Arrays.sort(A);
        l = 0;
        r = n - 1;
        while (l < r) {
            if (A[l] + A[r] == sum)
                return true;
            else if (A[l] + A[r] < sum)
                l++;
            else
                r--;
        }
        return false;
    }
    public static void main(String args[])
    {
        int A[] = { 10, 15, 3, 7 };
        int k = 17;
        int n = A.length;
        if (checkpairs(A, n, k))
            System.out.println("pair exist");
        else
            System.out.println("pair does not exist");
    }
}


