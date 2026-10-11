package leetcode_contests.Weekly_Contest_523;
import java.util.*;

public class Leetcode {
    ArrayList<Integer> fibSum;

    public void sum() {
        fibSum = new ArrayList<>();
        int a = 0;
        int b = 1;

        int c = a + b;
        int sum = a + b + c;
        fibSum.add(sum);

        while (true) {
            sum -= a;
            a = b;
            b = c;
            c = a + b;
            sum += c;
            if (sum > 1000_000_000)
                break;

            fibSum.add(sum);
        }
    }

    public boolean threeFibonacciSum(int n) {
        if (fibSum == null)
            sum();
        return binarySearch(n);
    }

    public boolean binarySearch(int n) {
        int s = 0, e = fibSum.size() - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (fibSum.get(m) == n)
                return true;
            else if (n > fibSum.get(m))
                s = m + 1;
            else
                e = m - 1;
        }
        return false;
    }
}
