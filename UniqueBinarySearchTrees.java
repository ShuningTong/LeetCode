// Dynamic Programming Question
public class UniqueBinarySearchTrees {

    public static void main(String[] args){
        if (args != null && args.length != 0){
            int n = Integer.parseInt(args[0]);
            System.out.println(numTrees(n));
        }else{
            System.out.println("Not valid input!");
        }
    }

    public static int numTrees(int n) {
        assert n >= 0;

        int[] results = new int[n + 1];
        results[0] = 1;
        if (n >= 1){
            results[1] = 1;
            if (n >= 2){
                results[2] = 2;
                for (int i = 3; i <= n; i++){
                    results[i] = 0;
                    for (int j = 1; j <= i; j++){
                        results[i] += results[j - 1] * results[i - j];
                    }
                } 
            }  
        }

        return results[n];
    }

    public static LinkedList<TreeNode> generateTrees(int n){
        
    }
}
