package leetcodeOrOffer;

/**
 * @author 阮威敏
 * @date 2023/8/15
 */
public class MyCircularDeque {

    private int front;
    private int rear;
    private int size;
    private Integer[] element;

    public MyCircularDeque(int k) {
        front = 0;
        rear = 0;
        size = 0;
        element = new Integer[k];
    }

    /**
     * 将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
     *
     * @param value
     * @return
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + element.length) % element.length;
        element[front] = value;
        size++;
        return true;
    }

    /**
     * 将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
     *
     * @param value
     * @return
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        element[rear] = value;
        rear = (rear + 1) % element.length;
        size++;
        return true;
    }

    /**
     * 从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
     *
     * @return
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        element[front] = null;
        front = (front + 1) % element.length;
        size--;
        return true;
    }

    /**
     * 从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
     *
     * @return
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + element.length) % element.length;
        element[rear] = null;
        size--;
        return true;
    }

    /**
     * 从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
     *
     * @return
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return element[front];
    }

    /**
     * 获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
     *
     * @return
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return element[(rear - 1 + element.length) % element.length];
    }

    /**
     * 若双端队列为空，则返回 true ，否则返回 false  。
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 若双端队列满了，则返回 true ，否则返回 false 。
     *
     * @return
     */
    public boolean isFull() {
        return size >= element.length;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(5);
        boolean param_2 = circularDeque.insertFront(7);
        boolean param_3 = circularDeque.insertLast(0);
        int param_4 = circularDeque.getFront();
        boolean param_5 = circularDeque.insertLast(3);
        int param_6 = circularDeque.getFront();
        boolean param_7 = circularDeque.insertFront(9);
        int param_8 = circularDeque.getRear();
        int param_9 = circularDeque.getFront();
        int param_10 = circularDeque.getFront();
        boolean param_11 = circularDeque.deleteLast();
        int param_12 = circularDeque.getRear();
    }
}
