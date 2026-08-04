import java.util.ArrayList;
import java.util.Scanner;

public class C_Sorting_Game2 {
    public static boolean isStringCorrect(StringBuilder sb) {
        boolean seenOne = false;

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);

            if (c == '1') {
                seenOne = true;
            } else if (c == '0' && seenOne) {
                return false;
            }
        }
        return true;
    }

    public static void solution(StringBuilder s, int len) {
        if (isStringCorrect(s)) {
            System.out.println("Bob");
            return;
        }

        int count0 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                count0++;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < count0; i++) {
            if (s.charAt(i) == '1')
                arr.add(i + 1);
        }

        for (int i = count0; i < len; i++) {
            if (s.charAt(i) == '0')
                arr.add(i + 1);
        }

        System.out.println("Alice");
        System.out.println(arr.size());
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        return;

    }

    public static void solution2(StringBuilder s, int len) {
        if (isStringCorrect(s)) {
            System.out.println("Bob");
            return;
        }

        ArrayList<Integer> arr = new ArrayList<>();

        int l = 0, r = len - 1;

        while (l < r) {
            if (s.charAt(l) == '1') {
                arr.add(l + 1);

                while (l < r) {
                    if (s.charAt(r) == '0') {
                        arr.add(r + 1);
                        r--;
                        break;
                    }
                    r--;
                }
            }
            l++;
        }

        // sort in not decreasing order
        arr.sort((a, b) -> a - b);

        System.out.println("Alice");
        System.out.println(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        return;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int len = sc.nextInt();
            String s = sc.next();

            solution2(new StringBuilder(s), len);
        }
        sc.close();

        // String s = "10011100100011";
        // solution(new StringBuilder(s), s.length());
        // solution2(new StringBuilder(s), s.length());
    }
}