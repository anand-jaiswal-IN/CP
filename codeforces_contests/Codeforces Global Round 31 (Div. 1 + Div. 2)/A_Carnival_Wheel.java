import java.util.Scanner;

public class A_Carnival_Wheel {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int l = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            int i = a;
            int m = i;

            int rotation = 0;
            while (rotation <= l) {
                i = (i + b) % l;
                m = Math.max(m, i);
                rotation++;
            }

            System.out.println(m);

            t--;
        }
        sc.close();
    }
}