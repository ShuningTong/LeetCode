public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args){
        int[] a = new int[6];
        a[0] = 1;
        a[1] = 1;
        a[2] = 1;
        a[3] = 2;
        a[4] = 2;
        a[5] = 3;
        int distinctIndex = removeDuplicatesAllowAtMostTwice(a);
        System.out.println(distinctIndex);
        System.out.print("[");
        for (int i = 0; i < distinctIndex; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }

    public static int removeDuplicates(int[] a) {
        if(a.length == 0){
            return 0;
        }else if(a.length == 1){
            return 1;
        }
        int start = 0, end = 1;
        while(end < a.length){
            if (a[start] != a[end]){
                if (end > start + 1){
                    a[start + 1] = a[end];
                }
                start++;
            }
            end++;   
        }
        return start + 1;
    }

    public static int removeDuplicatesAllowAtMostTwice(int[] a) {
        if(a.length == 0){
            return 0;
        }else if(a.length == 1){
            return 1;
        }
        int start = 0, end = 1;
        boolean allowOneMoreDuplicate = true;
        while(end < a.length){
            if (a[start] != a[end]){
                if (end > start + 1){
                    a[start + 1] = a[end];
                }
                start++;
                allowOneMoreDuplicate = true;  
            }else{
                if (allowOneMoreDuplicate){
                    // a[start] = a[end] does not necessarily mean that start and end are neighbors, so we have to copy value from end to start + 1.
                    a[start + 1] = a[end];
                    start++;
                    allowOneMoreDuplicate = false;
                }
            }
            end++;
        }
        return start + 1;
    }
}
