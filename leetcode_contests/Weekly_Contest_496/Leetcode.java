package leetcode_contests.Weekly_Contest_496;
import java.util.HashMap;
import java.util.HashSet;

public class Leetcode {

    private static char getMirror(char ch) {
        if (Character.isDigit(ch)) {
            return (char) ('0' + '9' - ch);
        } else {
            return (char) ('a' + 'z' - ch);
        }
    }

    public static int mirrorFrequency(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int ans = 0;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch))
                continue;

            char mi = getMirror(ch);

            int freqOfch = map.get(ch);
            int freqOfmi = map.containsKey(mi) ? map.get(mi) : 0;

            ans += Math.abs(freqOfch - freqOfmi);

            set.add(s.charAt(i));
            set.add(mi);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ab1z9";
        System.out.println(mirrorFrequency(s));
        System.out.println(getMirror('0'));
    }
}