import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_Reverse_a_Permutation {

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

    public static void solution(int[] nums){
        if(nums.length == 2) {
            if(nums[0] < nums[1]){
                System.out.print(nums[1] + " " + nums[0]);
                System.out.println();
                return;
            }
            else{
                System.out.print(nums[0] + " " + nums[1]);
                System.out.println();
                return;
            }
        }else if(nums.length < 2){
            for (int i = 0; i < nums.length; i++) {
                System.err.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }

        boolean isIncreasing = false;

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] < nums[i+1]) {
                if(i == 0){
                    isIncreasing = true;
                }else{

                    int e = i+1, s = 0;

                    for (int j = 0; j <= i; j++) {
                        if(nums[e] > nums[j]){
                            s = j;
                            break;
                        }
                    }

                    for (int j = 0; j < s; j++) {
                        System.out.print(nums[j] + " ");
                    }
                    for (int j = e; j >= s; j--) {
                        System.out.print(nums[j] + " ");
                    }
                    for (int j = e+1; j < nums.length; j++) {
                        System.out.print(nums[j] + " ");
                    }
                    System.out.println();
                    return;
                }
            }
            if(nums[i] > nums[i+1] && isIncreasing){
                // printing
                for(int j = i; j >= 0; j--){
                    System.out.print(nums[j] + " ");
                }
                for (int j = i+1; j < nums.length; j++) {
                    System.out.print(nums[j] + " ");
                }
                System.out.println();
                return;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        
    }

    public static void main(String[] args) {
        // try {
        //     FastReader in = new FastReader();
        //     FastWriter out = new FastWriter();
        //     int testCases = in.nextInt();
        //     while (testCases-- > 0) {
        //         int n = in.nextInt();
        //         int[] nums = new int[n];

        //         for (int i = 0; i < n; i++) {
        //             nums[i] = in.nextInt();
        //         }
        //         solution(nums);
                
        //     }
        //     out.close();
        // } catch (Exception e) {
        //     return;
        // }
    }
}