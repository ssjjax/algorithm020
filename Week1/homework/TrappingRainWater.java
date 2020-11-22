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
            //��������⣺��stack��ûֵʱ��stack.peek()�Ȳ����ᱨ�����Ҫ���п��������ϣ�
            // 2)��ջ�����
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int cur = stack.pop();
                // �أ����⴦����ջ��Ԫ��һֱ��ȣ���ȫ��pop��ȥ��ֻ����һ����
                //(��ΪҪ����ʵ��װˮ[���߶�Ҫ����]����߽�)
                while (!stack.isEmpty() && height[stack.peek()] == height[cur]) {
                    stack.pop();
                }
                //3������
                if (!stack.isEmpty()) {
                    int left = stack.peek();
                    // left ָ����߽硣�ұ߽��ǵ�ǰ�����壬��i��
                    // Math.min(height[left], height[i]) ���������Ӹ߶ȵ�min����ȥheight[cur]����ˮ�ĸ߶ȡ�
                    // i - left - 1 ����ˮ�Ŀ�ȡ�
                    ans += (Math.min(height[left], height[i]) - height[cur]) * (i - left - 1);
                }
            }
            // 1)��ջ�����
            stack.add(i);
        }
        return ans;
    }
}
