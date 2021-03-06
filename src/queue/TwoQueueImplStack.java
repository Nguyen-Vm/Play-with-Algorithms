package queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author RWM
 * @date 2019/10/20
 */
public class TwoQueueImplStack {
    /**
     * 任何时刻，至少有一个队列为空
     */
    static Queue<Integer> queue1 = new ArrayDeque<>();
    static Queue<Integer> queue2 = new ArrayDeque<>();

    /**
     * 两个队列同时为空，往queuq1 push元素，否则给不为空的队列push元素
     * @param element
     */
    public static void push(Integer element) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(element);
        } else if (!queue1.isEmpty()) {
            queue1.add(element);
        } else {
            queue2.add(element);
        }
    }

    /**
     * 两个队列同时为空，pop为null
     * 不为空的队列除最后一个元素外，全部压进另一个队列，再弹出最后一个元素
     * @return
     */
    public static Integer pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            //throw new RuntimeException("stack empty!");
            return null;
        } else if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        } else {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
    }

    public static void main(String[] args) {
        TwoQueueImplStack stack = new TwoQueueImplStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Integer pop;
        while ((pop = stack.pop()) != null) {
            System.out.println(pop);
        }
    }
}
