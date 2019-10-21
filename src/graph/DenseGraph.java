package graph;

import java.util.Vector;

/**
 * 稠密图 - 邻接矩阵
 *
 * @author RWM
 * @date 2019/10/20
 */
public class DenseGraph {

    private int n;
    private int m;
    private boolean directed;
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new boolean[n][n];
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
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    // 验证图中是否有从v到w的边
    private boolean hasEdge(int v, int w) {
        return g[v][w];
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销
    public Iterable<Integer> adj(int v) {
        Vector<Integer> adjV = new Vector<>();
        for (int i = 0; i < n; i++) {
            if (hasEdge(v, i)) {
                adjV.add(i);
            }
        }
        return adjV;
    }

}
