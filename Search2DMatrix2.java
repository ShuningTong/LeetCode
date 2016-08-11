
// https://discuss.leetcode.com/topic/20064/my-concise-o-m-n-java-solution

// 这个方法的时间复杂度是 O(m + n)
public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while(x < m && y >= 0){
            if (matrix[x][y] < target){
                x++;
            } else if (matrix[x][y] > target){
                y--;
            } else {
                return true;
            }
        }
        return false;
    }
}
