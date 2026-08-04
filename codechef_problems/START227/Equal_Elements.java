package START227;
import java.util.HashMap;
import java.util.Scanner;

public class Equal_Elements {

    static int solution2(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int ans = 0;
        for (int x : nums) {
            m.put(x, m.getOrDefault(x, 0) + 1);
            if (m.get(x) % 2 == 0)
                ans += 2;
        }
        return ans;
    }

    static int solution(int[] a) {
        int n = a.length;
        int[] mark = new int[n + 1];
        int maxLen = 0;
        int phase = 1;
        
        for (int val : a) {
            if (mark[val] == phase) {
                maxLen += 2;
                phase++;
            } else {
                mark[val] = phase;
            }
        }
        
        return maxLen;
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

            System.out.println(solution(nums));
        }
        sc.close();
    }
}