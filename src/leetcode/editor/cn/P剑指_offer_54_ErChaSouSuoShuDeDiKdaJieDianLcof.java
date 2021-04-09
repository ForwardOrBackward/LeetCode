package leetcode.editor.cn;
//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 119 👎 0


import sun.reflect.generics.tree.Tree;

//java:二叉搜索树的第k大节点
public class P剑指_offer_54_ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_54_ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
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
class Solution { //采用：右、根、左的遍历方式，就是从大到小依次遍历。并且加上剪枝操作，避免找到第k大的值后函数还在执行。
    private int k, result;  //关键在于要用成员变量来记录k，否则直接用kthLargest方法来进行递归的话会导致上层函数的k值全都一样。
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;

    }
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0){
            result = root.val;
            return;
        }
        dfs(root.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}