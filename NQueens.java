import java.util.ArrayList;

// this is a hard question, but not too difficult.
// I use the same DFS method for "find all" problems.

public class NQueens {

    public static void main(String[] args){
        System.out.println(solveNQueens(8));
    }

    public static ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        // I use the index as row number, the value as the collumn number to indicate the position of a queen
        int[] solution = new int[n];
        helper(results, solution, n, 0);
        return results;
    }

    public static void helper(ArrayList<ArrayList<String>> results, 
                    int[] solution, 
                    int n, int row){
        if (row == n){
            ArrayList<String> solutionList = new ArrayList<>();
            for (int i = 0; i < n; i++){
                int queenPos = solution[i] - 1;
                StringBuilder sb =  new StringBuilder();
                for (int j = 0; j < queenPos; j++){
                    sb.append(".");
                }
                sb.append("Q");
                for (int j = queenPos + 1; j < n; j++){
                    sb.append(".");
                }
                solutionList.add(sb.toString());
            }
            results.add(solutionList);
            return;
        }

        outerloop:
        for (int i = 0; i < n; i++){
            solution[row] = i + 1;
            for (int j = 0 ; j < row; j++){
                if (attack(solution, j, row)){
                   continue outerloop;
                }
            }
            helper(results, solution, n, row + 1);
            solution[row] = 0;
        }
    }

    public static boolean attack(int[] solution, int i, int j){
        if (i == j || solution[i] == solution[j] || Math.abs(solution[i] - solution[j]) == Math.abs(i - j)){
            return true;
        }
        return false;
    }
}
