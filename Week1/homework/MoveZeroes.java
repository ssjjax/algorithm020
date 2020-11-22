/**
 * @author Suisijia
 * @create 2020-11-22 15:52
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                // 此处这个判断写在外面貌似更好一点
                if(i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
