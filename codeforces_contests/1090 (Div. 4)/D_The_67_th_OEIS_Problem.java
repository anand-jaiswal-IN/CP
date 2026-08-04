import java.util.Scanner;

public class D_The_67_th_OEIS_Problem {
    public static void solution2(int n) {
        long prev = 1;
        System.out.print(prev + " ");
        for (int i = 1; i < n; i++) {
            prev = prev * 2;
            System.out.print(prev + " ");
        }
        System.out.println();
    }

    static int[] sieve(int limit) {
        boolean[] isComp = new boolean[limit + 1];
        int[] primes = new int[limit];
        int cnt = 0;
        for (int i = 2; i <= limit; i++) {
            if (!isComp[i]) {
                primes[cnt++] = i;
                for (long j = (long) i * i; j <= limit; j += i)
                    isComp[(int) j] = true;
            }
        }
        return java.util.Arrays.copyOf(primes, cnt);
    }
    public static void solution(int n, int[] primes) {
        StringBuilder sb = new StringBuilder();
        sb.append(primes[0]);
        for (int i = 1; i < n; i++) {
            sb.append(' ').append((long) primes[i - 1] * primes[i]);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] primes = sieve(200000);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            solution(n, primes);
        }
        sc.close();
    }
}