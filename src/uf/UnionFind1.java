package uf;

/**
 * @author RWM
 * @date 2019/1/8
 */
public class UnionFind1 {
    private int[] id;
    private int count;

    public UnionFind1(int n) {
        count = n;
        id = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    private int find(int p) {
        return id[p];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < count; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }
}
