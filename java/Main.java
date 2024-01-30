import java.util.HashMap;

/**
 * Test class for experimentation
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.merge('a', 1, Integer::sum);
    }
}
