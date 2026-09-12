package codechef_problems.START254;
import java.util.*;

public class GoodSubsetEasy {
    public static int sol(int[] nums) {
        int[] freq = new int[31];

        for (int num : nums) {
            int highestBit = 31 - Integer.numberOfLeadingZeros(num);
            freq[highestBit]++;
        }

        int ans = 0;

        for (int count : freq) {
            ans = Math.max(ans, count);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            int[] nums = new int[N];

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.println(sol(nums));
        }

        sc.close();
    }

}