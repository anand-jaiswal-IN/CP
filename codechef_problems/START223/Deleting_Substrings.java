import java.util.Scanner;

public class Deleting_Substrings {

    public static int solution(String S, String T){
        if(S.equals(T)) return 0;
        if(T.length() > S.length()) return -1;

        if(S.startsWith(T) || S.endsWith(T)) return 1;

        int ans = 0;

        if(T.charAt(0) != S.charAt(0)) ans++;
        if(T.charAt(T.length()-1) != S.charAt(S.length()-1)) ans++;


        int startIdx = S.indexOf(T.charAt(0));

        for (int i = startIdx; i < S.length(); i++) {
            
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String S = sc.next();
            String T = sc.next();

            System.out.println(solution(S, T));
        }
        sc.close();
    }
}