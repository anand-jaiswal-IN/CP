import java.util.Scanner;

public class D_Shortest_Statement_Ever {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();

            System.out.println(x + " " + (y ^ (x & y)));
        }
        sc.close();
    }
}