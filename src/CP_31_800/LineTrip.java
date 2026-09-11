package CP_31_800;
// https://codeforces.com/problemset/problem/1901/A
import java.util.*;

public class LineTrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0)
        {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] stations = new int[n];
            for (int i = 0; i < stations.length; i++)
                stations[i] = sc.nextInt();

            Arrays.sort(stations);

            int ans = stations[0] - 0;
            for (int i = 1; i < stations.length; i++) {
                ans = Math.max(ans, stations[i]-stations[i-1]);
            }
            ans = Math.max(ans, (x - stations[n-1])*2);
            System.out.println(ans);
            t--;
        }
        sc.close();
    }
}
