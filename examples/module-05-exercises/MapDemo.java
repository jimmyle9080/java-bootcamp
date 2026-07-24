import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {
        // declare Map<String, Integer> copies as new HashMap<>()
        Map<String, Integer> copies = new HashMap<>();

        // put three ISBN → copy-count mappings
        copies.put("ISBN-JAVA", 3);
        copies.put("ISBN-CLEAN", 2);
        copies.put("ISBN-TEST", 4);

        System.out.println("Java copies: " + copies.get("ISBN-JAVA"));

        // update "ISBN-JAVA" to 5 (same key replaces old value)
        copies.put("ISBN-JAVA", 5);

        // remove "ISBN-CLEAN"
        copies.remove("ISBN-CLEAN");

        System.out.println("Updated Java copies: " + copies.get("ISBN-JAVA"));
        System.out.println("Missing ISBN: " + copies.getOrDefault("ISBN-MISSING", 0));

        // iterate entrySet — print each key -> value on its own line
        for (Map.Entry<String, Integer> entry : copies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // print deterministic key-sorted snapshot with new TreeMap<>(copies)
        System.out.println("Sorted snapshot: " + new TreeMap<>(copies));
    }
}