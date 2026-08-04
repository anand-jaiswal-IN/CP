package at_coder.Beginner_Contest_455;
import java.util.*;

public class A455 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a != b && b == c) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        sc.close();
    }
}