package START221;
import java.util.Scanner;

public class Rectangle_Coloring {
    public static int solution(int L, int W, int R, int G, int B){
        
        int max = Math.max(Math.max(R, G), B);

        int cost = 0;

        if(max >= L+W){
            if(max >= L + W + Math.min(L, W)){
                cost = cost+3;
            }else {
                cost = cost + 2;
            }
        }


        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int L = sc.nextInt();
            int W = sc.nextInt();
            int R = sc.nextInt();
            int G = sc.nextInt();
            int B = sc.nextInt();

            System.out.println(solution(L, W, R, G, B));
        }
        sc.close();
    }
}