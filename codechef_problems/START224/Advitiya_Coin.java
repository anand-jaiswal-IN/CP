package START224;
import java.util.Scanner;

public class Advitiya_Coin {
    public static long solution(long[] nums, long k) {
        int n = nums.length;

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int start = i;
            int j = start + 1;
            long temp_ans = 0;
            while (j < n) {
                if (Math.abs(nums[start] - nums[j]) > k) {
                    temp_ans++;
                    start = j;
                    j = start + 1;
                }
                j++;
            }
            ans = Math.max(ans, temp_ans);
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();

            long[] nums = new long[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextLong();
            }

            System.out.println(solution(nums, k));
        }
        sc.close();
    }
}