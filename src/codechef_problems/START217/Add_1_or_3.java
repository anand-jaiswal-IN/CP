package START217;
import java.util.Scanner;

public class Add_1_or_3 {
    public static boolean solution(int N, int M) {
        if (N > M)
            return false;

        if((M-N) % 2 != 0) return false;
        if((M-N) / 2 > N) return false;
        
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println(solution(N, M) ? "YES" : "NO");
            t--;
        }
        sc.close();
    }
}