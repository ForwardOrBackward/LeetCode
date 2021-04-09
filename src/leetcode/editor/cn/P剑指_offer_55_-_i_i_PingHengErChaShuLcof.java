package leetcode.editor.cn;
//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 0 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 122 👎 0


//java:平衡二叉树
public class P剑指_offer_55_-_i_i_PingHengErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_55_-_i_i_PingHengErChaShuLcof().new Solution();
        //测试代码:
        
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
//class Solution {//自想解法
//    boolean flag = true;
//    public boolean isBalanced(TreeNode root) {
//        getDepth(root);
//        return flag;
//    }
//    public int getDepth(TreeNode root){
//        if(root == null) return 0;
//        int leftDepth = getDepth(root.left);
//        int rightDepth = getDepth(root.right);
//        if((leftDepth - rightDepth) > 1 || (leftDepth - rightDepth) < -1) flag = false;
//        return leftDepth > rightDepth ? leftDepth + 1: rightDepth + 1;
//
//    }
//}
class Solution {//由大神思路写出。
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) == -1 ? false : true;
    }
    public int getDepth(TreeNode root){
        if(root == null) return 0;
        int leftDepth = getDepth(root.left);
        if(leftDepth == -1) return -1;
        int rightDepth = getDepth(root.right);
        if(rightDepth == -1) return -1;
        if((leftDepth - rightDepth) > 1 || (leftDepth - rightDepth) < -1) return -1;
        return leftDepth > rightDepth ? leftDepth + 1: rightDepth + 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
