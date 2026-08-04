package START230;
import java.util.Scanner;
import java.util.TreeSet;

public class Sum_of_Second_Max {
    public static long solution(int n) {
        long ans = 0;
        for (int i = 1; i < n; i++) {
            ans += (i * i);
        }
        return ans;
    }

    public static long solution2(int[] nums) {
        int n = nums.length;
        int[] a = new int[n + 1];
        int[] pos = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = nums[i - 1];
            pos[a[i]] = i;
        }

        TreeSet<Integer> s = new TreeSet<>();
        s.add(0);
        s.add(n + 1);

        long ans = 0;

        for (int v = n; v >= 1; v--) {
            int p = pos[v];

            int r = s.ceiling(p);
            int l = s.lower(p);
            int ll = s.lower(l);
            int rr = s.higher(r);

            long c1 = 0, c2 = 0;
            if (l != 0)
                c1 = (long) (l - ll) * (r - p);
            if (r != n + 1)
                c2 = (long) (p - l) * (rr - r);

            ans += (c1 + c2) * (long) v;
            s.add(p);
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
            System.out.println(solution2(nums));
        }
        sc.close();
    }
}