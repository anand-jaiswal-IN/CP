package START234;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Non_Negative_Sum {
    public static int solution(int[] nums) {
        int sum = 0;
        int ans = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            sum += nums[i];
            ans++;
            if (sum < 0) {
                sum -= pq.poll();
                ans--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();
            System.out.println(solution(nums));
        }
        sc.close();
    }
}