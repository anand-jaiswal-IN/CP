package codechef_problems.START254;
import java.util.*;

public class MaximumSum {
    public static int sol(int[] nums, int k){
        // find the max sum of subarray having length n-k
        int s = 0, e = nums.length-k-1;
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += nums[i];
        }
        int ans = sum;
        e++;

        while(e < nums.length){
            sum += nums[e];
            sum -= nums[s];
            s++; e++;
            ans = Math.max(ans, sum);
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.println(sol(nums, k));
        }
        sc.close();
        // int[] nums = {8, 1, 6, 5};
        // int r = sol(nums, 2);
        // System.out.println(r);
    }
    
}