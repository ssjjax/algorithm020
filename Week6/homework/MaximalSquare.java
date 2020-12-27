/**
 * @author Suisijia
 * @create 2020-12-28 0:03
 */
public class MaximalSquare {
    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                else if(i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
                else if(j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
