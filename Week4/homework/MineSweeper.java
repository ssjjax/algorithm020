import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Suisijia
 * @create 2020-12-15 15:17
 */

//问题：为啥此题的DFS比BFS快不少??

//解法一：DFS
public class MineSweeper {
    // 定义 8 个方向
    int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        // 1. 若起点是雷，游戏结束，直接修改 board 并返回。
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else { // 2. 若起点是空地（即E），则从起点开始向 8 邻域的空地dfs。
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        // 递归终止条件：空地(i, j)周围有雷，则将该位置修改为雷数，终止该路径的搜索。
        int count = 0;
        for (int k = 0; k < 8; k++) {
            // 一步一步试探着前进，统计以(i,j)为中心的九宫格内雷数
            //（注：(i,j)才是实际位置，(x,y)为试探位置）
            int x = i + dx[k];
            int y = j + dy[k];
            //超出的范围，肯定不会有雷，直接跳过
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                continue;
            }
            if (board[x][y] == 'M') {
                count++;
            }
        }
        if (count > 0) {
            //注：从'0'到'9'的ASCII码值，是从48到57依次递增的（因此配合题目输出形式，这么写即可）
            board[i][j] =  (char)(count + '0');
            return;
        }

        // 若空地 (i, j) 周围无雷，则将该位置修改为 ‘B’，并向 8 邻域的空地继续搜索。
        board[i][j] = 'B';
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            //注：其中 board[x][y] != 'E' 实际 即 表示 此试探位置(x,y)是数字
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
                continue;
            }
            dfs(board, x, y);
        }
    }
}

//解法二：BFS
class Solution3 {
    // 定义 8 个方向
    int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        // 1. 若起点是雷，游戏结束，直接修改 board 并返回。
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        // 2. 若起点是空地，则将起点入队，从起点开始 向 8 邻域的空地BFS。
        // 建一个同等大小的visited[][]数组
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0], j = point[1];
            // 统计空地 (i, j) 周围的雷数
            int count = 0;
            for (int k = 0; k < 8; k++) {
                int newX = i + dx[k];
                int newY = j + dy[k];
                if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) {
                    continue;
                }
                if (board[newX][newY] == 'M') {
                    count++;
                }
            }
            // 分支一：若空地 (i, j) 周围有雷，则将该位置修改为雷数；
            if (count > 0) {
                board[i][j] = (char)(count + '0');
            } else {   // 分支二：否则将该位置更新为 ‘B’，并将其 8 邻域中的空地入队，继续 bfs
                board[i][j] = 'B';
                for (int k = 0; k < 8; k++) {
                    int newX = i + dx[k];
                    int newY = j + dy[k];
                    // 此处的 board[newX][newY]!='E'，仍表示此试探位置board[newX][newY]为数字
                    // （同时，要满足此位置没被走过）
                    if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length || board[newX][newY] != 'E' || visited[newX][newY]) {
                        continue;
                    }
                    // （将路过的位置标记为true，不会再重复走）
                    visited[newX][newY] = true;
                    //注：BFS的这个存到queue中的动作，也是在 for 中完成的，这样才能一次延伸出多个
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
        return board;
    }
}