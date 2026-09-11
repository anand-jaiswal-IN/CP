import java.util.*;
import java.io.*;

public class C_Odd_Process {

    static void solve(FastScanner fs) {
        int n = fs.nextInt();
        if (n == -1) return;

        List<Long> odd = new ArrayList<>();
        List<Long> even = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long val = fs.nextLong();
            if (val % 2 != 0) odd.add(val);
            else even.add(val);
        }

        // sort descending
        odd.sort(Collections.reverseOrder());
        even.sort(Collections.reverseOrder());

        int cnt_o = odd.size();
        int cnt_e = even.size();

        long[] pref = new long[cnt_e + 1];
        for (int i = 0; i < cnt_e; i++) {
            pref[i + 1] = pref[i] + even.get(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int k = 1; k <= n; k++) {

            int need = Math.max(1, k - cnt_e);

            if (need % 2 == 0) need++; // make odd

            if (need > k || need > cnt_o) {
                sb.append("0");
            } else {
                long ans = odd.get(0) + pref[k - need];
                sb.append(ans);
            }

            if (k != n) sb.append(" ");
        }
        sb.append("\n");

        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        while (t-- > 0) {
            solve(fs);
        }
    }

    // Fast scanner for speed (similar to fast I/O in C++)
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() {
            if (ptr >= len) {
                ptr = 0;
                try {
                    len = in.read(buffer);
                } catch (IOException e) {
                    return -1;
                }
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = c - '0';
            while ((c = read()) > ' ') {
                val = val * 10 + (c - '0');
            }
            return val * sign;
        }

        int nextInt() {
            long v = nextLong();
            return (int) v;
        }
    }
}
