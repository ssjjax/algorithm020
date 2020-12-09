/**
 * @author Suisijia
 * @create 2020-12-06 22:28
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1)
        if (root == null || root == p || root == q) {
            return root;
        }
        //2)3)
        // 做树的递归。自底向上返回两边的值，作比较
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左边没值，就返回右边,即为最近公共祖先（注：可能右边此时也为null，则也是返回右边的这个null即可）
        if (left == null) {
            return right;
        }
        // 右边没值，就返回左边，即为最近公共祖先
        if (right == null) {
            return left;
        }
        // 左右都有值，说明p,q分居root的异侧，则root即为最近公共祖先
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
