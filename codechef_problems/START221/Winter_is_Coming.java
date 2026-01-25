package START221;
import java.util.Scanner;

public class Winter_is_Coming {
    public static int solution(int A, int B, int[] temperatures){
        int ans = 0;

        boolean weared = false;

        for (int i = 0; i < temperatures.length; i++) {
            if(A <= temperatures[i] && temperatures[i] <= B) continue;

            if(temperatures[i] < A && weared == false){
                ans++;
                weared = true;
            }else if (temperatures[i] > B){
                weared = false;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();

            int[] temperatures = new int[N];

            for (int i = 0; i < N; i++) {
                temperatures[i] = sc.nextInt();
            }

            System.out.println(solution(A, B, temperatures));
        }
        sc.close();
    }
}