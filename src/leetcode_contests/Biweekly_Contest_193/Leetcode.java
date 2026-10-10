package leetcode_contests.Biweekly_Contest_193;
import java.util.Arrays;

public class Leetcode {
    public int[] maxProductPair(int[] nums, int target) {
        long maxProduct = Long.MIN_VALUE;
        int[] ans = {-1, -1};
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target && nums[i] != nums[j]){
                    long p = (long)nums[i] * nums[j];
                    if(p > maxProduct){
                        maxProduct = p;
                        ans[0] = nums[i] > nums[j] ? i : j;
                        ans[1] = nums[i] > nums[j] ? j : i;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Leetcode obj = new Leetcode();
        int[] nums = {4,5,-6,-7};
        int target = -2;

        int[] r = obj.maxProductPair(nums, target);
        System.out.println(Arrays.toString(r));
    }
}
