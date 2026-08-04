package START227;
import java.util.Scanner;

public class Erase_and_Maximize {
    static int solution(int N, int S) {
        int N_C = N;
        int[] choosen = new int[N];
        int i = 0;
        while (N_C > 0) {
            int cho = S / N_C;
            choosen[i] = cho;
            S -= cho;
            N_C--;
            i++;
        }

        int ans = 0;
        for (int j = 0; j < choosen.length; j++) {
            if (choosen[j] == 6) {
                ans += 5;
            } else {
                ans += 6;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int S = sc.nextInt();

            System.out.println(solution(N, S));
        }
        sc.close();

        // int N = 3, S = 18;
        // System.out.println(solution(N, S));
    }
}