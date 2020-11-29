import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Suisijia
 * @create 2020-11-29 20:55
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        //0)快速排除
        if (k == 0) {
            return new int[0];
        }
        //1)统计次数
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num, 0) + 1);
        }
        //2)维护大小为k的小顶堆（注：堆中存的是key,但判断时比的是value）
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> map.get(v1) - map.get(v2));
        for (Integer key: map.keySet()) {
            if (pq.size() < k) {
                pq.offer(key);
            } else if (map.get(key) > map.get(pq.peek()) ) {
                pq.poll();
                pq.offer(key);
            }
        }
        //3)反向输出到数组
        int[] ans = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
