package leetcode_contests.Biweekly_Contest_188;
public class Leetcode {
    public static long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] bonuses = new long[n];

        for (int i = 0; i < boosts.length; i++) {
            int[] boost = boosts[i];

            for (int j = boost[0]; j <= boost[1]; j++) {
                bonuses[j] += boost[2];
            }
        }

        long ans = 0;
        int i = n - 1;

        while (i >= 0 && monsters[i] - bonuses[i] <= 0) {
            i--;
        }
        if (i < 0)
            return ans;
        ans += monsters[i] - bonuses[i];
        i--;
        while (i >= 0) {
            ans += monsters[i];
            i--;
        }
        return ans;
    }

    public static long minInitialStrength2(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] diff = new long[n + 1];

        for (int[] boost : boosts) {
            int l = boost[0], r = boost[1], val = boost[2];
            diff[l] += val;
            diff[r + 1] -= val;
        }

        long[] bonuses = new long[n];
        long running = 0;
        for (int i = 0; i < n; i++) {
            running += diff[i];
            bonuses[i] = running;
        }

        long ans = 0;
        int i = n - 1;

        while (i >= 0 && monsters[i] - bonuses[i] <= 0) {
            i--;
        }
        if (i < 0)
            return ans;

        ans += monsters[i] - bonuses[i];
        i--;

        while (i >= 0) {
            ans += monsters[i];
            i--;
        }

        return ans;
    }

    public static void main(String[] args) {
        // int[] monsters = {5,10,15};
        // int[][] boosts = {{1,1,10}};

        int[] monsters = { 5, 10, 15 };
        int[][] boosts = { { 1, 2, 10 }, { 1, 2, 5 } };

        long r = minInitialStrength(monsters, boosts);
        System.out.println(r);
    }
}
