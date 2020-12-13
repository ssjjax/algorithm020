/**
 * @author Suisijia
 * @create 2020-12-14 0:16
 */
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) {
                profit += tmp;
            }
        }
        return profit;
    }
}
