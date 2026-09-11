package codeforces_contests.good_bye_2025;
import java.util.*;

public class C_First_or_Second {

    public static long solution(int[] nums, int N){
        int[] suffixSum = new int[N+1];

        for (int i = N-1; i >= 0; i--) {
            suffixSum[i] = nums[i] + suffixSum[i+1];
        }

        long ans = -suffixSum[1];
        
        for(int k = 1; k < N; k++){
            long temp_ans = nums[0] - suffixSum[k+1];
            for (int i = 1; i < k; i++) {
                temp_ans += Math.abs(nums[i]);
            }    
            ans = Math.max(ans, temp_ans);
        }
        return ans;
    }

    public static long solution2(int[] nums, int N){
        long[] suffixSum = new long[N+1];

        for (int i = N-1; i >= 0; i--) {
            suffixSum[i] = nums[i] + suffixSum[i+1];
        }

        long[] prefixAbsSum = new long[N];
        for (int i = 1; i < N; i++) {
            prefixAbsSum[i] = prefixAbsSum[i-1] + Math.abs(nums[i]);
        }

        long ans = -suffixSum[1];
        
        for(int k = 1; k < N; k++){
            long temp_ans = nums[0] + prefixAbsSum[k-1]  - suffixSum[k+1];
            ans = Math.max(ans, temp_ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
        
            int N = sc.nextInt();
            int[] nums = new int[N];

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.println(solution2(nums, N));
            
        }
        sc.close();

        // int[] nums = {7, -6, -1, -8, -8};
        // System.out.println(solution(nums, nums.length));
    }
}