package leetcode_contests.Weekly_Contest_482;

public class MaximumScoreofaSplit {
    
    public static long maximumScore(int[] nums) {
        int N = nums.length;
        long[] prefixSum = new long[N];
        prefixSum[0] = nums[0];

        for(int i = 1; i < N; i++){
            prefixSum[i] = prefixSum[i-1] + (long)nums[i];
        }

        
        long[] suffixMin = new long[N];
        suffixMin[N-2] = nums[N-1];
        
        for(int i = N-3; i >= 0; i--){
            suffixMin[i] = Math.min(nums[i+1], suffixMin[i+1]);
        }

        long ans = prefixSum[0] - suffixMin[0];
        for(int i = 1; i < N-1; i++){
            ans = Math.max(ans, prefixSum[i] - suffixMin[i]);
        }
        return ans;
        
    }
    
    public static void main(String[] args) {
        int[] nums0 = {10,-1,3,-4,-5};
        int[] nums1 = {-7,-5,3};
        int[] nums2 = {1,1};
        System.out.println(maximumScore(nums0));   
        System.out.println(maximumScore(nums1));   
        System.out.println(maximumScore(nums2));   
    }
}