package at_coder.Beginner_Contest_469;
import java.util.Scanner;

/**
 * Cantrip
 */
public class Cantrip {

    public static void solution2(String s) {
        int k = 1;
        while (k <= s.length()) {
            int noOfHits = 0;
            int i = 0;
            int ans = 0;
            for (; i < k; i++) {
                char c = s.charAt(i);
                if (c == 'o')
                    noOfHits++;
                ans++;
            }

            while (noOfHits > 0 && i < s.length()) {
                noOfHits--;
                char c = s.charAt(i);
                if (c == 'o')
                    noOfHits++;
                ans++;
                i++;
            }

            System.out.println(ans);
            k++;
        }
    }

    public static void solution3(String s) {
        int n = s.length();
        int[] noOfHits = new int[n];
        int[] ans = new int[n];

        int hits = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'o')
                hits++;
            noOfHits[i] = hits;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i + noOfHits[i] >= n - 1) {
                ans[i] = n;
                continue;
            }

            int h = noOfHits[i];
            int a = i + 1;

            for (int j = i + 1; j < n; j++) {
                if (h <= 0)
                    break;
                h--;
                if (s.charAt(j) == 'o')
                    h++;
                a++;
            }
            ans[i] = a;
        }

        for (int i : ans) {
            System.out.println(i);
        }

    }

    public static void solution(String s) {
        int n = s.length();

        // Store positions of all 'x'
        int[] xPositions = new int[n];
        int xCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'x') {
                xPositions[xCount++] = i;
            }
        }

        for (int k = 1; k <= n; k++) {
            System.out.println(xCount < k ? n : xPositions[k - 1] + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        solution(s);
        sc.close();
        // solution("oxoxo");
    }
}