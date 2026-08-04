import java.io.*;
import java.util.*;

public class C1MarenolEasyVersion {

    public static boolean solution(String a, String b) {
        int n = a.length();
        int evenA = 0, oddA = 0;
        int evenB = 0, oddB = 0;

        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();

        for (int i = 0; i < n; i++) {
            // 1-indexed parity: index 0, 2, 4 are 1st, 3rd, 5th positions (odd)
            boolean isOddPos = (i % 2 == 0);

            if (charA[i] == '1') {
                if (isOddPos) oddA++;
                else evenA++;
            }
            if (charB[i] == '1') {
                if (isOddPos) oddB++;
                else evenB++;
            }
        }

        return (oddA == oddB) && (evenA == evenB);
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        if (!sc.hasNext()) return;

        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            String aS = sc.next();
            String bS = sc.next();

            if (solution(aS, bS)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }

    // Fast I/O class to safely consume tokens and handle empty/blank lines
    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) return null;
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public boolean hasNext() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) return false;
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    return false;
                }
            }
            return true;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}