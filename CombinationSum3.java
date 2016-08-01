import java.util.ArrayList;
public class CombinationSum3 {

    public static void main(String[] args){
        System.out.println(combinationSum3(3, 9));
    }


    public static ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        // assume n > 0, k > 0
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++){
            nums[i] = i + 1;
        }
        backtrack(result, temp, nums, k, n, 0, 0, 8);
        return result;
    }

    public static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int[] nums, int k, int n,  int used, int sum, int start){
        if (used == k && sum == n){
            result.add(new ArrayList<Integer>(temp));
            return;
        }else if (used == k || sum == n){
            return;
        }
        for (int i = start; i >= 0; i--){
            int cur = nums[i];
            if (sum + cur > n){
                continue;
            }else{
                // this is for making all combination sets sorted
                temp.add(0, cur);
                sum += cur;
                used++;
            }
            backtrack(result, temp, nums, k, n, used, sum, i - 1);
            temp.remove(0);
            sum -= cur;
            used--;
        }
    }
}
