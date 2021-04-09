package leetcode.editor.cn;
//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 193 👎 0


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//java:滑动窗口的最大值
public class P剑指_offer_59_-_i_HuaDongChuangKouDeZuiDaZhiLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_59_-_i_HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution { //方法一。自己想的解法。解题效果也不错。
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if(nums == null || nums.length == 0) return new int[0];
//
//        int length = nums.length;
//        int[] result = new int[length - k + 1];
//        int maxIndex = maxIndex(nums, 0, k - 1);
//        result[0] = nums[maxIndex];
//        for(int j = k; j < length; j++){//接下来从第二个窗口开始遍历
//            int windowStartIndex  = j - k + 1; //窗口的起始元素的索引是j-k+1,末端元素的索引是j
//            if(maxIndex < windowStartIndex){//如果上一个窗口的最大元素已经不在当前窗口中, 那么只能在当前窗口重新找一个最大值
//                maxIndex = maxIndex(nums, windowStartIndex, j);
//            }else if( nums[maxIndex] <= nums[j]) {//如果上一个窗口的最大元素还在当前窗口中,只需要比较它和新加入窗口的那个值谁更大即可
//                maxIndex = j;
//            }//else其他情况则maxIndex保持为上一个窗口的maxIndex
//
//            //结果数组的索引和窗口的起始元素的索引都是从1开始,一次循环+1,所以可用同一个
//            result[windowStartIndex] = nums[maxIndex];
//        }
//        return result;
//
//    }
//    public int maxIndex(int[] nums, int startIndex, int endIndex){
//        int maxIndex = startIndex;
//        for(int i = startIndex + 1; i <= endIndex; i++){
//            if(nums[i] > nums[maxIndex]) maxIndex = i;
//        }
//        return maxIndex;
//    }
//}
//class Solution { //方法二。来自大神, 核心思想是用一个双端队列来实O(N)的时间复杂度
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int length = nums.length;
//        if(nums == null || length == 0) return new int[0];
//        int[] result = new int[length - k + 1];
//        Deque<Integer> deque = new LinkedList<>();
//        //i是滑动窗口的左边界(i==j-k+1), j是滑动窗口的右边界。开始遍历时还未形成窗口,直到i>=0后才形成窗口
//        for(int j = 0, i = 1 - k; j < length; i++, j++){
//            if(i > 0 && deque.peekFirst() == nums[i-1]){
//                deque.removeFirst();
//            }
//            //注意:要使用双端队列而不是普通队列的原因就在下面这个循环, 需要从队尾删除元素。
//            while (!deque.isEmpty() && nums[j] > deque.peekLast()) {
//                deque.removeLast();
//            }
//            deque.addLast(nums[j]);
//            if(i >= 0){ //i>=0,开始给result数组赋值。
//                result[i] = deque.peekFirst();
//            }
//        }
//        return result;
//    }
//}
class Solution { //方法二。来自大神, 核心思想是用一个双端队列来实O(N)的时间复杂度
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(nums == null || length == 0) return new int[0];
        int[] result = new int[length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        //形成第一个窗口的循环
        for (int j = 0; j < k; j++){
            while (!deque.isEmpty() && nums[j] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);
        }
        //记得把第一个窗口的最大值添加上
        result[0] = deque.peekFirst();
        //形成第一个窗口后的循环
        for(int j = k; j < length; j++){
            if( deque.peekFirst() == nums[j-k]){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[j] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            //这个循环只会循环result.length-1次, 从result[1]开始赋值。
            result[j-k+1] = deque.peekFirst();

        }
        return result;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}