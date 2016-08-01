import java.util.ArrayList;

// just a little bit of change based on NQueens.java

public class NQueens2 {

    public static void main(String[] args){
        System.out.println(solveNQueens(2));
    }

    public static int solveNQueens(int n) {
        // I use the index as row number, the value as the collumn number to indicate the position of a queen
        int[] solution = new int[n];
        return helper(0, solution, n, 0);
    }

    public static int helper(int resultsNo, 
                    int[] solution, 
                    int n, int row){
        if (row == n){
            return ++resultsNo;
        }

        outerloop:
        for (int i = 0; i < n; i++){
            solution[row] = i + 1;
            for (int j = 0 ; j < row; j++){
                if (attack(solution, j, row)){
                   continue outerloop;
                }
            }
            resultsNo = helper(resultsNo, solution, n, row + 1);
            solution[row] = 0;
        }
        return resultsNo;
    }

    public static boolean attack(int[] solution, int i, int j){
        if (i == j || solution[i] == solution[j] || Math.abs(solution[i] - solution[j]) == Math.abs(i - j)){
            return true;
        }
        return false;
    }
}
