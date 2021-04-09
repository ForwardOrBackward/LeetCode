package leetcode.editor.cn;
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 52 👎 0


import java.util.Arrays;

//java:调整数组顺序使奇数位于偶数前面
public class P剑指_offer_21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        //测试代码:
        System.out.println(Arrays.toString(solution.exchange(new int[]{1,3,5})));
    }    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int temp;
        while(low < high){
            while(low<high && nums[low] % 2 != 0) low++;
            while(low<high && nums[high] % 2 == 0) high--;
            if(low < high){
                temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
