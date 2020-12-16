/**
 * @author Suisijia
 * @create 2020-12-16 9:33
 */

/*
一维数组 的索引 和 二维矩阵 的坐标 转换公式：
        一维数组 的索引 -> 二维矩阵 的坐标: index -> [index/列数,index%列数]
        二维矩阵 的坐标 -> 一维数组 的索引: [x,y] -> x * 列数 + y
*/
public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int midIndex, midValue;
        while (left <= right) {
            //midIndex = (left + right) / 2; (优化前写法)
            midIndex = left + ((right - left) >> 1);
            midValue = matrix[midIndex / n][midIndex % n];
            if (target == midValue) {
                return true;
            } else if (midValue < target) {
                left = midIndex + 1;
            } else {
                right = midIndex - 1;
            }
        }
        return false;
    }
}
