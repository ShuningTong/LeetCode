import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// Merge Sorted Array is part of merge sort.
// A possible improvement is that:
// if we do have one of the arrays capable to hold all the elements from two arrays,
// then we do not need an aux array.
public class MergeSortedArray {
    public static void main(String[] args){
        if (args != null && args.length != 0){
            try{
                FileInputStream fis = new FileInputStream(args[0]);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));  
                String lengths = reader.readLine();
                String firstArray = reader.readLine();
                String secondArray = reader.readLine();
                String[] sLengths = lengths.split(" ");
                int m = Integer.parseInt(sLengths[0]);
                int n = Integer.parseInt(sLengths[1]);
                int[] nums1 = new int[m + n];
                int[] nums2 = new int[n];
                String[] sFirstArray = firstArray.split(" ");
                String[] sSecondArray = secondArray.split(" ");
                for (int i = 0; i < m; i++){
                    nums1[i] = Integer.parseInt(sFirstArray[i]);
                }
                for (int j = 0; j < n; j++){
                    nums2[j] = Integer.parseInt(sSecondArray[j]);
                }
                merge(nums1, m, nums2, n);
                for (int i = 0; i < m + n; i++){
                    System.out.println(nums1[i]);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            System.out.println("Not valid input!");
        }
    }
    
    // the pre-requisite of this method is that nums1 have a length of m + n.
    // note the difference of this implementation with that in MergeSort.java
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; k >= 0; k--){
            if (i < 0){
                nums1[k] = nums2[j];
                j--;
            }else if(j < 0){
                nums1[k] = nums1[i];
                i--;
            // this sign of operator is different!! because we are comparing which is larger.
            }else if(nums2[j] >= nums1[i]){
                nums1[k] = nums2[j];
                j--;   
            }else{
                nums1[k] = nums1[i];
                i--;
            }
        }
    }
}
