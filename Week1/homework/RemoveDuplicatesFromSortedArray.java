/**
 * @author Suisijia
 * @create 2020-11-22 15:39
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j] && i > j) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
