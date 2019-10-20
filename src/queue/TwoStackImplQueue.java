package queue;

import java.util.Stack;

/**
 * @author RWM
 * @date 2019/10/20
 */
public class TwoStackImplQueue {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void push(Integer element) {
        stack1.push(element);
    }

    public static Integer pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else if (stack1.isEmpty()) {
            return null;
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        TwoStackImplQueue queue = new TwoStackImplQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        Integer pop;
        while ((pop = queue.pop()) != null) {
            System.out.println(pop);
            queue.push(pop + 1);
        }
    }
}
