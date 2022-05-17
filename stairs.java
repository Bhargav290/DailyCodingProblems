// question ,
//There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters//.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2


class stairs {
    // A recursive function used by countWays
    static int countWaysUtil(int n, int m) {
        if (n <= 1)
            return n;
        int res = 0;
        for (int i = 1; i <= m && i <= n; i++)
            res += countWaysUtil(n - i, m);
        return res;
    }

    // Returns number of ways to reach s'th stair//
    static int countWays(int s, int m) {
        return countWaysUtil(s + 1, m);
    }

    /* Driver program to test above function */
    public static void main(String []args) {
        int s = 4, m = 2;
        System.out.println("Number of ways = "
                + countWays(s, m));
    }
}


