package at_coder.Beginner_Contest_455;
import java.util.*;

public class CVanish {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        HashMap<Integer, Long> m = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            m.put(input, m.getOrDefault(input, 0L) + input);
            sum += input;
        }
        Queue<Long> q = new PriorityQueue<>(Collections.reverseOrder());

        for(Long l : m.values()) q.offer(l);
        
        for (int i = 0; i < k; i++) {
            if(sum == 0) break;
            sum -= q.poll();
        }
        
        System.out.println(sum);

        sc.close();
    }
}