package leetcode_contests.Weekly_Contest_488;
public class Leetcode {

    public static int dominantIndices(int[] nums) {
        long totalSum = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }
        // long avg = totalSum / nums.length;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum -= nums[i];
            double avg = (double)totalSum / (nums.length - i -1);
            if(nums[i] > avg){
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {5,4,3};
        int r = dominantIndices(nums);
        System.out.println(r);
    }
}