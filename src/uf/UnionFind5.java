package uf;

/**
 * @author RWM
 * @date 2019/1/8
 */
public class UnionFind5 {
    private int[] parent;
    private int[] rank;
    private int count;

    public UnionFind5(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int p) {
        /*while (p != parent[p]) {
            p = parent[p];
        }
        return p;*/

        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;

        // path compression 2, 递归算法
        /*if (p != parent[p])
            parent[p] = find(parent[p]);
        return parent[p];*/
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

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }

    }
}
