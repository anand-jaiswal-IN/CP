package START224;
import java.util.*;

public class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            Queue<Integer> q = new LinkedList<>();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int r = sc.nextInt();
                if(r == 0){
                    ans = Math.max(ans, q.size());
                    q.clear();
                }
                else q.offer(r);
            }
            System.out.println(ans);
            ans = Math.max(ans, q.size());
        }
        sc.close();
    }
}
