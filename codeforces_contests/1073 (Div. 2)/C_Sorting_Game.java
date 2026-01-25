import java.util.Scanner;

public class C_Sorting_Game {

    public static int findFirstOne(StringBuilder s){
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') return i;
        }
        return -1;
    }

    public static int findLastZero(StringBuilder s, int start_idx){
        // boolean oneFound = false;
        boolean zeroComes = false;
        for (int i = start_idx+1; i < s.length(); i++) {
            if(zeroComes==false && s.charAt(i) == '0'){
                zeroComes = true;
            }
            if(zeroComes && s.charAt(i) == '1'){
                return i-1;
            }
        }
        return s.length()-1;
    }
    
    public static void rearrange(StringBuilder sb, int start_idx, int last_idx){
        while(start_idx < last_idx){
            char temp = sb.charAt(start_idx);
            sb.setCharAt(start_idx, sb.charAt(last_idx));
            sb.setCharAt(last_idx, temp);
            start_idx++;
            last_idx--;
        }
    }

    public static boolean isStringCorrect(StringBuilder sb){
        boolean seenOne = false;

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);

            if (c == '1') {
                seenOne = true;
            } else if (c == '0' && seenOne) {
                return false;
            }
        }

        return true;
    }

    public static void solution(String s){
        int zeroes_count = 0, ones_count = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') zeroes_count++;
            else ones_count++;
        }
        if(zeroes_count == 0 || ones_count == 0) {
            System.out.println("Bob");
            return;
        }


        StringBuilder sb = new StringBuilder(s);

        String player = "Alice";

        while (true) {
            int start_idx = findFirstOne(sb);
            int last_idx = findLastZero(sb, start_idx);

            rearrange(sb, start_idx, last_idx);

            if(isStringCorrect(sb)){
                System.out.println(player);
                if(player == "Bob"){
                    return;
                }else{
                    System.out.println((last_idx-start_idx) + 1);
                    for(int i = start_idx; i <= last_idx; i++){
                        System.out.print(i+1 + " ");
                    }
                    System.out.println();
                    return;
                }
            }
            player = player == "Alice" ? "Bob" : "Alice";
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            String s = sc.next();

            solution(s);
        }
        sc.close();

        // solution("1010");
        // solution("1011");
        // solution("1101");
        // solution("1100101010");
    }
}