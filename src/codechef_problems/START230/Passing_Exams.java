package START230;
import java.util.Scanner;

public class Passing_Exams {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(a >= 50 && b >= 50) System.out.println("Yes");
            else if(b >= 50 && c >= 50) System.out.println("Yes");
            else if(a >= 50 && c >= 50) System.out.println("Yes");
            else System.out.println("No");
        }
        sc.close();
    }
}