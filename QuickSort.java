import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

// This QuickSort implementation takes the last element as the pivot.

public class QuickSort{

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
        //StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
    public static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi){
        if (hi <= lo){
            return;
        }
        int i = lo, j = hi - 1;
        int pivot = hi;
        while(true){
            while(less(a[i], a[pivot])){
                if (i == hi){
                    break;
                }
                i++;
            }
            while(less(a[pivot], a[j])){
                if (j == lo){
                    break;
                }
                j--;
            }
            if(i >= j){
                break;
            }
            exch(a, i, j);
        }
        exch(a, i, pivot);
        sort(a, lo, i - 1);
        sort(a, i + 1, hi);
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
