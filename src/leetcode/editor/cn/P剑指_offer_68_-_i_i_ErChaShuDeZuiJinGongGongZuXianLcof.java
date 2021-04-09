package leetcode.editor.cn;
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
//
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
//
// 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a
//-binary-tree/ 
// Related Topics 树 
// 👍 212 👎 0


import java.util.HashMap;

//java:二叉树的最近公共祖先
public class P剑指_offer_68_-_i_i_ErChaShuDeZuiJinGongGongZuXianLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_68_-_i_i_ErChaShuDeZuiJinGongGongZuXianLcof().new Solution();
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
class Solution {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        find(root, p, q);
        return result;
    }
    public int find(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return 0;
        int left = find(root.left, p, q);
        if(left == -1) return -1;
        int right = find(root.right, p, q);
        if(right == -1) return -1;
        int mid = ((root == p || root == q)) ? 1 : 0;
        if(left + right + mid == 2) {
            result = root;
            return -1;
        }
        return left + right + mid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
