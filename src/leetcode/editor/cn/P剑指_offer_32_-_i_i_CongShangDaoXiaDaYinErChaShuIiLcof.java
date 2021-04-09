package leetcode.editor.cn;
//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 80 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//java:从上到下打印二叉树 II
public class P剑指_offer_32_i_i_CongShangDaoXiaDaYinErChaShuIiLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_32_i_i_CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> row = new ArrayList<>();
            //注意这里一定要使用currentLevelSzie暂存queue.size(),因为在for循环的过程
            //中，queue.size()的大小是一直变化的，会导致循环次数不是我们想要的循环次数。
            // 这里for循环的逻辑就是：for循环前，队列里的元素全都是同一层的元素
            //如果不暂存，则for循环改为for(int i = currentLevelSzie; i > 0; i--)也可以。
            int currentLevelSzie = queue.size();
            for(int i = 0; i < currentLevelSzie; i++){
                TreeNode node = queue.poll();
                row.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(row);
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}