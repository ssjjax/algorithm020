import java.util.HashSet;
import java.util.Set;

/**
 * @author Suisijia
 * @create 2020-12-14 18:48
 */
public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int result = 0;
        // 起始位置(0,0) 方向朝北（北东南西 0123）
        int x = 0, y = 0, direction = 0;
        int[][] xy = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        //0)用 set 存储障碍物坐标
        Set<String> obstaclesSet = new HashSet<>();
        for (int[] obs : obstacles) {
        //如[{2,4}{3,3}{6,1}]，存到此set中为3个元素：2，4   3，3   6，1
            obstaclesSet.add(obs[0] + "," + obs[1]);
        }

        for (int com : commands) {
            //1)调整方向
            if (com == -2) {
                // turn left
                direction = (direction == 0) ? 3 : direction - 1;
            } else if (com == -1) {
                // turn right
                direction = (direction == 3) ? 0 : direction + 1;
            }
            //2)按指定方向，一步一步试探着前进
            else {
                // ** 步 还没走完 且 下一个格子没障碍物，就一步一步向后试探
                while (com-- > 0 && !obstaclesSet.contains((x + xy[direction][0]) + "," + (y + xy[direction][1]))) {
                    x += xy[direction][0];
                    y += xy[direction][1];
                }
                //3)得结果
                result = Math.max(result, x * x + y * y);
            }
        }
        return result;
    }
}
