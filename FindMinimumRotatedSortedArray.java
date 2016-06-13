public class FindMinimumRotatedSortedArray {
    public static void main(String[] args){
        // int[] a = {6, 7, -1, 1, 2, 4, 5};
        if(args != null && args.length != 0){
            int[] a = new int[args.length];
            for (int i = 0; i < args.length; i++){
                a[i] = Integer.parseInt(args[i]);
            }
            int b = findMinIndexAllowDuplicates(a);
            System.out.println("Found the minimum element at: " + b + "!");
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
    // this is the revised solution based on the original solution
    // this one is explained in my blog
    public static int findMin2nd(int[] a) {
        int start = 0;
        int end = a.length - 1;
        int mid = (start + end)/2;

        while(start < end){
            if (a[mid] < a[end]){
                end = mid;
            }else if(a[mid] > a[end]){
                start = mid + 1;
            }
            mid = (start + end)/2;
        }
        return a[start];
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

    // this solution is for this kind of problems with duplicates
    // start++ and end-- part is downloaded from discussion board
    //https://leetcode.com/discuss/13775/one-simple-and-clear-method-with-o-1-space-and-worst-o-n-time
    // runtime is O(N)
    public static int findMinAllowDuplicates(int[] a) {
        int start = 0;
        int end = a.length - 1;
        int mid = (start + end)/2;

        while(start < end){
            if (a[mid] < a[end]){
                end = mid;
            }else if(a[mid] > a[end]){
                start = mid + 1;
            }else{
                if (a[mid] != a[start]){
                    end = mid;
                }else{
                    start++;
                    end--;
                }
            }
            mid = (start + end)/2;
        }
        return a[start];
    }

    // when duplicates are allowed, we have to be cautious:
    // 1. when duplicates are not allowed, all situations will converge to start == end,
    // so we are sure that start (or end) is the min index, and a[start] (or a[end]) is the min value. this rule no longer exists when we allow duplicates. Because we may get start > end finally. When start > end, we know actually a[start] == a[end], but if we want to return the minIndex, it should be end.
    // 2. when a[mid] == a[end] && a[mid] == a[start], we are not sure which side is broken. In the process of start++ end--, once we encounter an unequal relation, we know this side is broken. the else if and else part is correct. we need to adjust a little bit to if part.
    public static int findMinIndexAllowDuplicates(int[] a) {
        int start = 0;
        int end = a.length - 1;
        int mid = (start + end)/2;

        boolean notSureWhichSideIsBroken = false;
        while(start < end){
            if (a[mid] < a[end]){
                if (notSureWhichSideIsBroken){
                    break;
                }
                end = mid;
            }else if(a[mid] > a[end]){
                start = mid + 1;
            }else{
                if (a[mid] != a[start]){
                    end = mid;
                    notSureWhichSideIsBroken = false;
                }else{
                    start++;
                    end--;
                    notSureWhichSideIsBroken = true;
                }
            }
            mid = (start + end)/2;
        }
        if (start < end && notSureWhichSideIsBroken){
            return end + 1;
        }
        return end;
    }

}
