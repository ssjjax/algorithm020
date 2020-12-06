import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Suisijia
 * @create 2020-11-30 16:14
 */
public class SlidingWindowMaximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //0)
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //1)
            //（相等的元素，同样先出后进，在deque中留一个即可）
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            //2)
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            //3)
            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
