package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RWM
 * @date 2019/10/20
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        Comparator<Integer> comparator = (o1, o2) -> o2 - o1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        for (int i = 1; i < 15; i++) {
            queue.offer(i);
        }
        Integer poll;
        while ((poll = queue.poll()) != null) {
            System.out.println(poll);
        }
    }
}
