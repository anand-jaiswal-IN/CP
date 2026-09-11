package leetcode_contests.Weekly_Contest_496;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Collections;

public class Leetcode2 {
    public static List<Integer> findGoodIntegers(int n) {
        int c = (int) Math.pow(n, ((double) 1 / 3));
        int[] cubes = new int[c + 1];

        for (int i = 0; i < c + 1; i++) {
            cubes[i] = (int) Math.pow(i, 3);
        }

        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for (int i = 0; i <= c; i++) {
            for (int j = i+1; j <= c; j++) {
                int sum = cubes[i] + cubes[j];
                if (sum > n)
                    break;

                if (set.contains(sum)) {
                    if (resultSet.add(sum))
                        ans.add(sum);

                }
                set.add(sum);
            }
        }

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int n = 4104;
        System.out.println(findGoodIntegers(n));
    }
}
