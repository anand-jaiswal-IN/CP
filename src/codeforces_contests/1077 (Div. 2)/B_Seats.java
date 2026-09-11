import java.util.Scanner;

public class B_Seats {

    public static int solution(String s) {
        int n = s.length();
        if (n <= 2)
            return 1;

        int ans = 0;
        StringBuilder sb = new StringBuilder(s);

        if (sb.charAt(0) != '1' && sb.charAt(1) != '1') {
            sb.replace(1, 2, "1");

        }
        if (sb.charAt(n - 1) != '1' && sb.charAt(n - 2) != '1') {
            sb.replace(n - 2, n - 1, "1");
        }

        int idxOfOne = sb.charAt(0) == '1' ? 0 : 1;

        for (int i = idxOfOne + 1; i < n; i++) {
            if (sb.charAt(i) == '1')
                ans++;
            if (sb.charAt(i) == '1') {
                int spaces = (i - idxOfOne) - 1;
                ans += (spaces / 3);
                idxOfOne = i;
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            System.out.println(solution(s));
        }
        sc.close();
    }
}