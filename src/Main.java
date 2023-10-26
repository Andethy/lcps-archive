import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

/**
 * Test class for experimentation
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.merge('a', 1, Integer::sum);
    }
}
