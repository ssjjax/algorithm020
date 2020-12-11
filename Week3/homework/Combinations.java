import java.util.ArrayList;
import java.util.List;

/**
 * @author Suisijia
 * @create 2020-12-06 22:43
 */
public class Combinations {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1, new ArrayList<>());
        return res;
    }
    //1)确定回溯的参数
    private void backtracking(int n, int k, int start, List<Integer> path) {
        //2)终止条件（同时收集结果）
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        //3)单层搜索的过程
        //4)剪枝
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
