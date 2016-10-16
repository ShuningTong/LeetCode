public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0){
            return null;
        }
        int len = numbers.length;
        int left = 0;
        int right = len - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if (sum < target){
                left++;
            } else if (sum > target){
                right--;
            } else {
                int[] result = {left + 1, right + 1};
                return result;
            }
        }
        int[] result = {};
        return result;
    }
}
