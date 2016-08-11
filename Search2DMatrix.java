
// 要小心处理边界

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m - 1;
        int row = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (matrix[mid][n - 1] < target){
                start = mid + 1;
            } else if (matrix[mid][0] > target){
                end = mid - 1;
            } else {
                row = mid;
                break;
            }
        }
        if (start > end){
            return false;
        }

        start = 0;
        end = n - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] < target){
                start = mid + 1;
            } else if (matrix[row][mid] > target){
                end = mid - 1;
            } else {
                return true;
            }
        }

        return false;

    }
}
