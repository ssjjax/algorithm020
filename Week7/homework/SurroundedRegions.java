/**
 * @author Suisijia
 * @create 2021-01-06 17:59
 */
public class SurroundedRegions {
    private int rows, cols;
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        rows = board.length;
        cols = board[0].length;
        UnionFind uf = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;
        int[][] d = new int[][]{{1,0}, {0,1}, {0,-1}, {-1,0}};
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') {
                    if(i == 0 || i == rows-1 || j == 0 || j == cols-1) {
                        uf.union(i * cols + j, dummyNode);
                        //或写成uf.union(node(i,j), dummyNode);
                    }
                    else {
                        //写法一：（推荐，经测试效率更高）
                        for (int k=0; k<4; k++) {
                            //board[x][y] 为各方向的试探位置 (分别为四个方向的试探位置：下 右 上 左)
                            int x = i+d[k][0];
                            int y = j+d[k][1];
                            // ** 合并试探位置和原本位置（这样写，能使和边相连的为一组。内部相连的是另外一组！！）
                            if (board[x][y] == 'O') uf.union(x*cols+y, i*cols+j);
                            //注：错误写法
                            // if (board[x][y] == 'O') {
                            //     uf.union(x * cols + y, dummy);
                            // }
                        }
                        //写法二：
                        // //上
                        // if(i > 0 && board[i-1][j] == 'O')  uf.union(node(i,j), node(i-1,j));
                        // //下
                        // if(i < rows-1 && board[i+1][j] == 'O')  uf.union(node(i,j), node(i+1,j));
                        // //左
                        // if(j > 0 && board[i][j-1] == 'O')  uf.union(node(i,j), node(i, j-1));
                        // //右
                        // if(j < cols-1 && board[i][j+1] == 'O')  uf.union(node(i,j), node(i, j+1));
                    }
                }
            }
        }
        for(int i = 1; i < rows-1; i++) {
            for(int j = 1; j < cols-1; j++) {
                //（isConnected()的第一个参数或写成node(i,j)）
                if(board[i][j] == 'O' && !uf.isConnected(i * cols + j, dummyNode)) {
                        board[i][j] = 'X';
            }
        }
    }
}
    private int node(int i, int j) {
        //即j才是坐标位置的主导
        return i * cols + j;
    }
}

class UnionFind {
    private int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int p) {
        if (p == parent[p]) {
            return p;
        }
        return parent[p] = find(parent[p]);
    }
    public void union (int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            parent[rootP] = rootQ;
        }
    }
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}