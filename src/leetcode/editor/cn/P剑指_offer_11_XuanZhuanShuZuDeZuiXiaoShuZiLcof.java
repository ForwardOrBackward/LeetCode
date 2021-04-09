package leetcode.editor.cn;
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找 
// 👍 163 👎 0


//java:旋转数组的最小数字
public class P剑指_offer_11_XuanZhuanShuZuDeZuiXiaoShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_11_XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        //测试代码:
        System.out.println(solution.minArray(new int[]{10,1,10,10,10}));
    }    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) {
        int low = 0,high = numbers.length-1;
        int mid;
        //int min = numbers[high];注意这里最好不要用固定的最小值,会解不出来。
        while(low<high){ //注意这里循环条件没有等号, 是因为函数的返回值是numbers[low]
            mid =(low+high)/2;
            //以下标为high的元素值来作为标准来比较
            if(numbers[mid] < numbers[high]) {
                high = mid;//注意这里是精髓。不是给high赋值mid-1;
            }else if(numbers[mid] >  numbers[high]) {
                low =mid+1;
                
            }else{ //numbers[mid] == min
                high = high -1;
            }
//            }

        }
        return numbers[low];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
