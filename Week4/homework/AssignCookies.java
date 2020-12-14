import java.util.Arrays;

/**
 * @author Suisijia
 * @create 2020-12-14 18:45
 */

//思路：每次找胃口最小的小孩，给够用的最小块饼干

//写法一：for循环（j每次自动前进，i符合条件时前进）（推荐）
public class AssignCookies {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0;
            //解析：j每次都会+1。而i只在符合条件时才+1
            //（但g[]和s[]并不一定谁长。因此，虽然j比i走得快，但并不一定谁先到头
            //    因此i和j都要判断，有一个到头就结束）
            //(j代表饼干)
            for(int j = 0; i < g.length && j < s.length; j++) {
                if (g[i] <= s[j]) {
                    i++;
                }
            }
            return i;
        }
    }
}


//写法二：while循环（根据情况，i和j手动前进）
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        //解析：符合条件时，i和j都+1；否则只有j+1
        //（但g[]和s[]并不一定谁长。因此，虽然j比i走得快，但并不一定谁先到头。
        //     因此i和j都要判断，有一个到头就结束）
        //(j代表饼干)
        while(i < g.length && j < s.length) {
            if(g[i] <= s[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i;
    }
}
