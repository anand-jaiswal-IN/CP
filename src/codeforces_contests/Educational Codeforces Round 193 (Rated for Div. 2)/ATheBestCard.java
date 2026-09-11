import java.util.*;

public class ATheBestCard {
    public boolean[] primes;

    public static boolean[] sieveOfEraths() {
        int last = 3 * 1000000 + 1;
        boolean[] primes = new boolean[last];
        Arrays.fill(primes, true);

        for (int i = 2; i * i < last; i++) {
            if (primes[i]) {
                for (int p = i * i; p < last; p += i) {
                    primes[p] = false;
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        boolean[] primes = sieveOfEraths();

        while (t-- > 0) {
            int n = sc.nextInt();
            if (primes[n + 1])
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}