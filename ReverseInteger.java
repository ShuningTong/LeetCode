public class ReverseInteger {
    // what if x is negative?
    // java: -1 % 10 = -1
    // what if the last digit of x is 0? 10, 100, etc.
    // doesn't mind
    // what if the reversion causes an overflow? 1000000003 -> 3000000001
    // Integer.MAX_VALUE = 2,147,483,647
    // Integer.MIN_VALUE = -2,147.483,648


    public static void main(String[] args){
        System.out.println(reverse(1230));
        System.out.println(reverse(1000000003));
        System.out.println(reverse(-123));
    } 

    public static int reverse(int x) {
        int result = 0;
        while(x != 0){
            int newResult = 10 * result + x % 10;
            // this is for detecting overflow
            if (newResult / 10 != result){
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
