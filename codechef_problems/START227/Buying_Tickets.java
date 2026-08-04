package START227;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Buying_Tickets {

    static int solution(int[] amounts, int K, String s){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < amounts.length; i++) {
            if(s.charAt(i) == '0') {
                pq.offer(amounts[i]);
            }
        }

        int ans = 0;
        while(K > 0){
            if(pq.isEmpty()) return -1;
            ans += pq.poll();
            K--;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] amounts = new int[N];
            for (int i = 0; i < N; i++) {
                amounts[i] = sc.nextInt();
            }
            String s = sc.next();

            System.out.println(solution(amounts, K, s));
        }
        sc.close();
    }
}