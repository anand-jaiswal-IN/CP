import java.util.ArrayList;
import java.util.Scanner;

public class E_The_67_th_XOR_Problem {
    static long foundAns;
    public static long solution(ArrayList<Long> nums){
        foundAns = 0;
        if(nums.size() == 1) return nums.get(0);

        for (int i = 0; i < nums.size(); i++) {
            long toBeXor = nums.get(i);
            for (int j = 0; j < nums.size(); j++) {
                ArrayList<Long> newNums = new ArrayList<>();
                if(j == i) continue;
                newNums.add(nums.get(j) ^ toBeXor);
                foundAns = Math.max(foundAns, solution(newNums));
            }
        }
        return foundAns;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Long> nums = new ArrayList<>();
            
            for (int i = 0; i < n; i++) nums.add(sc.nextLong());
            
            System.out.println(solution(nums));
        }
        sc.close();
    }
}