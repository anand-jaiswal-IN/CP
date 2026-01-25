import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        // List<String[]> strs = new ArrayList<>();

        // String[] t1 = {"abc", "def", "egh"};
        // strs.add(t1);

        // String[] t2 = {"abc", "def", "egh"};



        List<List<String>> strs = new ArrayList<>();

        List<String> t1 = new ArrayList<>(Arrays.asList("abc", "def", "egh"));
        strs.add(t1);

        List<String> t2 = new ArrayList<>(Arrays.asList("abc", "def", "egh"));

        System.out.println(strs.contains(t2));
        System.out.println();

    }
}
