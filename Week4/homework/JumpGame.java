/**
 * @author Suisijia
 * @create 2020-12-15 9:42
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            //开始时，i 和 farthest 都是0。
            //若某次 i 超过了farthest，说明往后推farthest的过程失败，即无法到达结尾了
            if (i > farthest) {
                return false;
            }
            farthest = Math.max( i + nums[i], farthest);
        }
        return true;
    }
}
