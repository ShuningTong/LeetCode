import java.leng.Character;

/*
非常基础的一道题
是其他很多题的前提
例如palindrome partitioning
*/
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        int slen = s.length();
        int i = 0;
        int j = slen - 1;
        while(i < j){
            if (!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            } else {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    // Character有现成的方法isLetterOrDigit(char c)
    private boolean isAlphanumeric(char c){
        return Character.isAlphabetic(c) || Character.isDigit(c); 
    }
}
