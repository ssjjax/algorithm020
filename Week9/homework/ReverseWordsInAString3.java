/**
 * @author Suisijia
 * @create 2021-01-18 11:43
 */
public class ReverseWordsInAString3 {
    //写法一：（推荐，易理解）
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {
                int j = i;
                // (j+1表示试探位置)
                while (j + 1 < ca.length && ca[j + 1] != ' ') j++;
                // * 至此,i表示每个单词的起始位置,j表示每个单词的结束位置
                reverse(ca, i, j);
                //（更新起点i）(了解：写成i=j+1也行，此处没必要细抠)
                i = j;
            }
        }
        return new String(ca);
    }
    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }
}
