import java.util.Scanner;

public class A_Social_Experiment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            if (n == 2) {
                System.out.println(2);
            } else if (n == 3) {
                System.out.println(3);
            } else
                System.out.println((n % 2 == 0) ? 0 : 1);
        }
        sc.close();
    }
}