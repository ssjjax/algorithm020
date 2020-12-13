/**
 * @author Suisijia
 * @create 2020-12-14 0:14
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) {
                five++;
            } else if (i == 10) {
                five--;
                ten++;
            } else if (ten > 0) {   //对应20元的账单
                ten--;
                five--;
            } else {                //对应20元的账单
                five -= 3;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }
}
