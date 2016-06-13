public class SearchInRotatedSortedArray {
    public static void main(String[] args){
        // int[] a = {6, 7, -1, 1, 2, 4, 5};
        if(args != null && args.length != 0){
            int[] a = new int[args.length - 1];
            for (int i = 0; i < args.length - 1; i++){
                a[i] = Integer.parseInt(args[i]);
            }
            int target = Integer.parseInt(args[args.length - 1]);
            System.out.println(search(a, target));
        }else{
            System.out.println("Not valid input!");
        }
    }

    // the original algorithm uses findMinimumRotatedSortedArray to find minimum first and then apply binary search
    // this thinking is endorsed by a popular post on discussion board for this question
    public static boolean search(int[] a, int target) {
        int minIndex = findMinIndexAllowDuplicates(a);
        // System.out.println("Found minimum at: " + minIndex + "!");
        int start = minIndex, end = a.length + minIndex - 1;
        int mid = (start + end)/2;

        while(start < end){
            if(a[mid%(a.length)] < target){
                start = mid + 1;
            }else if(a[mid%(a.length)] > target){
                end = mid - 1;
            }else{
                return true;
            }
            mid = (start + end)/2;
        }
        if (a[start%(a.length)] == target){
            return true;
        }else{
            return false;
        }
    }

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
        return start;
    }

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
