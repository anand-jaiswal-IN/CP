package leetcode_contests.Biweekly_Contest_176;
import java.util.HashMap;
import java.util.Map;

public class Leetcode2 {
    public static int prefixConnected(String[] words, int k) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == '-')
                continue;
            boolean found = false;
            if (words[i].length() >= k) {
                String strPrefix1 = words[i].substring(0, k);

                for (int j = 0; j < words.length; j++) {
                    if (i == j || words[j].charAt(0) == '-')
                        continue;
                    if (words[j].length() >= k) {
                        String strPrefix2 = words[j].substring(0, k);

                        if (strPrefix1.equals(strPrefix2)) {
                            found = true;
                            words[j] = "-" + words[j];
                        }
                    }
                }
            }
            if (found) {
                ans++;
                words[i] = "-" + words[i];
            }
        }
        return ans;
    }

    public static int prefixConnected2(String[] words, int k) {
        HashMap<String, Integer> m = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= k) {
                m.put(words[i].substring(0, k), m.getOrDefault(words[i].substring(0, k), 0) + 1);
            }
        }
        int ans = 0;
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            if (e.getValue() > 1)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = { "bat", "dog", "dog", "doggy", "bat" };
        int k = 3;
        int r = prefixConnected2(words, k);
        System.out.println(r);
    }
}
