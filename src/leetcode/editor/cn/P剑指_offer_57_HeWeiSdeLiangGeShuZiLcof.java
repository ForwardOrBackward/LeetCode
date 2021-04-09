package leetcode.editor.cn;
//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// 👍 73 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//java:和为s的两个数字
public class P剑指_offer_57_HeWeiSdeLiangGeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_57_HeWeiSdeLiangGeShuZiLcof().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution { //解法一： 暴力破解，运行超时了。
//    public int[] twoSum(int[] nums, int target) {
//        for(int i = 0; i < nums.length-1; i++){
//            for(int j = i + 1; j < nums.length; j++){
//                if(nums[i]+nums[j]==target) return new int[]{nums[i],nums[j]};
//            }
//        }
//        return null;
//    }
//}

//class Solution { //解法二。使用二分查找改良暴力解法的内层循环。依然运行超时。
//    public int[] twoSum(int[] nums, int target) {
//        int temp;
//        int low, high, mid;
//        for(int i = 0; i < nums.length-1; i++){
//            temp = target - nums[i];
//            low = i + 1;
//            high = nums.length-1;
//            while (low <= high){
//                mid = (low + high)/2;
//                if(nums[mid]==temp) return new int[]{nums[i],nums[mid]};
//                if(nums[mid] < temp) low = low + 1;
//                if(nums[mid] > temp) high = high - 1;
//            }
//        }
//        return null;
//    }
//}
//class Solution { //解法三。来自大神思路，非常精辟的解法。使用首尾双指针
//    public int[] twoSum(int[] nums, int target) {
//        int i = 0, j = nums.length -1;
//        while (i < j){
//            if(nums[i] + nums[j] == target) return new int[]{nums[i],nums[j]};
//            else if(nums[i] + nums[j] < target) i++;
//            else j--;
//        }
//        return null;
//    }
//}
class Solution { //解法四。用HashSet来存储nums数组。这种解法的缺陷在于，数组中有重复元素，且target由数组中的两个重复元素获得（如60 = 30 + 30）时，将会有问题。
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num : nums){
            if(set.contains(target-num)) return new int[]{num, target-num};
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}