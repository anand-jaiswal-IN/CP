package START221;
import java.util.Scanner;

public class Odd_Operations {

    public static boolean hasOddDigit(int N){
        while(N>0){
            int rem = N%10;
            N /= 10;
            if(rem % 2 == 1) return true;
        }
        return false;
    }

    public static int greatestDigit(int N){
        int greaterDigit = Integer.MIN_VALUE;
        while(N>0){
            int rem = N%10;
            N /= 10;
            greaterDigit = Math.max(rem, greaterDigit);
        }
        return greaterDigit;
    }
    public static int noOfDigits(int N){
        int ans = 0;

        while(N>0){
            N /= 10;
            ans++;
        }
        return ans;
    }

    public static int solution(int N){
        if(N % 2 == 1) return 0;
        if(hasOddDigit(N)) return 1;
        if(noOfDigits(N) == 1) return -1;

        int cnt = 0;

        while(N>0){
            N -= greatestDigit(N);
            cnt++;
            if(N%2==1) return cnt;
            if(hasOddDigit(N)) return cnt+1;
        }
        return cnt;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            System.out.println(solution(N));
        }
        sc.close();
    }
}