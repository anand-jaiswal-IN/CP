package leetcode_contests.Biweekly_Contest_175;

import java.util.*;

public class MinimumKtoReduceArrayWithinLimit {
    public static boolean check(int[] nums, long ans){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % ans == 0){
                sum += nums[i]/ans;
            }else{
                sum += nums[i]/ans;
                sum += 1;
            }
        }
        return sum <= (long)Math.pow(ans, 2);
    }
    public static int minimumK(int[] nums) {
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        double d = (double)1/3;
        int ans = (int)Math.ceil(Math.pow(sum, d));

        if(check(nums, ans))
            return ans;
        return ans+1;
    }

    public static int minimumK2(int[] nums) {
        Arrays.sort(nums);
        long left = 1, right = Integer.MAX_VALUE;

        while(left <= right){
            long mid = left + (right-left)/2;
            if(check(nums, mid)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return (int)left;
    }

    public static void main(String[] args) {
        // int[] nums = {1,3,3};
        // int[] nums = {1,1};
        int[] nums = {1,1,1,1,1};
        int k = minimumK2(nums);
        System.out.println(k);
    }
}
