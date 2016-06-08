import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayIntersection {

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("First integer array:");
        String s1 = sc.nextLine();
        String[] a1 = s1.split(" ");
        int[] nums1 = new int[a1.length];
        for (int i = 0; i < a1.length; i++){
            nums1[i] = Integer.parseInt(a1[i]);
        }

        System.out.println("Second integer array:");
        String s2 = sc.nextLine();
        String[] a2 = s2.split(" ");
        int[] nums2 = new int[a2.length];
        for (int i = 0; i < a2.length; i++){
            nums2[i] = Integer.parseInt(a2[i]);
        }
        int[] result = intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));  
        sc.close();
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i: nums1){
            if (list1.isEmpty() || list1.indexOf(i) == -1){
                list1.add(i);
            }
        }
        for (int i: nums2){
            if (list2.isEmpty() || list2.indexOf(i) == -1){
                list2.add(i);
            }
        }
        for (int i: list1){
            if (list2.indexOf(i) != -1){
                list3.add(i);
            }
        }
        int resultSize = list3.size();
        int[] result = new int[resultSize];
        for (int i = 0; i < resultSize; i++) {
            result[i] = list3.get(i);
        }
        return result;
    }
}
