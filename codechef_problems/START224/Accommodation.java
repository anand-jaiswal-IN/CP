package START224;
import java.util.Scanner;

public class Accommodation {
    public static int solution(int boys, int girls, int x, int y, int n) {
        if (x + y > n)
            return -1;

        if (x + y == n) {
            if ((boys / x) == (girls / y))
                return boys / x;
            else
                return -1;
        }

        long rooms1 = (boys + girls + n - 1)/n;
        long rooms2 = (boys + x - 1)/x;
        long rooms3 = (girls + y - 1)/y;

        return (int)Math.min(rooms1, Math.min(rooms2, rooms3));

    }

    public static long solution2(long B, long G, long X, long Y, long N) {
        if (X + Y > N) {
            return -1;
        }
        
        long minRooms = (B + G + N - 1) / N;
        
        long maxKBoys = B / X;
        long maxKGirls = G / Y;
        long maxK = Math.min(maxKBoys, maxKGirls);
        
        if (minRooms <= maxK) {
            return minRooms;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long boys = sc.nextLong();
            long girls = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();
            long n = sc.nextLong();
            System.out.println(solution2(boys, girls, x, y, n));
        }
        sc.close();
    }
}