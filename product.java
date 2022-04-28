class product{

    void prodArray(int []a, int n){
        int []p = new int[n];
                int prod=1;

        for(int i=0; i<n; i++){
            prod = prod * a[i];
        }

        for(int i=0; i<n; i++){
            p[i] = prod / a[i];
        }

        for(int i=0; i<n; i++){
            System.out.print(p[i] + " ");
        }
    }

    public static void main(String[] args){
        product pro = new product();
        int []a = {1, 2,3,4,5};
        int n = a.length;
        pro.prodArray(a,n);
    }
}