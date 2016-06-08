import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

// This merge sort is implemented based on Princeton's algorithm
public class MergeSort{

    public static void main(String[] args){
        if (args != null && args.length != 0){
            try{
                FileInputStream fis = new FileInputStream(args[0]);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                String line = reader.readLine();
                if (line != null){
                    String[] a = line.split(" ");
                    String[] aux = new String[a.length];
                    sort(a, aux);
                    for (String s: a){
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
    public static <T extends Comparable<? super T>> void sort(T[] a, T[] aux){
        sort(a, aux, 0, a.length - 1);
    }
    public static <T extends Comparable<? super T>> void sort(T[] a, T[] aux, int lo, int hi){
        if (hi <= lo){
            return;
        }
        int mid = (lo + hi)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
    public static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int mid, int hi){
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        for (int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++){
            if (i > mid){
                a[k] = aux[j++];
            }else if (j > hi){
                a[k] = aux[i++];
            }else if (less(aux[j], aux[i])){
                a[k] = aux[j++];
            }else{
                a[k] = aux[i++];
            }
        }
        assert isSorted(a, lo, hi);
    }

    public static <T extends Comparable<? super T>> boolean less(T v, T w){
        return v.compareTo(w) < 0;
    }

    public static <T extends Comparable<? super T>> boolean isSorted(T[] a, int lo, int hi){
        if (hi <= lo){
            return false;
        }
        if (hi >= a.length){
            return false;
        }
        for (int i = lo + 1; i <= hi; i++){
            if (less(a[i], a[i - 1])){
                return false;
            }
        }
        return true;
    }
}
