package leetcode_contests.Weekely_Contest_512;
import java.util.ArrayList;
import java.util.List;

public class Leetcode {
    public int largestInteger(int n, int s) {
        if (s > 9 * n) {
            return -1;
        }
        if (n == 1) {
            if (s <= 9)
                return s;
            else
                return -1;
        }
        if (s == 0)
            return s;

        StringBuilder ans = new StringBuilder();

        while (n > 0 && s >= 9) {
            ans.append('9');
            s -= 9;
            n--;
        }
        while (n > 0 && s > 0) {
            ans.append((char) ('0' + s));
            s -= s;
            n--;
        }
        while (n > 0) {
            ans.append('0');
            n--;
        }
        return Integer.parseInt(ans.toString());
    }

    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int i = 0, j = 0;
        List<List<Integer>> ans = new ArrayList<>();

        while (i < series1.length && j < series2.length) {
            int[] s1 = series1[i];
            int[] s2 = series2[j];

            if (s1[0] == s2[0]) {
                List<Integer> k = new ArrayList<>();
                k.add(s1[0]);
                k.add(s1[1] + s2[1]);
                ans.add(k);
                i++;
                j++;
            } else if (s1[0] < s2[0]) {
                // s1 ko lenge;
                List<Integer> k = new ArrayList<>();
                k.add(s1[0]);
                k.add(s1[1] + s2[1]);
                ans.add(k);
                i++;
            } else if (s1[0] > s2[0]) {
                // s1 ko lenge;
                List<Integer> k = new ArrayList<>();
                k.add(s2[0]);
                k.add(s1[1] + s2[1]);
                ans.add(k);
                j++;
            }
        }

        while (i < series1.length) {
            int[] s1 = series1[i];

            List<Integer> k = new ArrayList<>();
            k.add(s1[0]);
            k.add(s1[1]);
            ans.add(k);
            i++;
        }
        while (j < series2.length) {
            int[] s2 = series2[j];

            List<Integer> k = new ArrayList<>();
            k.add(s2[0]);
            k.add(s2[1]);
            ans.add(k);
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Leetcode obj = new Leetcode();
        int[][] series1 = new int[][] { { 1, 3 }, { 4, 1 } };
        int[][] series2 = new int[][] { { 2, 2 }, { 5, 2 } };

        System.out.println(obj.aggregateTimeSeries(series1, series2));
    }
}
