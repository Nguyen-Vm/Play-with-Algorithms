package uf;

/**
 * @author RWM
 * @date 2019/1/8
 */
public class UnionFind2 {
    private int[] parent;
    private int count;

    public UnionFind2(int n) {
        count = n;
        parent = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        parent[pRoot] = qRoot;
    }
}
