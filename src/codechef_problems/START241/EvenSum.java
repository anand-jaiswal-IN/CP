package START241;
import java.util.Scanner;

public class EvenSum {
    public static boolean sol(int[] nums, long sum){
        for (int i = 0; i < nums.length; i++) {
            if(((sum - nums[i]) % 2) == 0) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
                sum += nums[i];
            }
            System.out.println(sol(nums, sum) ? "Yes" : "No");
        }
        sc.close();
    }
}