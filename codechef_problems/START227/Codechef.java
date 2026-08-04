package START227;
import java.util.Scanner;

public class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();

            int amount = 0;

            if(A >= X){
                amount += ((A/X) * Y);
                amount += (A%X);
                amount += B;
            }else{
                amount += (A + B);
            }
            System.out.println(amount);
        }
        sc.close();
    }
}
