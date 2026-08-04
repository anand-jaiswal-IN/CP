package START249;
import java.util.*;

public class ValleyFlattening {
    public static long solution(int[] nums) {
        int n = nums.length;
        List<Integer> localMinima = new ArrayList<>();

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                localMinima.add(i);
            }
        }

        localMinima.sort((a, b) -> Integer.compare(nums[b], nums[a]));

        for (int idx : localMinima) {
            nums[idx - 1] = nums[idx];
            nums[idx + 1] = nums[idx];
        }

        long minSum = 0;
        for (int val : nums) {
            minSum += val;
        }

        return minSum;
    }

    private static long solution2(int[] a, int n) {
        boolean[] isSource = new boolean[n];
        for (int i = 1; i < n - 1; i++) {
            if (a[i] < Math.min(a[i - 1], a[i + 1])) {
                isSource[i] = true;
            }
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (isSource[i]) {
                sum += a[i]; // sources are never overwritten
                continue;
            }
            int best = a[i];
            if (i > 0 && isSource[i - 1])
                best = Math.min(best, a[i - 1]);
            if (i < n - 1 && isSource[i + 1])
                best = Math.min(best, a[i + 1]);
            sum += best;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(solution(nums));
            // System.out.println(solution2(nums, n));
        }
        sc.close();
    }

}