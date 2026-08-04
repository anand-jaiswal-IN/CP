import java.io.*;
import java.util.*;

public class C_Replace_and_Sum {

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

    public static long[] getArr(int[] a, int[] b) {
        int n = a.length;

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Math.max(a[i], b[i]);
        }

        long max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < max) {
                arr[i] = max;
            } else {
                max = arr[i];
            }
        }

        for (int i = 1; i < n; i++) {
            arr[i] = arr[i] + arr[i-1];
        }
        return arr;
    }

    public static long solution(long[] arr, int l, int r) {

        if(l == 0){
            return arr[r];
        }else{
            return arr[r] - arr[l-1];
        }

    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();
            int testCases = in.nextInt();
            while (testCases-- > 0) {
                int n = in.nextInt();
                int q = in.nextInt();

                int[] a = new int[n];
                int[] b = new int[n];

                for (int i = 0; i < n; i++) {
                    a[i] = in.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    b[i] = in.nextInt();
                }

                long[] arr = getArr(a, b);

                for (int i = 0; i < q; i++) {
                    int l = in.nextInt();
                    int r = in.nextInt();

                    System.out.print(solution(arr, l - 1, r - 1) + " ");
                }
                System.out.println();

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}