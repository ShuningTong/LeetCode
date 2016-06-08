import java.lang.StringBuilder;

public class AddBinary {
    public static void main(String[] args) {
        if (args != null && args.length != 0) {
            String a = args[0];
            String b = args[1];
            System.out.println(Add(a, b));
        } else {
            System.out.println("Not valid input!");
        }
    }
    public static String Add(String a, String b) {
        
        // This solution may exceeds the maximum value of Integer
        // int x=Integer.parseInt(a, 2);
        // int y=Integer.parseInt(b, 2);
        // int z=x+y;
        // return Integer.toBinaryString(z);

        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();
        char[] longerchar = null;
        int alength = achar.length;
        int blength = bchar.length;
        int maxlength = 0;
        int minlength = 0;

        char[] reverseAChar = new char[alength];
        char[] reverseBChar = new char[blength];
        for (int i = 0; i < alength; i++){
            reverseAChar[i] = achar[alength - 1 - i];
        }
        for (int i = 0; i < blength; i++){
            reverseBChar[i] = bchar[blength - 1 - i];
        }

        if (alength > blength){
            maxlength = alength + 1;
            minlength = blength;
            longerchar = reverseAChar;
        }else{
            maxlength = blength + 1;
            minlength = alength;
            longerchar = reverseBChar;
        }
        
        
        char[] rchar = new char[maxlength];
        boolean carry = false;
        for (int k = 0; k < minlength; k++){
            if (!carry){
                if (reverseAChar[k] == '0' && reverseBChar[k] == '0'){
                    rchar[k] = '0';
                }else if (reverseAChar[k] == '0' ^ reverseBChar[k] == '0'){
                    rchar[k] = '1';
                }else{
                    rchar[k] = '0';
                    carry = true;
                }  
            }else{
                if (reverseAChar[k] == '0' && reverseBChar[k] == '0'){
                    rchar[k] = '1';
                    carry = false;
                }else if (reverseAChar[k] == '0' ^ reverseBChar[k] == '0'){
                    rchar[k] = '0';
                    carry = true;
                }else{
                    rchar[k] = '1';
                    carry = true;
                } 
            } 
        }

        if (!carry){
            for (int k = minlength; k < maxlength - 1; k++){
                rchar[k] = longerchar[k];
            }
        }else{
            for (int k = minlength; k < maxlength - 1; k++){
                if (!carry){
                    rchar[k] = longerchar[k];
                }else{
                    if (longerchar[k] == '0'){
                        rchar[k] = '1';
                        carry = false;
                    }else{
                        rchar[k] = '0';
                        carry = true;
                    }
                }
            }
        }
        int reallength = 0;
        if (carry){
            rchar[maxlength - 1] = '1';
            reallength = maxlength;
        }else{
            rchar[maxlength - 1] = '0';
            reallength = maxlength - 1;
        }
        char[] reverseChars = new char[reallength];
        String result = "";
        for (int i = reallength - 1; i > -1; i--){
            reverseChars[reallength - 1 - i] = rchar[i];
        }
        result = String.valueOf(reverseChars);
        return result;

        // this is a simple and concise solution from discussion
        
        // if(a == null || b ==null)
        // return a == null? b: a;

        // int carry =0;
        // StringBuilder sb = new StringBuilder();        

        // for(int i = a.length()-1, j = b.length() -1;  i >=0 || j >=0 || carry >0 ; i --, j --){
        //     int sum = 0;
        //     sum += (i >=0) ? a.charAt(i) - '0' : 0;
        //     sum += (j >=0) ? b.charAt(j) - '0' : 0;
        //     sum += carry;

        //     carry = sum /2;
        //     sum %=2;
        //     sb.append(sum);
        // }

        // return sb.reverse().toString();
    }
}
