package graph;

import java.util.Vector;

/**
 * 稀疏图 - 邻接表
 *
 * @author RWM
 * @date 2019/10/20
 */
public class SparseGraph {

    private int n;
    private int m;
    private boolean directed;
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = (Vector<Integer>[]) new Vector[n];

        for (int i = 0; i < n; i++) {
            g[i] = new Vector<>();
        }
    }

    public int V() {
        return n;
    } // 返回节点个数

    public int E() {
        return m;
    } // 返回边的个数

    // 向图中添加一个边
    public void addEdge(int v, int w) {
        if (hasEdge(v, w)) {
            return;
        }
        g[v].add(w);
        if (v != w && !directed)
            g[w].add(v);

        m++;
    }

    // 验证图中是否有从v到w的边
    boolean hasEdge(int v, int w) {
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i) == w) {
                return true;
            }
        }
        return false;
    }

    // 返回图中一个顶点的所有邻边
    public Iterable<Integer> adj(int v) {
        return g[v];
    }

}
