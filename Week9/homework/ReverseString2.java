/**
 * @author Suisijia
 * @create 2021-01-18 11:39
 */
public class ReverseString2 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        // * 步长为 i += 2 * k, 表示以2*k个为一组
        for (int i = 0; i < arr.length; i += 2 * k) {
            //写arr.length - 1是防止下标越界
            //(同时可满足条件：如果剩余字符少于 k 个，则将剩余字符全部反转。)
            int j = Math.min(i + k - 1, arr.length - 1);
            swap(arr,i,j);
        }
        return String.valueOf(arr);
    }
    private void swap(char[] arr, int i, int j) {
        for (; i < j; i++,j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
