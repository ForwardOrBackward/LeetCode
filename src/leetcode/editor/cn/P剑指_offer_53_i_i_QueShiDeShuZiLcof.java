package leetcode.editor.cn;
//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 数组 二分查找 
// 👍 104 👎 0



//java:0～n-1中缺失的数字
public class P剑指_offer_53_i_i_QueShiDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_53_i_i_QueShiDeShuZiLcof().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {//解法一。暴力解法，顺序遍历
//    public int missingNumber(int[] nums) {
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i]!=i) return i;
//        }
//        return nums.length;
//    }
//}
//class Solution {//解法二。二分查找
//    public int missingNumber(int[] nums) {
//        int low = 0,high = nums.length -1;
//        int mid;
//        while (low<=high){
//            mid = (low + high)/2;
//            if(nums[mid] == mid) low = mid + 1;
//            if(nums[mid] == mid + 1){
//                if(mid-1 == -1 || nums[mid-1]==mid-1) return mid;
//                else high = mid - 1;
//            }
//        }
//        return nums.length;
//    }
//}
class Solution {//解法三。大神解法
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        //跳出时，变量 i和 j 分别指向 “右子数组的首位元素” 和 “左子数组的末位元素” 。因此返回i 即可。
        return i;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}