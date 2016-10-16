// leetcode no.1

import java.util.Arrays;

public class TwoSumSort {
    public static int[] twoSum(int[] nums, int target) {
        int l = nums.length;
        Pair[] pair = new Pair[l];
        for (int i = 0; i < l; i++){
            pair[i] = new Pair(i, nums[i]);
        }
        Arrays.sort(pair);
        int[] result = new int[2];
        int x = 0, y = l - 1;
        while(x != y && x < l && y >= 0){
            int sum = pair[x].value + pair[y].value;
            if (sum == target){
                result[0] = pair[x].index;
                result[1] = pair[y].index;
                break;
            } else if (sum < target){
                x++;
            } else if (sum > target){
                y--;
            }
        }
        return result;
    }



// test
    public static void main(String[] args){
        int[] nums = new int[3];
        nums[0] = 7;
        nums[1] = 3;
        nums[2] = 2;
        int[] result = twoSum(nums, 9);
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i] + " ");
        }
    }
    
}
