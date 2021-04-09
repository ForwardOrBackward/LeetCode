package leetcode.editor.cn;
//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树 
// 👍 130 👎 0


import sun.reflect.generics.tree.Tree;

//java:对称的二叉树
public class P剑指_offer_28_DuiChengDeErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_28_DuiChengDeErChaShuLcof().new Solution();
        //测试代码:
        
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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

//class Solution { //解法一。自写
//    private boolean tag;
//    public boolean isSymmetric(TreeNode root) {
//        tag = true;
//        if(root == null) return tag;
//        recur(root.left, root.right);
//        return tag;
//
//
//    }
//    public  void recur(TreeNode left,TreeNode right){
//        if(tag == false) return;
//        if(left == null && right ==null) return;
//        if(left == null && right ！= null || right == null && left != null || left.val != right.val) {
//            tag = false;
//            return;
//        }
//        recur(left.left,right.right);
//        recur(left.right,right.left);
//    }
//}
class Solution { //解法二。大神写法
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false; //这个条件判断非常精髓，可对比我解法一的写法。
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}