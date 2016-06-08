 
public class ReverseString{

    public static void main(String[] args){
        if(args != null && args.length != 0){
            System.out.println(reverse(args[0]));
        }else{
            System.out.println("Not valid input!");
        }
    }
    public static String reverse(String s){
        char[] chars = s.toCharArray();
        char[] reverseChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++){
            reverseChars[i] = chars[chars.length - i - 1];
        }
        // String reverseString = new String(reverseChars);
        String reverseString = String.valueOf(reverseChars);
        return reverseString;
    }
    
}
