import java.util.Scanner;

public class B_Optimal_Shifts {
    public static int solution(String s, int N) {
        int d = 0;

        while (true) {
            String t = s.charAt(N - 1) + s.substring(0, N-1);

            String temp = "";
            boolean isAll1 = true;
            for (int i = 0; i < N; i++) {
                if (s.charAt(i) == '1')
                    temp += '1';
                else {
                    if (t.charAt(i) == '1')
                        temp += '1';
                    else
                        temp += '0';
                    isAll1 = false;
                }
            }
            s = temp;
            if (isAll1)
                return d;
            d++;

        }
    }

    public static int solution2(String s, int N) {
        int d = 0;

        int i = 0;
        while(i < N){
            if(s.charAt(i) == '1'){
                int j = i+1;
                while(j < N){
                    if(s.charAt(j) == '1'){
                        d = Math.max(d, j-i);
                        break;
                    }
                    j++;
                }
            }
            i++;
        }

        int l = 0;
        int r = N-1;

        int d2 = 0;
        while(l < N){
            if(s.charAt(l) == '1') break;
            d2++;
            l++;
        }
        while(r >= 0){
            if(s.charAt(r) == '1') break;
            d2++;
            r--;
        }

        return Math.max(d2, d-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            String s = sc.next();
            System.out.println(solution2(s, N));
            t--;
        }
        sc.close();
    }
}