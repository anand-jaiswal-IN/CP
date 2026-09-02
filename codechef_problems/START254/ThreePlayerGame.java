package START254;
import java.io.*;
import java.util.*;

public class ThreePlayerGame {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        StringBuilder output = new StringBuilder();

        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            output.append(solve(n)).append("\n");
        }
        System.out.print(output);
    }

    private static long solve(long n) {
        if (n == 1) {
            return 1;
        }
        return 3 * (n / 2) + 1;
    }

    private static class FastScanner {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer;

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = reader.readLine();
                if (line == null) return null;
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}