package codeforces_contests.good_bye_2025;

import java.util.*;
import java.io.*;

public class A_Yes_or_Yes {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    static boolean solution(String s) {
        int countOfY = 0;
        for (int i = 0; i < s.length(); i++) {
            if(countOfY >= 2) return false;
            if(s.charAt(i) == 'Y') countOfY++;
        }
        if(countOfY >= 2) return false;
        return true;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();
            int testCases = in.nextInt();
            while (testCases-- > 0) {
                String s = in.next();
                System.out.println(solution(s) ? "YES" : "NO");
                
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}