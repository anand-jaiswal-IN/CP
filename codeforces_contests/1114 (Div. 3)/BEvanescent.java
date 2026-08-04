import java.util.*;

/**
 * BEvanescent
 */
public class BEvanescent {
    public static String reduce(String s) {
        if (s.isEmpty())
            return "";

        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char lastChar = ans.charAt(ans.length() - 1);
            char ch = s.charAt(i);
            if (lastChar != ch) {
                ans.append(ch);
            }
        }
        return ans.toString();
    }

    public static int solution(String s) {
        int n = s.length();
        if (n == 0)
            return 0;

        // Build run-length blocks: chars[] and lens[]
        List<Character> chars = new ArrayList<>();
        List<Integer> lens = new ArrayList<>();

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i))
                j++;
            chars.add(s.charAt(i));
            lens.add(j - i);
            i = j;
        }

        int m = chars.size();
        int ans = Integer.MAX_VALUE;

        for (int len : lens) {
            if (len >= 2) {
                ans = Math.min(ans, m);
                break;
            }
        }
        
        for (int k = 1; k < m - 1; k++) {
            if (lens.get(k) == 1) {
                int cand;
                if (chars.get(k - 1).equals(chars.get(k + 1))) {
                    cand = m - 2; // neighbors merge
                } else {
                    cand = m - 1; // no merge, just removed
                }
                ans = Math.min(ans, cand);
            }
        }

        return ans;
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

        // String s= "eeeee";
        // int r = solution(s);
        // System.out.println(r);
    }
}