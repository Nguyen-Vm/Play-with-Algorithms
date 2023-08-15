package leetcodeOrOffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 阮威敏
 * @date 2023/8/15
 */
public class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public Integer top() {
        return stack.peek();
    }

    public Integer getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(-3);
        obj.push(0);
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}
