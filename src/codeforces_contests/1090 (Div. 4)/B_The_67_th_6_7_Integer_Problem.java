import java.util.Scanner;

public class B_The_67_th_6_7_Integer_Problem {
    public static long solution(int[] nums, long totalSumWithNeg){
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, totalSumWithNeg + (2 * nums[i]));
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int[] nums = new int[7];
            long totalSumWithNeg = 0;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
                totalSumWithNeg += (-1 * nums[i]);
            }
            System.out.println(solution(nums, totalSumWithNeg));
        }
        sc.close();
    }
}