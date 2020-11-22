/**
 * @author Suisijia
 * @create 2020-11-22 15:47
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0 ) {
            //个人理解：注意nums[p1] == nums[p2] 的情况。（此写法与官方题解不同）
            //          取nums2中的数据放到末尾，可保持排序的稳定性
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        // 个人理解：当nums1先拿光，将nums2剩余的元素全部填充到nums1的最前面。
        //           当nums2先拿光，不用处理（拷贝0的长度即可）
        System.arraycopy(nums2,0,nums1,0,p2 + 1);
    }
}
