package CP_31_900;
import java.util.Scanner;

public class B_Comparison_String {
    public static int solution(int N, String s){
        if(N==1) return 2;
        int ans = 0;
        int t = 1;
        for (int i = 1; i < N; i++) {
            if(s.charAt(i) == s.charAt(i-1)){
                t++;
            }else {
                t = 1;
            }
            ans = Math.max(ans, t);
        }
        return ans+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            String s = sc.next();
            System.out.println(solution(N,s));
            t--;
        }
        sc.close();
    }
}