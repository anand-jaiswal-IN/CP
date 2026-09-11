public class B_Ashmal {
    static String solution(String[] strs) {
        String s = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            int k = 0;
            while (true) {
                if (j < s.length() && k < strs[i].length() && 
                    s.charAt(j++) != strs[i].charAt(k++)) {
                    if (s.charAt(j) < strs[i].charAt(i)) {
                        s = strs[i] + s;
                    } else {
                        s = s + strs[i];
                    }
                    break;
                }
                j++;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        // while (t > 0) {
        //     int N = sc.nextInt();
        //     String[] strs = new String[N];
        //     for (int i = 0; i < N; i++) {
        //         strs[i] = sc.next();
        //     }

        //     System.out.println(solution(strs));
        //     t--;
        // }
        // sc.close();

        String[] strs = {"amir", "rima", "amin", "nima"};
        System.out.println(solution(strs));
    }
}