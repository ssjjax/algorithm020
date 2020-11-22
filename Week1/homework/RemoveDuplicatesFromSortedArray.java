/**
 * @author Suisijia
 * @create 2020-11-22 16:04
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            // i > j 可避免原地复制
            if (nums[i] != nums[j] && i > j) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
