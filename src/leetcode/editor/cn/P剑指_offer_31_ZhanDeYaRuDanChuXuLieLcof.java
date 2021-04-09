package leetcode.editor.cn;
//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈
//的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。 
//
// 
//
// 示例 1： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= pushed.length == popped.length <= 1000 
// 0 <= pushed[i], popped[i] < 1000 
// pushed 是 popped 的排列。 
// 
//
// 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/ 
// 👍 90 👎 0


import java.util.List;
import java.util.Stack;

//java:栈的压入、弹出序列
public class P剑指_offer_31_ZhanDeYaRuDanChuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_31_ZhanDeYaRuDanChuXuLieLcof().new Solution();
        //测试代码:
        System.out.println(solution.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
    }    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //解法一(自写)
//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        Stack<Integer> stack = new Stack<>();
//        int count = 0;
//        int i = 0;
//        while(true){
//            if(!stack.isEmpty() && stack.peek() == popped[count]){
//                count++;
//                stack.pop();
//            }else{
//                if(i==pushed.length) break;
//                stack.push(pushed[i]);
//                i++;
//            }
//        }
//        if(stack.isEmpty()) return true;
//        else return false;
//    }

    //解法二(大神解析)
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed){
            stack.push(num);
            //和我自写的区别就是这里用的是循环而我用的是判断。
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                i++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
