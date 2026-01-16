import java.util.*;
public class Median_Of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int nums1[] = new int[m];
        int nums2[] = new int[n];
        for(int i=0;i<m;i++){
            nums1[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            nums2[i]=sc.nextInt();
        }
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median = " + median);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){    // Array mai direct swapping is possible hai.
            int temp[] = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        // Applying Binary Search Logic.
        int lo = 0;
        int hi = nums1.length;  //(length-1)tak isliye chalaya taki ham pure elements ko acquire kar paye.
        int total = (nums1.length + nums2.length);
        int hf = (total + 1) / 2;
        while(lo <= hi){
            int nums1l = (lo + hi) / 2;    // nums1l = amid
            int nums2l = hf - nums1l;      // nums2l = bmid
            int nums1lml = (nums1l == 0) ? Integer.MIN_VALUE : nums1[nums1l - 1];  
            // nums1l-1 = nums1lml
            int nums1left = (nums1l == nums1.length) ? Integer.MAX_VALUE : nums1[nums1l];  
            // nums1l = nums1left
            int nums2lml = (nums2l == 0) ? Integer.MIN_VALUE : nums2[nums2l - 1];  
            // nums2l-1 = nums2lml
            int nums2left = (nums2l == nums2.length) ? Integer.MAX_VALUE : nums2[nums2l];  
            // nums2l = nums2left
            if(nums1lml <= nums2left && nums2lml <= nums1left){
                double ans;
                if(total % 2 == 0){
                    ans = (Math.max(nums1lml, nums2lml) + Math.min(nums1left, nums2left)) / 2.0;
                }else{
                    ans = Math.max(nums1lml, nums2lml) / 1.0;
                }
                return ans;
            }else if(nums1lml > nums2left){
                hi = nums1l - 1;
            }else if(nums2lml > nums1left){
                lo = nums1l + 1;
            }
        }
        return -1.0;
        // TC -> O(log(min(m,n)))
        // SC -> O(1)
    }
}
