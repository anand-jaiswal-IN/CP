package START224;
import java.util.*;

public class AabBcCDd {

    public static long solution(String s){
        s = s.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(Map.Entry<Character, Integer> e : map.entrySet()){
            pq.offer(e.getValue());
        }
        if(pq.isEmpty()) return 0;
        if(pq.size() == 1) return (long)pq.poll();
        return (long)(pq.poll() + pq.poll());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            System.out.println(solution(s));
        }
        sc.close();
    }
}