package leetcode.editor.cn;
//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
//e/ 
// Related Topics 树 深度优先搜索 
// 👍 87 👎 0


import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//java:二叉树的深度
public class P剑指_offer_55_i_ErChaShuDeShenDuLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_55_i_ErChaShuDeShenDuLcof().new Solution();
        //测试代码:
        
    }
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//class Solution {//深度优先遍历(DFS)
//    public int maxDepth(TreeNode root) {
//        if(root == null) return 0;
//        int leftLength = maxDepth(root.left);
//        int rightLength = maxDepth(root.right);
//        return leftLength > rightLength ? leftLength + 1 : rightLength + 1;
//    }
//}
class Solution {//广度优先遍历(BFS)
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int dp = 0;
        while (!queue.isEmpty()){
            // 内层循环没开始之前,queue里的所哟节点都是同一层的。所以内层循环一次就是树的一层
            // 注意for循环不能写成for(int i = 0; i < queue.size(); i++), 因为queue.size()在不断变化。
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            dp++;
        }
        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}