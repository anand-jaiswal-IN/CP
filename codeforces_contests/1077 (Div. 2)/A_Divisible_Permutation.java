import java.util.ArrayList;
import java.util.Scanner;

public class A_Divisible_Permutation {

    public static void solution(int n){
        ArrayList<Integer> arr = new ArrayList<>();

        // adding integers
        for (int i = 0; i < n; i++) {
            arr.add(i+1);
        }

        int i = n-1;
        while(i>0){
            if(Math.abs(arr.get(i) - arr.get(i-1)) != (i)){
                int t = arr.get(0);
                arr.remove(0);
                arr.add(i-1,t);
            }else{
                i--;
            }
        }


        // printing
        for (int j = 0; j < arr.size(); j++) {
            System.out.print(arr.get(j) + " ");
        }
        System.out.println();


    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        // while (t-- > 0) {
        //     int n = sc.nextInt();
        //     solution(n);
        // }
        // sc.close();
        solution(50);
    }
}