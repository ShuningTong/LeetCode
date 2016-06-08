import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class MoveZeroes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Integer array:");
        String s = sc.nextLine();
        String[] sa = s.split(" ");
        int[] nums = new int[sa.length];
        for (int i = 0; i < sa.length; i++){
            nums[i] = Integer.parseInt(sa[i]);
        }
        System.out.println(Arrays.toString(move(nums)));
    }
    public static int[] move(int[] nums) {  
        int curIndex = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[curIndex] = nums[i];
                curIndex++;
            }
        }
        for (int i = curIndex; i < nums.length; i++){
            nums[i] = 0;
        }
        return nums;
    }
}
