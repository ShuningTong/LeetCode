import java.util.ArrayList;
public class RestoreIPAddress {

    public static void main(String[] args){
        System.out.println(restoreIpAddressesBacktrack("25525511135"));
        System.out.println(restoreIpAddressesBacktrack("101023"));
        System.out.println(restoreIpAddressesBacktrack("000"));
    }

    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> results = new ArrayList<>();
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++){
            if (len - i > 9){
                continue;
            }
            for (int j = i + 1; j < i + 4 && j < len - 1; j++){
                if (len - j > 6){
                    continue;
                }
                // k < len already catches all situations that
                // i or j or k exceeds index max value
                for (int k = j + 1; k < j + 4 && k < len; k++){
                    if (len - k > 3){
                        continue;
                    }

                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k);

                    if (isValid(a) && isValid(b) && isValid(c) && isValid(d)){
                        results.add(a + "." + b + "." + c + "." + d);
                    }
                    
                }
            }
        }
        return results;
    }

    public static boolean isValid(String s){
        if ((s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255){
            return false;
        }
        return true;
    }

    public static ArrayList<String> restoreIpAddressesBacktrack(String s) {
        ArrayList<String> results = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12){
            return results;
        }
        ArrayList<String> list = new ArrayList<>();
        helper(results, list, s, 0);
        return results;
    }

    public static void helper(ArrayList<String> results, 
                            ArrayList<String> list, 
                            String s, int indexFrom){
        if (list.size() == 4){
            if (indexFrom != s.length()){
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String temp: list){
                sb.append(temp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            results.add(sb.toString());
            return;  
        }

        for (int indexTo = indexFrom; indexTo < s.length() && indexTo < indexFrom + 3; indexTo++){
            String temp = s.substring(indexFrom, indexTo + 1);
            if (isValid(temp)){
                list.add(temp);
                helper(results, list, s, indexTo + 1);
                list.remove(list.size() - 1);
            }
        }
    }

}
