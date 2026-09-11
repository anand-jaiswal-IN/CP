package CP_31_900;
import java.util.*;

public class D_Balanced_Round {
    public static int solution2(int N, int k, int[] nums) {
        if (N == 0 || N == 1)
            return 0;

        Arrays.sort(nums);

        int ans = 1;
        int prevAns = 1;
        for (int i = 1; i < N; i++) {
            if (nums[i] - nums[i - 1] <= k)
                prevAns++;
            else {
                prevAns = 1;
            }
            ans = Math.max(ans, prevAns);
        }
        return N - ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++)
                nums[i] = sc.nextInt();

            System.out.println(solution2(N, k, nums));
            t--;
        }
        sc.close();
    }
}