package START222;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Sell_Upto_2 {
    public static int solution(int[] nums) {
        int noOfWatches = 0;
        int cost = 0;

        for (int i = 0; i < nums.length; i++) {
            noOfWatches++;

            if (i == nums.length - 1) {
                cost += noOfWatches * nums[i];
                break;
            }
            if (nums[i] < nums[i + 1]) {
                if (noOfWatches >= 2) {
                    cost += nums[i];
                    noOfWatches--;
                    continue;
                }
            }

            else if (noOfWatches >= 2) {
                cost += 2 * nums[i];
                noOfWatches = 0;
            }

        }
        return cost;
    }

    public static long solution2(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {

            p.add(nums[i]);
            p.add(nums[i]);

            while (p.size() > i + 1) {
                p.poll();
            }
        }

        long profit = 0;
        while (!p.isEmpty()) {
            profit += p.poll();
        }
        return profit;
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

            System.out.println(solution2(nums));
        }
        sc.close();
    }
}