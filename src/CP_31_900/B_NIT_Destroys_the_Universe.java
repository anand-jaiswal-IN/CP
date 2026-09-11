package CP_31_900;
import java.util.Scanner;

public class B_NIT_Destroys_the_Universe {

    public static int solution(int[] nums, int N) {
        int li = 0, ri = N - 1;
        while (nums[li] == 0 && li < N - 1) {
            li++;
        }
        while (nums[ri] == 0 && ri > 0) {
            ri--;
        }
        if (li > ri)
            return 0;

        int ans = 1;
        for (int i = li; i <= ri; i++) {
            if (nums[i] == 0)
                ans++;
        }
        return ans;
    }

    public static int solution2(int[] nums, int N) {
    int ans = 0;
    for (int i = 0; i < N; i++) {
        if (nums[i] > 0) {
            ans++;
            while (i < N && nums[i] > 0) {
                i++;
            }
        }
    }
    return ans;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
        nums[i] = sc.nextInt();

        System.out.println(solution2(nums, N));
        t--;
        }
        sc.close();

        // int[] nums = { 0, 0, 1, 2, 0, 0, 0, 2, 0, 5, 0 };
        // System.out.println(solution2(nums, nums.length));
    }
}