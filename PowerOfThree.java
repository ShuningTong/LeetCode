

public class PowerOfThree {

    public static void main(String[] args){
        if(args != null && args.length != 0){
            int n = Integer.parseInt(args[0]);
            System.out.println(isPowerOfThree(n));
        }else{
            System.out.println("Not valid input!");
        }
    }
    public static boolean isPowerOfThree(int n) {
        // if (n <= 0){
        //     return false;
        // }
        // if (n == 1){
        //     return true;
        // }
        // double quotient = n / 3.0;
        // while(true){
        //     if (Math.floor(quotient) != quotient){
        //         return false;
        //     }
        //     if (quotient == 1.0){
        //         return true;
        //     }
        //     quotient = quotient / 3.0;
        // }
        
        if (n <= 0){
            return false;
        }
        if (n == 1){
            return true;
        }
        int remainder = n % 3;
        int quotient = n / 3;
        while(true){
            if (remainder != 0){
                return false;
            /* interesting findings:
            the above solutions runs 22 ms
            the current solution without || quotient == 3 runs 21 ms
            the current solution runs 20 ms
            */

            }else if (quotient == 1 || quotient == 3){
                return true;
            }else{
                remainder = quotient % 3;
                quotient = quotient / 3;
            }
        }
    }

    // From discussions
    public static boolean isPowerOfThreeMagic(int n) {
        // The expression "(int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) / Math.log(3.0))" returns max integer that is "power of 3"
        return n > 0 && (int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) / Math.log(3.0))) % n == 0;
    }
}
