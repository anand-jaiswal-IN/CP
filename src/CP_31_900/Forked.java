// https://codeforces.com/problemset/problem/1904/A
package CP_31_900;

import java.util.*;

public class Forked {
    public static int forked(int m1, int m2, int[] kp, int[] qp) {

        ArrayList<int[]> moves = new ArrayList<>();

        if (m1 == m2) {

            moves.add(new int[] { kp[0] + m1, kp[1] + m2 });
            moves.add(new int[] { kp[0] - m1, kp[1] + m2 });
            moves.add(new int[] { kp[0] + m1, kp[1] - m2 });
            moves.add(new int[] { kp[0] - m1, kp[1] - m2 });

            moves.add(new int[] { qp[0] + m1, qp[1] + m2 });
            moves.add(new int[] { qp[0] - m1, qp[1] + m2 });
            moves.add(new int[] { qp[0] + m1, qp[1] - m2 });
            moves.add(new int[] { qp[0] - m1, qp[1] - m2 });

            moves.sort((int[] a, int[] b) -> {
                int s = a[0] - b[0];
                if (s == 0)
                    return a[1] - b[1];
                return s;
            });

            int count = 0;
            for (int i = 1; i < moves.size(); i++) {
                if (Arrays.equals(moves.get(i - 1), moves.get(i)))
                    count++;
            }
            return count;
        }

        else {

            moves.add(new int[] { kp[0] + m1, kp[1] + m2 });
            moves.add(new int[] { kp[0] - m1, kp[1] + m2 });
            moves.add(new int[] { kp[0] + m1, kp[1] - m2 });
            moves.add(new int[] { kp[0] - m1, kp[1] - m2 });

            moves.add(new int[] { kp[0] + m2, kp[1] + m1 });
            moves.add(new int[] { kp[0] - m2, kp[1] + m1 });
            moves.add(new int[] { kp[0] + m2, kp[1] - m1 });
            moves.add(new int[] { kp[0] - m2, kp[1] - m1 });

            moves.add(new int[] { qp[0] + m1, qp[1] + m2 });
            moves.add(new int[] { qp[0] - m1, qp[1] + m2 });
            moves.add(new int[] { qp[0] + m1, qp[1] - m2 });
            moves.add(new int[] { qp[0] - m1, qp[1] - m2 });

            moves.add(new int[] { qp[0] + m2, qp[1] + m1 });
            moves.add(new int[] { qp[0] - m2, qp[1] + m1 });
            moves.add(new int[] { qp[0] + m2, qp[1] - m1 });
            moves.add(new int[] { qp[0] - m2, qp[1] - m1 });

            moves.sort((int[] a, int[] b) -> {
                int s = a[0] - b[0];
                if (s == 0)
                    return a[1] - b[1];
                return s;
            });

            int count = 0;
            for (int i = 1; i < moves.size(); i++) {
                if (Arrays.equals(moves.get(i - 1), moves.get(i)))
                    count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();

            int[] kp = new int[2];
            kp[0] = sc.nextInt();
            kp[1] = sc.nextInt();

            int[] qp = new int[2];
            qp[0] = sc.nextInt();
            qp[1] = sc.nextInt();

            System.out.println(forked(m1, m2, kp, qp));

            t--;
        }
        sc.close();
    }
}
