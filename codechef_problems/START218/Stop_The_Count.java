package START218;

import java.util.Scanner;

public class Stop_The_Count {
    public static int solution(String strs, int N){
        int ans = 0;
        int noOfOnes = 0;
        for (int i = 0; i < N; i++) {
            if(strs.charAt(i) == '1') {
                noOfOnes++;
            }
            if(noOfOnes > ((i+1)/2)) ans++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            String strs = sc.next();
            
            System.out.println(solution(strs, N));

            t--;
        }
        sc.close();
    }
}