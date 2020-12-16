/**
 * @author Suisijia
 * @create 2020-12-16 9:31
 */

/*思路：无限分割， 永远都在有序的序列里面找。若没找到，就在另一部分里找
        具体：1 前半部分有序：
                    目标值也在前半部分：在前半部分中找
                                        否则，去后半部分找
              2 后半部分有序：
                    目标值也在后半部分：在后半部分中找
                                        否则，去前半部分找
*/
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[left] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }
}
