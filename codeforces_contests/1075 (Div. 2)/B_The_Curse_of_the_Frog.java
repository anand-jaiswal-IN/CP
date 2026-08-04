import java.util.Scanner;

public class B_The_Curse_of_the_Frog {

    public static int solutionHelper(int a, int b, int c, long x) {
        int step = 1;
        long pointReached = 0;
        int ans = 0;

        while (pointReached < x) {
            if ((pointReached == 0 && step > 1) || (pointReached <= -5 * c)) {
                return -1;
            }

            if (step % b == 0) {
                pointReached = (pointReached - c) + a;
                ans++;
                step++;
            } else {
                pointReached += a * (b - 1);
                step += (b - 1);
            }
            System.out.println(pointReached);
        }

        return ans;
    }

    public static long solutionHelper2(long a, long b, long c, long x) {
        long pointReached = 0;
        pointReached += (a * b) - c;

        if (pointReached <= 0)
            return -1;

        double rawSteps = (double) (x * b) / (a * b - c);
        long steps = (long) Math.floor(rawSteps); // 3.7 → 4, 8.4 → 9

        // let steps = steps - 1;

        long steps2 = steps - 1;
        long steps3 = steps + 1;

        long calc1 = (a*steps2 - c*(steps2/b));
        long calc2 = (a*steps - c*(steps/b));
        // long calc3 = (a*steps3 - c*(steps3/b));

        

        if(calc1 >= x) return steps2/b;
        else if (calc2 >= x) return steps/b;
        else return steps3 / b;
    }

    public static long solutionHelper3(long a, long b, long c, long x) {
        long pointReached = 0;
        pointReached += (a * b) - c;

        if (pointReached <= 0)
            return -1;

        // int steps = 1;
        // to find steps we will use binary search into it

        long d = 1, e = x;
        long steps = 0;
        while (d < e) {
            steps = d + (e - d) / 2;

            if (a * steps - c * (steps / b) >= x) {
                e = steps - 1;
            } else {
                d = steps + 1;
            }
        }
        return steps / b;
    }

    public static long solution(long[][] arr, long n, long x) {
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            long a = arr[i][0];
            long b = arr[i][1];
            long c = arr[i][2];

            long temp_sol = solutionHelper2(a, b, c, x);
            if (temp_sol == -1)
                temp_sol = Long.MAX_VALUE;
            ans = Math.min(ans, temp_sol);

        }
        if (ans == Long.MAX_VALUE)
            return -1;
        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();

            long[][] arr = new long[(int) n][3];

            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextLong();
                arr[i][1] = sc.nextLong();
                arr[i][2] = sc.nextLong();
            }

            System.out.println(solution(arr, n, x));

        }
        sc.close();

        // long[][] arr = {
        // {1000000, 4 ,654321}
        // };
        // int n = 1;
        // long x = 1000000000000000000L;
        // System.out.println(solution(arr, n, x));

        // long[][] arr = {
        // { 4, 2, 5 },
        // };
        // int n = 1;
        // long x = 7;
        // System.out.println(solution(arr, n, x));
    }
}