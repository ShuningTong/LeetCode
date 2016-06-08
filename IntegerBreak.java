import java.lang.Math;

// This is a dynamic solution for Integer Break

public class IntegerBreak {

    public static void main(String[] args){
        if (args != null && args.length != 0){
            int n = Integer.parseInt(args[0]);
            int r = getResult(n);
            System.out.println("The maximum product is: " + r);
        }else {
            System.out.println("Not valid input!");
        }
    }

    public static int getResult(int n) {
        if (n == 2){
            return 1;
        }

        if (n == 3){
            return 2;
        }

        int[] a = new int[n+1];

        // this is important
        a[2] = 2;
        a[3] = 3;
        
        for (int i = 4; i <= n; i++){
            int max = 0;
            for (int j = 2; j <= i / 2; j++){
                max = Math.max(max, a[j] * a[i - j]);
            }
            a[i] = max;
        }
        return a[n];
    }
}
