package START217;

// package codechef_contests;
import java.util.*;
import java.lang.*;
import java.io.*;

class Playing_with_Toys {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        if (N > M)
            System.out.println(N - M);
        else
            System.out.println(0);
        sc.close();

    }
}
