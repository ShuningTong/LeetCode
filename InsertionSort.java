import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class InsertionSort{

    public static void main(String[] args){
        if (args != null && args.length != 0){
            try{
                FileInputStream fis = new FileInputStream(args[0]);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                String line = reader.readLine();
                if (line != null){
                    String[] strings = line.split(" ");
                    sort(strings);
                    for (String s: strings){
                        System.out.println(s);
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            System.out.println("Not valid input");
        }
    }

    public static <T extends Comparable<? super T>> void sort(T[] a){
        for (int i = 0; i < a.length; i++){
            for (int j = i; j > 0; j--){
                if (less(a[j], a[j - 1])){
                    exch(a, j, j - 1);
                }else{
                    break;// break the inner for loop
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> boolean less(T v, T w){
        return v.compareTo(w) < 0;
    }

    public static <T extends Comparable<? super T>> void exch(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
