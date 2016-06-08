public class FindMinimumRotatedSortedArray {
    public static void main(String[] args){
        // int[] a = {6, 7, -1, 1, 2, 4, 5};
        if(args != null && args.length != 0){
            int[] a = new int[args.length];
            for (int i = 0; i < args.length; i++){
                a[i] = Integer.parseInt(args[i]);
            }
            int b = findMin(a);
            System.out.println("Found the minimum element: " + b + "!");
        }else{
            System.out.println("Not valid input!");
        }
    }
    public static int findMinOriginal(int[] a) {
        // for corner case where the length of array is 1
        if(a.length == 1){
            return a[0];
        }
        int start = 0;
        int end = a.length - 1;

        // for corder case where the array is not rotated
        if(a[start] < a[end]){
            return a[0];
        }

        int mid = (start + end)/2;
        
        while(true){
            // must put a[mid+1] < a[mid] before a[mid - 1] > a[mid]
            if(a[mid+1] < a[mid]){
                return a[mid + 1];
            }else if(a[mid - 1] > a[mid]){
                return a[mid];
            }else if(a[start] > a[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            mid = (start + end)/2;
        }

        // while(true){
        //     if(a[mid] > a[start]){
        //         if(a[mid+1] < a[mid]){
        //             return a[mid + 1];
        //         }else if(a[mid - 1] > a[mid]){
        //             return a[mid];
        //         }else{
        //             start = mid + 1;
        //         }
        //     }else{
        //         if(a[mid+1] < a[mid]){
        //             return a[mid + 1];
        //         }else if(a[mid - 1] > a[mid]){
        //             return a[mid];
        //         }else{
        //             end = mid - 1;
        //         }
        //     }
        //     mid = (start + end)/2;
        // }
    }
    // this solution is downloaded from the discussion board of Leetcode
    //https://leetcode.com/discuss/13389/compact-and-clean-c-solution
    // runtime is O(logN)
    public static int findMin(int[] a) {
        int start = 0;
        int end = a.length - 1;
        while(start < end){
            if (a[start] < a[end]){
                return a[start];
            }
            int mid = (start + end) / 2;
            if (a[mid] >= a[start]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return a[start];
    }
}
