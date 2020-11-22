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
            //������⣺ע��nums[p1] == nums[p2] �����������д����ٷ���ⲻͬ��
            //          ȡnums2�е����ݷŵ�ĩβ���ɱ���������ȶ���
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        // ������⣺��nums1���ù⣬��nums2ʣ���Ԫ��ȫ����䵽nums1����ǰ�档
        //           ��nums2���ù⣬���ô�������0�ĳ��ȼ��ɣ�
        System.arraycopy(nums2,0,nums1,0,p2 + 1);
    }
}
