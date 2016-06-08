/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.PriorityQueue;
import java.util.Comparator;
public class MergeKSortedList {

    public static void main(String[] args){
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(10);
        lists[1] = new ListNode(2);
        lists[1].next = new ListNode(5);
        lists[2] = new ListNode(3);
        lists[2].next = new ListNode(11);
        System.out.println(lists[0]);
        System.out.println(lists[1]);
        System.out.println(lists[2]);
        System.out.println(mergeKListsBasedOnPQ(lists));
    }

    // this is the solution I implemented myself using a Not-In-Place algorithm
    // it works fine but it's not accepted by LeetCode because it's way too slow
    // its runtime is O(kn)
    public static ListNode mergeKListsOriginal(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        int numOfNulls = 0;
        for (ListNode n: lists){
            if(n == null){
                numOfNulls++;
            }
        }
        if (numOfNulls == lists.length){
            return null;
        }
        int minVal = 0;
        int minIndex = 0;
        for (int i = 0; i < lists.length; i++){
            if (lists[i] != null){
                minVal = lists[i].val;
                minIndex = i;
                break;
            }
        }

        // this is the ListNode we want to return
        ListNode newStart;
        for (int i = minIndex + 1; i < lists.length; i++){
            if (lists[i] != null){
                if (lists[i].val < minVal){
                    minVal = lists[i].val;
                    minIndex = i;
                } 
            }
        }
        newStart = new ListNode(minVal);
        lists[minIndex] = lists[minIndex].next;
        

        ListNode newCur = newStart;

        while(true){
            numOfNulls = 0;
            for (ListNode n: lists){
                if(n == null){
                    numOfNulls++;
                }
            }
            if (numOfNulls == lists.length){
                break;
            }

            for (int i = 0; i < lists.length; i++){
                if (lists[i] != null){
                    minVal = lists[i].val;
                    minIndex = i;
                    break;
                }
            }

            for (int i = minIndex + 1; i < lists.length; i++){
                if(lists[i] != null){
                    if (lists[i].val < minVal){
                        minVal = lists[i].val;
                        minIndex = i;
                    }
                }
            }
            newCur.next = new ListNode(minVal);
            newCur = newCur.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return newStart;
    }

    // this is the solution based on mergeTwoLists and the recursive algorithm from mergeSort
    // runtime is O(nlogk). in reality this solution is the fastest, because no extra time cost for building priority queue.
    public static ListNode mergeKListsBasedOnTwo(ListNode[] lists){
        // null ListNode can be detected in mergeTwoLists
        if (lists == null || lists.length == 0){
            return null;
        }
        return mergeKListsRecursive(lists, 0, lists.length - 1);
    }

    public static ListNode mergeKListsRecursive(ListNode[] lists, int lo, int hi) {
        if (hi <= lo){
            return lists[lo];
        }
        int mid = (lo + hi) / 2;
        ListNode beforeMid = mergeKListsRecursive(lists, lo, mid);
        ListNode afterMid = mergeKListsRecursive(lists, mid + 1, hi);
        return mergeTwoListsInPlace(beforeMid, afterMid);
    }

    public static ListNode mergeTwoListsInPlace(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode small, big, prevSmall = null;
        small = l1.val <= l2.val ? l1 : l2;
        big = l1.val <= l2.val ? l2 : l1;
        ListNode result = small;
        while (big != null) {
            while (small != null && small.val <= big.val) {
                prevSmall = small;
                small = small.next;
            }
            prevSmall.next = big;
            big = small;
            small = prevSmall.next;
        }
        return result;
    }

    // this is the solution based on priority queue
    // runtime is O(nlogk)
    public static ListNode mergeKListsBasedOnPQ(ListNode[] lists){
        // in the following pq, it will only add those ListNode that are not null
        if (lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new NodeComparator());
        // also can do new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
        //     @Override
        //     public int compare(ListNode o1,ListNode o2){
        //         if (o1.val<o2.val)
        //             return -1;
        //         else if (o1.val==o2.val)
        //             return 0;
        //         else 
        //             return 1;
        //     }
        // });

        for (ListNode n: lists){
            if (n != null){
                pq.add(n);
            }
        }
        ListNode result = new ListNode(0);
        ListNode cur = result;

        while(!pq.isEmpty()){
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null){
                pq.add(cur.next);
                //we don't need the following line of code
                //cur.next = null;
            }
        }
        return result.next;
    }

    public static class NodeComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode o1,ListNode o2){
            if (o1.val < o2.val)
                return -1;
            else if (o1.val == o2.val)
                return 0;
            else 
                return 1;
        }
    }
}
