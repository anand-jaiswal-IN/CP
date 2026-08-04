package START222;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Candy_Types {
    public static int solution(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                m.put(nums[i], m.get(nums[i]) + 1);
            } else {
                m.put(nums[i], 1);
            }
        }

        int freqValue = 0;
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            freqValue = Math.max(freqValue, e.getValue());
        }

        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if(e.getValue() == freqValue){
                ans = Math.min(ans, e.getKey());
            }
        }

        return ans;

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