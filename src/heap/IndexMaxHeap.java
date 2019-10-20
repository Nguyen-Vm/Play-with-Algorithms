package heap;

/**
 * @author RWM
 * @date 2018/12/24
 */
// 在堆的有关操作中，需要比较堆中元素的大小，所以Item需要extends Comparable
public class IndexMaxHeap<Item extends Comparable> {

    // 堆元素数组
    private Item[] data;
    private int[] indexes;
    private int[] reverse;

    // 堆元素个数
    private int count;
    // 堆可容纳元素个数
    private int capacity;

    /**
     * 构造函数，构造一个空堆，可容纳capacity个元素
     *
     * @param capacity
     */
    public IndexMaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;
        }
        count = 0;
        this.capacity = capacity;
    }

    /**
     * 构造函数，通过一个给定数组创建一个最大堆
     * 该构造过程，时间复杂度为O(n)
     *
     * @param arr
     */
    /*public IndexMaxHeap(Item arr[]) {
        int n = arr.length;

        data = (Item[]) new Comparable[n + 1];
        capacity = n;

        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;

        // heapify
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }*/

    /**
     * 返回堆中元素个数
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 返回堆中是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 向堆中插入一个新的元素item
     *
     * @param item
     */
    public void insert(int i, Item item) {
        assert count + 1 <= capacity;
        assert (i + 1 >= 1 && i + 1 <= capacity);

        i += 1;
        data[i] = item;
        indexes[count + 1] = i;
        reverse[i] = count + 1;
        count++;
        shiftUp(count);
    }

    /**
     * 从最大堆中取出堆顶元素，即堆中所存储的最大数据
     *
     * @return
     */
    public Item extractMax() {
        assert count > 0;
        Item ret = data[indexes[1]];

        swap(indexes[1], indexes[count]);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);

        return ret;
    }

    /**
     * 从最大堆中取出堆顶元素的索引
     *
     * @return
     */
    public int extractMaxIndex() {
        assert count > 0;
        int ret = indexes[1] - 1;

        swap(indexes[1], indexes[count]);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);

        return ret;
    }

    /**
     * 获取最大堆中的堆顶元素
     *
     * @return
     */
    public Item getItem(int i) {
        assert (contain(i));
        return data[i + 1];
    }

    public void change(int i, Item newItem) {

        assert (contain(i));
        i += 1;
        data[i] = newItem;

        /*for (int j = 1; j <= count; j++) {
            if (indexes[j] == i) {
                shiftUp(j);
                shiftDown(j);
            }
        }*/
        int j = reverse[i];
        shiftUp(j);
        shiftDown(j);
    }

    private boolean contain(int i) {
        assert (i + 1 >= 1 && i + 1 <= capacity);
        return reverse[i + 1] != 0;
    }


    /**
     * 最大堆核心辅助函数
     */
    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]].compareTo(data[indexes[k]]) < 0) {
            swap(indexes[k], indexes[k / 2]);
            reverse[indexes[k]] = k;
            reverse[indexes[k / 2]] = k / 2;
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            // data[j] 是 data[2*k]和data[2*k+1]中的最大值
            if (j + 1 <= count && data[indexes[j + 1]].compareTo(data[indexes[j]]) > 0) {
                j++;
            }

            if (data[indexes[k]].compareTo(data[indexes[j]]) >= 0) break;
            swap(indexes[k], indexes[j]);
            reverse[indexes[k]] = k;
            reverse[indexes[j]] = j;
            k = j;
        }
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public static void main(String[] args) {
        IndexMaxHeap<Integer> maxHeap = new IndexMaxHeap<>(100);
        System.out.println(maxHeap.size());
    }

}
