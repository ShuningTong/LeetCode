import java.util.LinkedList;

public class MinimumHeightTreesFromUndirectedGraph {

    public static void main(String[] args){
        int[][] edges = new int[3][2];
        edges[0][0] = 1;
        edges[0][1] = 0;
        edges[1][0] = 1;
        edges[1][1] = 2;
        edges[2][0] = 1;
        edges[2][1] = 3;
        LinkedList<Integer> roots = findMinHeightTrees(4, edges);
        for (Integer i: roots){
            System.out.println(i);
        }
    }

    public static LinkedList<Integer> findMinHeightTrees(int n, int[][] edges) {
        LinkedList<Integer> result = new LinkedList<>();
        if (n == 0){
            return result;
        }else if(n == 1){
            result.add(0);
            return result;
        }
        @SuppressWarnings("unchecked") LinkedList<Integer>[] lists = new LinkedList[n];
        for (int i = 0; i < n; i++){
            lists[i] = new LinkedList<Integer>();
        }
        for (int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            lists[a].add(b);
            lists[b].add(a);
        }
        for (int i = 0; i < n; i++){
            if (lists[i].size() == 1){
                result.add(i);
            }
        }
        int count = n;
        while(count > 2){
            int size = result.size();
            count -= size;
            LinkedList<Integer> newLeaves = new LinkedList<>();
            for (int leaf: result){
                int toRemoveFrom = lists[leaf].get(0);
                lists[toRemoveFrom].remove(Integer.valueOf(leaf));
                if (lists[toRemoveFrom].size() == 1){
                    newLeaves.add(toRemoveFrom);
                }
            }
            result = newLeaves;
        }
        return result;

    }
}
