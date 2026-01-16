import java.util.*;
public class Three_Sum {
    public static void main(String[] args) {
        // Example usage
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;     //I am Handling Duplicates for i.
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum>0){
                    k--;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k])); //Jaise hi pair milega add kra dunga list mai.
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]){   //I am Handling Duplicates for j.
                        j++;
                    }
                    while(j<k && nums[k]==nums[k+1]){   //I am handling Duplicates for k.
                        k--;
                    }
                }
            }
        }
        return ans;
        //
    }
}
