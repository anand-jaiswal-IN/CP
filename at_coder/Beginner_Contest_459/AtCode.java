package at_coder.Beginner_Contest_459;
import java.util.Scanner;

public class AtCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt()-1;
        String s = "HelloWorld";
        System.out.println(s.substring(0, x) + s.substring(x+1));

        sc.close();
    }
}
