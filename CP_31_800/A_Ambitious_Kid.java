package CP_31_800;
import java.util.Scanner;

public class A_Ambitious_Kid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            
            int n = Math.abs(sc.nextInt());

            if(n < m) m = n;

        }
        System.out.println(m);
        sc.close();
    }
}