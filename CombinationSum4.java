import java.util.Arrays;

// DP solution
//https://discuss.leetcode.com/topic/52302/1ms-java-dp-solution-with-detailed-explanation
public class CombinationSum4 {

    public static void main(String[] args){
        int[] candidates = new int[3];
        candidates[0] = 1;
        candidates[1] = 2;
        candidates[2] = 3;

        System.out.println(combinationSum4(candidates, 32));
    }

    public static int combinationSum4(int[] candidates, int target) {
        if (candidates == null){
            return 0;
        }
        int[] result = new int[target + 1];
        result[0] = 1;
        for (int i = 1; i < result.length; i++){
            for (int j = 0; j < candidates.length; j++){
                if (i - candidates[j] >= 0){
                    result[i] += result[i - candidates[j]];
                }
            }
        }
        return result[target];

    }

}
