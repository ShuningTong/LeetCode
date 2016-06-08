

public class ReverseVowels {

    public static void main(String[] args){
        if (args != null && args.length != 0){
            System.out.println(reverse(args[0]));
        }else{
            System.out.println("Not valid input!");
        }
    } 
    public static String reverse(String s) {
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        char[] reverseChars = new char[chars.length];
        int left = 0;
        int right = chars.length - 1;
        while(left <= right){
            if (vowels.indexOf(chars[left]) != -1 && vowels.indexOf(chars[right]) != -1){
                reverseChars[left] = chars[right];
                reverseChars[right] = chars[left];
                left++;
                right--;
            }else{
                if (vowels.indexOf(chars[left]) == -1){
                    reverseChars[left] = chars[left];
                    left++;
                }
                if (vowels.indexOf(chars[right]) == -1){
                    reverseChars[right] = chars[right];
                    right--;
                }
            }
        }

        return String.valueOf(reverseChars);
    }
}
