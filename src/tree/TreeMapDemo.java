package tree;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author RWM
 * @date 2019/10/20
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(1, 1);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
        map.put(8, 8);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        Map.Entry<Integer, Integer> integerIntegerEntry = map.pollFirstEntry();
        System.out.printf("");
    }
}
