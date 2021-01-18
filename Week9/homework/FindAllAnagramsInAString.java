/**
 * @author Suisijia
 * @create 2021-01-18 11:48
 */
public class FindAllAnagramsInAString {
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        //0)
        if(str == null || str.length() == 0) return 0;
        //1)
        while(index < str.length() && str.charAt(index) == ' ' )
            index ++;
        //特)
        if (index == str.length()) return 0;
        //2)
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }
        //3)
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            //写法一：
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                // 本应是 ans * 10 + digit > Integer.MAX_VALUE
                // 但 *10 和 + digit 都可能越界，所有都移动到右边去即可。
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            //写法二：
            // if(Integer.MAX_VALUE/10 < total || (Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit))
            //     return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            //（注：以上两种写法，都是将Integer.MIN_VALUE ("-2147483648") 直接当作越界处理了[实际没越界]。结果虽然也是对的，但这个小细节要了解）
            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
}
