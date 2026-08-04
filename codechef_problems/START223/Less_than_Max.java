package START223;
import java.util.Scanner;

public class Less_than_Max {
    public static int solution(int[] nums){
        boolean[] check = new boolean[nums.length+1];

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                check[1] = true;
                count++;
            }else{
                if(check[nums[i] - 1]){
                    count++;
                    check[nums[i]] = true;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(solution(nums));
        }
        sc.close();
    }
}