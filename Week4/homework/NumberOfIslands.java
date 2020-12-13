/**
 * @author Suisijia
 * @create 2020-12-14 0:17
 */

//DFS
public class NumberOfIslands {
    private int rows;     //行数
    private int columns;  //列数
    public int numIslands(char[][] grid) {
        int count = 0;
        rows = grid.length;
        if (rows == 0) return 0;
        columns = grid[0].length;
        //遍历二维数组。遇到是1的，就开始dfs搜索边界
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= columns || grid[i][j] != '1') return;
        //先将路过的节点，标记为0。保证只会访问一次
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}


//BFS
/*
    private int rows;     //行数
    private int columns;  //列数
    public int numIslands(char[][] grid) {
        int count = 0;
        rows = grid.length;
        if (rows == 0) return 0;
        columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[] { i, j });
        while (!list.isEmpty()) {
            int[] cur = list.remove();
            i = cur[0]; j = cur[1];
            if(i >= i && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                list.add(new int[] { i + 1, j });
                list.add(new int[] { i - 1, j });
                list.add(new int[] { i, j + 1 });
                list.add(new int[] { i, j - 1 });
            }
        }
    }
*/
