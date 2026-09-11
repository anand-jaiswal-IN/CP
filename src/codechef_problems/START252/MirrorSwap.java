package START252;
import java.util.Scanner;

public class MirrorSwap {
    public static int sol(int[] nums){
        int ans = 0;

        for (int i = 0; i < nums.length/2; i++) {
            int n1 = nums[i];
            int n2 = nums[nums.length-1-i];
            ans += Math.max(n1, n2);
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[2*n];

            for (int i = 0; i < 2*n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(sol(nums));
        }
        sc.close();
    }
    
}