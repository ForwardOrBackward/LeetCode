package leetcode.editor.cn;
//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 94 👎 0



//java:在排序数组中查找数字 I
public class P剑指_offer_53_i_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_53_i_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1, mid;
        int result = 0;
        while (low <= high){
            mid = (low + high)/2;
            if(nums[mid] < target) low = mid + 1;
            if(nums[mid] > target) high = mid -1;
            if(nums[mid] == target){
                result++;
                for(int i = mid-1; i>=low;i--){
                    if(nums[i] == target) result ++;
                    else break;
                }
                for(int j = mid+1; j<=high;j++){
                    if(nums[j] == target) result ++;
                    else break;
                }
                return result;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}