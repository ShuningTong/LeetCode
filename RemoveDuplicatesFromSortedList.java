public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode l1Cur = l1;
        
        l1Cur.next = new ListNode(2);
        l1Cur = l1Cur.next;
        l1Cur.next = new ListNode(3);
        l1Cur = l1Cur.next;
        l1Cur.next = new ListNode(3);
        
        // this is the unsorted list
        System.out.println(l1);
        // this is the sorted list
        System.out.println(keepDistinct(l1));
        // this is what is left at head after sorting
        System.out.println(l1);
    }

    // this method is based on the thinking:
    // find a different one and append it onto the noDuplicatesPart
    public static ListNode removeOperateNotEqual(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode tailOfNoDuplicatesPart = head;
        ListNode cur = head.next;
        int curValue = head.val;
        while(cur != null){
            if (cur.val != curValue){
                curValue = cur.val;
                tailOfNoDuplicatesPart.next = cur;
                tailOfNoDuplicatesPart = tailOfNoDuplicatesPart.next;
            }
            cur = cur.next;

        }
        tailOfNoDuplicatesPart.next = null;
        return head;
    }


    // this method is based on the thinking:
    // when reach to a same (compare to the previous one) node, delete it
    public static ListNode removeOperateEqual(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode prevCur = head;
        ListNode cur = head.next;
        int prevCurValue = head.val;
        while(cur != null){
            if (cur.val == prevCurValue){
                prevCur.next = cur.next;
                cur = prevCur.next;
            }else{
                prevCur = cur;
                cur = cur.next;
                prevCurValue = prevCur.val;
            }
        }
        return head;
    }

    // this method is for keeping only those nodes that are alone.
    public static ListNode keepDistinct(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode prevCur = head;
        ListNode cur = head.next;
        boolean isDuplicated = false;

        while(cur != null){
            if (cur.val == prevCur.val){
                prevCur.next = cur.next;
                cur = prevCur.next;
                isDuplicated = true;
            }else{
                if (!isDuplicated){
                    break;
                }else{
                    fakeHead.next = cur;
                    prevCur = fakeHead.next;
                    cur = cur.next;
                    isDuplicated = false;
                }
            }
        }

        if (cur == null && isDuplicated){
            return null;
        }else if(cur == null && !isDuplicated){
            return fakeHead.next;
        }


        ListNode afterCur = cur.next;
        isDuplicated = false;

        while(afterCur != null){
            if (afterCur.val == cur.val){
                cur.next = afterCur.next;
                afterCur = cur.next;
                isDuplicated = true;
            }else{
                if(!isDuplicated){
                    prevCur = cur;
                    cur = afterCur;
                    afterCur = cur.next;
                }else{
                    prevCur.next = afterCur;
                    cur = prevCur.next;
                    afterCur = cur.next;
                    isDuplicated = false;
                }
            }
        }

        if (afterCur == null && isDuplicated){
            prevCur.next = null;
        }
        
        return fakeHead.next;
    }
}
