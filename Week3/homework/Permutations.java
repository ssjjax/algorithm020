import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Suisijia
 * @create 2020-12-06 22:46
 */
public class Permutations {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }
    //1)确定回溯的参数
    private void backtracking(int[] nums, boolean[] used, List<Integer> path) {
        //2)终止条件（同时收集结果）
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        //3)单层搜索的过程
        //（注：与组合问题的区别：1 组合在for循环时需要start条件，而排列需要一个boolean used[]
        //                        2 排列不需要剪枝）
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true)  {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums, used, path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
