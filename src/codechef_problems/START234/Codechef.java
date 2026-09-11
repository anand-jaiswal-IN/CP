package START234;
import java.util.Scanner;

public class Codechef {
    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long k1 = (long)(n*(n+1))/2;
            long k2 = (long)(m*(m+1))/2;
            System.out.println(k1-k2);
        }
        sc.close();
	}
}
