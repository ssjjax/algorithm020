import java.util.PriorityQueue;

/**
 * @author Suisijia
 * @create 2020-11-29 20:50
 */
public class ChouShuLcof {
    public int nthUglyNumber(int n) {
        // 0)快速判断
        if(n==1) return 1;
        // 1)建一个小顶堆，将1放入。（每次出堆的即为当前最小值）
        PriorityQueue<Long> q = new PriorityQueue();
        q.add(1L);
        // 2) 先出1后入3。同时在出堆时去重。
        // 每次弹出一个数，即最小值（放到结果集里）；进三个数
        for(long i=1; i<n; i++) {
            long tmp = q.poll();
            // （对弹出的重复数，去重，不计数。
            //   如画图可知，前几轮就会出现两个6。但在出堆的时候才做处理）
            while(!q.isEmpty() && q.peek()==tmp) tmp = q.poll();

            q.add(tmp*2);
            q.add(tmp*3);
            q.add(tmp*5);
        }
        return q.poll().intValue();
    }
}
