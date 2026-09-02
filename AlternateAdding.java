import java.io.*;
import java.util.*;

public class AlternateAdding {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        StringBuilder sb = new StringBuilder();

        int T = nextInt(in);
        while (T-- > 0) {
            int N = nextInt(in);
            long prevC = 0;
            long ans = 0;
            for (int i = 1; i <= N; i++) {
                long a = nextInt(in);
                long s = (i % 2 == 1) ? 1 : -1;
                long c = a * s;
                long d = c - prevC;
                if (d > 0)
                    ans += d;
                prevC = c;
            }
            // closing boundary: d[N+1] = -C[N]
            long dLast = -prevC;
            if (dLast > 0)
                ans += dLast;

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }

    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0;
        int b = in.read();
        while (b < '0' || b > '9') {
            if (b == '-')
                break;
            b = in.read();
        }
        boolean neg = false;
        if (b == '-') {
            neg = true;
            b = in.read();
        }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return neg ? -ret : ret;
    }

}