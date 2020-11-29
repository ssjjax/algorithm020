import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Suisijia
 * @create 2020-11-29 20:47
 */
public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevelList = new ArrayList<>();
            Integer curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                Node node = queue.poll();
                curLevelList.add(node.val);
                for (Node n: node.children) {
                    queue.offer(n);
                }
            }
            res.add(curLevelList);
        }
        return res;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
