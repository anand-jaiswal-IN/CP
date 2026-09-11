package START231;
import java.util.Scanner;

public class Imperfect_Numbers {
    public static int solution(int n){
        if(n%2==0 && n%5==0) return 2;
        else if(n%5==0) return 0;
        else if(n%2==0) return 0;
        else return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(solution(n));
        }
        sc.close();
    }
}