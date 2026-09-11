package START225;
import java.util.*;

public class Near_Yet_Far {

    // static int ans;

    // static int solution(int[] a, int k) {
    // int n = a.length;
    // ans = 0;

    // for (int start = 0; start < Math.min(k, n); start++) {
    // helper(start, -1, a, k, a[start], a[start], n);
    // }

    // return ans;
    // }

    // static void helper(int pos, int last, int[] a, int k, int min, int max, int
    // n) {
    // if (pos >= Math.max(0, n - k)) {
    // ans = Math.max(ans, max - min);
    // }

    // if (pos >= n)
    // return;

    // int nextStart = pos + 2;
    // int nextEnd = Math.min(n - 1, pos + k);

    // for (int next = nextStart; next <= nextEnd; next++) {
    // helper(next, pos, a, k, Math.min(min, a[next]), Math.max(max, a[next]), n);
    // }
    // }

    // public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // int t = sc.nextInt();
    // while (t-- > 0) {
    // int n = sc.nextInt();
    // int k = sc.nextInt();
    // int[] a = new int[n];
    // for (int i = 0; i < n; i++) {
    // a[i] = sc.nextInt();
    // }
    // System.out.println(solution(a, k));
    // }
    // sc.close();
    // }

    static int solution(int[] a, int k) {
        int n = a.length;
        int[][] dpMin = new int[n][n];
        int[][] dpMax = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dpMin[i][j] = -1;
                dpMax[i][j] = -1;
            }
        }

        for (int start = 0; start < Math.min(k, n); start++) {
            dpMin[start][start] = a[start];
            dpMax[start][start] = a[start];
        }

        for (int start = 0; start < Math.min(k, n); start++) {
            for (int last = start; last < n; last++) {
                if (dpMin[start][last] == -1)
                    continue;

                int nextStart = last + 2;
                int nextEnd = Math.min(n - 1, last + k);

                for (int next = nextStart; next <= nextEnd; next++) {
                    int newMin = Math.min(dpMin[start][last], a[next]);
                    int newMax = Math.max(dpMax[start][last], a[next]);

                    if (dpMin[start][next] == -1) {
                        dpMin[start][next] = newMin;
                        dpMax[start][next] = newMax;
                    } else {
                        if (newMax - newMin > dpMax[start][next] - dpMin[start][next]) {
                            dpMin[start][next] = newMin;
                            dpMax[start][next] = newMax;
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int start = 0; start < Math.min(k, n); start++) {
            for (int end = Math.max(0, n - k); end < n; end++) {
                if (dpMin[start][end] != -1) {
                    ans = Math.max(ans, dpMax[start][end] - dpMin[start][end]);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(solution(a, k));
        }
        sc.close();
    }
}