import java.util.Scanner;

public class B_ABAB_Construction {

    static boolean solution3(String s) {
        int n = s.length();
        StringBuilder T = new StringBuilder();

        for (int i = 0; i < n / 2; i++) {
            T.append("ab");
        }

        if (n % 2 == 1)
            T.append("a");

        return solution3Helper(s, T.toString());
    }

    static boolean solution3Helper(String s, String T) {
        if (s.isEmpty())
            return true;

        char firstChar = T.charAt(0);
        char lastChar = T.charAt(T.length() - 1);

        if (s.charAt(0) == '?') {
            return solution3Helper(s.substring(1), T.substring(1)) ||
                    solution3Helper(s.substring(0, s.length() - 1), T.substring(0, T.length() - 1));
        }
        if (s.charAt(0) == firstChar) {
            return solution3Helper(s.substring(1), T.substring(1));
        }
        if (s.charAt(0) == lastChar) {
            return solution3Helper(s.substring(0, s.length() - 1), T.substring(0, T.length() - 1));
        } 
        else {
            return false;
        }
    }

    static void solution() {
        String s = "abababababab";
        helper(s, "");
    }

    static void helper(String s, String sb) {
        if (s.isEmpty()) {
            System.out.println(sb);
            return;
        }
        helper(s.substring(1), sb + s.charAt(0));
        helper(s.substring(0, s.length() - 1), sb + s.charAt(s.length() - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            System.out.println(solution3(s) ? "YES" : "NO");
        }
        sc.close();

        // String s = "ababa";
        // System.out.println(solution3(s));
    }
}