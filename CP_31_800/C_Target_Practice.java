package CP_31_800;

import java.util.*;

public class C_Target_Practice {
    public static boolean search(int[] arr, int target) {
        // using binary search
        int s = 0, e = arr.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] == target)
                return true;
            else if (target > arr[m])
                s = m + 1;
            else
                e = m - 1;
        }
        return false;

    }

    public static int solution(char[][] board) {

        int count = 0;

        int[] a1 = { 4, 5 };
        int[] a2 = { 3, 4, 5, 6 };
        int[] a3 = { 2, 3, 4, 5, 6, 7 };
        int[] a4 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] a5 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 'X') {
                    if (search(a1, i) && search(a1, j))
                        count += 5;
                    else if (search(a2, i) && search(a2, j))
                        count += 4;
                    else if (search(a3, i) && search(a3, j))
                        count += 3;
                    else if (search(a4, i) && search(a4, j))
                        count += 2;
                    else if (search(a5, i) && search(a5, j))
                        count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            char[][] grid = new char[10][10];

            for (int i = 0; i < 10; i++) {
                    String row = sc.nextLine();
                    grid[i] = row.toCharArray();
            }

            System.out.println(solution(grid));
            t--;
        }
        sc.close();

        // String s = "XXXXXXXXXX\r\n" + //
        // "XXXXXXXXXX\r\n" + //
        // "XXXXXXXXXX\r\n" + //
        // "XXXXXXXXXX\r\n" + //
        // "XXXXXXXXXX\r\n" + //
        // "XXXXXXXXXX\r\n" + //
        // "XXXXXXXXXX\r\n" + //
        // "XXXXXXXXXX\r\n" + //
        // "XXXXXXXXXX\r\n" + //
        // "XXXXXXXXXX";
        // System.out.println(solution(s));
    }
}