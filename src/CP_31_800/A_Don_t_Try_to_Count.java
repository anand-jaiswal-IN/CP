package CP_31_800;
import java.util.Scanner;

public class A_Don_t_Try_to_Count {

    public static int solution(String x, String s){
        int c = 0;
        while(true){
            if(x.contains(s)) return c;
            if(c > 0 && x.length() > Math.pow(s.length(), 2)) return -1;
            x += x;
            c++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            String x = sc.next();
            String s = sc.next();

            System.out.println(solution(x, s));
            t--;
        }
        sc.close();
    }
}