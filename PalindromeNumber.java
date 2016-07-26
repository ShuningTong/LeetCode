public class PalindromeNumber {
    // negative number cannot be a palindrome number
    // any number that ends with a 0 is not palindrome
    // we should finish this one without any extra space
    // but how do you define extra space?
    // the hints says there is a more generic way

    public static void main(String[] args){
        System.out.println(isPalindromeConcise(56665));
        System.out.println(isPalindromeConcise(2222));
        System.out.println(isPalindromeConcise(0));
        System.out.println(isPalindromeConcise(23333));
        System.out.println(isPalindromeConcise(10));
    }

    // original version from me
    public static boolean isPalindromeMe(int x) {
        if (x < 0){
            return false;
        }
        if (x == 0){
            return true;
        }
        if (x % 10 == 0){
            return false;
        }
        int result = 0;
        while(x != 0){
            result = result * 10 + x % 10;
            if (result == x){
                return true;
            }
            x = x / 10;
            if (result == x){
                return true;
            }
        }
        return false;
    }

    // advanced version
    public static boolean isPalindromeConcise(int x){
        if (x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int result = 0;
        // this is a great improvement: only loop to x <= result
        while(x > result){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return (x == result || x == result / 10);
    }


}
