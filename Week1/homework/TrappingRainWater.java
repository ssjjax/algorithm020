import java.util.Stack;

/**
 * @author Suisijia
 * @create 2020-11-22 17:21
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            //（个人理解：当stack中没值时，stack.peek()等操作会报错，因此要把判空条件加上）
            // 2)出栈的情况
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int cur = stack.pop();
                // 特）特殊处理：若栈顶元素一直相等，则全部pop出去，只留第一个。
                //(因为要找能实现装水[即高度要更高]的左边界)
                while (!stack.isEmpty() && height[stack.peek()] == height[cur]) {
                    stack.pop();
                }
                //3）计算
                if (!stack.isEmpty()) {
                    int left = stack.peek();
                    // left 指向左边界。右边界是当前的柱体，即i。
                    // Math.min(height[left], height[i]) 是左右柱子高度的min，减去height[cur]即雨水的高度。
                    // i - left - 1 是雨水的宽度。
                    ans += (Math.min(height[left], height[i]) - height[cur]) * (i - left - 1);
                }
            }
            // 1)进栈的情况
            stack.add(i);
        }
        return ans;
    }
}
