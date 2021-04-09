package leetcode.editor.cn;
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 215 👎 0


import java.util.ArrayList;
import java.util.List;

//java:和为s的连续正数序列
public class P剑指_offer_57_-_i_i_HeWeiSdeLianXuZhengShuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_57_-_i_i_HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int[][] findContinuousSequence(int target) {
//        int [][] result = new int[target/2][];
//        int count = 0;
//
////        for(int x = 3; x < target/2; x++){
////
////            if(x % 2 != 0 && target % x == 0 ){
////
////            }
////        }
//        for(int x = target/2; x >= 3 ; x--){
//            if(x % 2 != 0 && target % x == 0 ){
//                int factor = target / x;
//                int low = factor - x/2;
//                if (low > 0){
//                    result[count] = new int[x];
//                    for(int j = 0,element = low; j < x; j++,element++){
//                        result[count][j] = element;
//                    }
//                    count++;
//                }
//            }
//        }
//        if(target%2 != 0){
//            result[count++] = new int[]{target/2, target/2 + 1};
//        }else if(target/2 % 2 !=0 && target/2/2 - 1 > 0){
//            result[count++] = new int[]{target/2/2 - 1 ,target/2/2,target/2/2+1,target/2/2+2};
//
//        }
//
//        int[][] result2 = new int[count][];
//        for(int k = 0; k < count; k++){
//            result2[k] = result[k];
//        }
//        return result2;
//    }
//}
//class Solution {
//    public int[][] findContinuousSequence(int target) {
//        List<int[]> list = new ArrayList<>();
//        int sum;
//        for(int x = 1; x <= target/2; x++){
//            sum = 0;
//            for(int j = x; ;j++){
//                sum += j;
//                if(sum == target) {
//                    int[] serial = new int[j - x + 1];
//                    for (int k = x; k <= j; k++) {
//                        serial[k - x] = k;
//                    }
//                    list.add(serial);
//                    break;
//                }
//                if(sum > target){
//                    break;
//                }
//            }
//        }
//        return list.toArray(new int[list.size()][]);
//    }
//}

//class Solution {  //解法二。用一元二次方程的求根公式
//    public int[][] findContinuousSequence(int target) {
//        List<int[]> list = new ArrayList<>();
//        for(int x = 1; x <= target/2; x++){
//            long delta = 1 - 4 * (-(long)x * x + x - 2 * target);
//            if(delta < 0) break;
//            int delta_sqrt = (int)Math.sqrt(delta);
//            if((long)delta_sqrt*delta_sqrt == delta && (-1 + delta_sqrt) % 2 == 0){
//                int y = (-1 + delta_sqrt) / 2;
//                int[] serial = new int[y - x + 1];
//                for (int k = x; k <= y; k++) {
//                    serial[k - x] = k;
//                }
//                list.add(serial);
//            }
//        }
//        return list.toArray(new int[list.size()][]);
//    }
//}
class Solution {  //解法三。用双指针
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int l = 1, r = 2;
        int sum;
        int length = target / 2;
        while(l < r && l <= length){
            sum = (l + r) * (r - l + 1) / 2 ;
            if(sum < target) r++;
            else if(sum > target) l++;
            else{
                int[] serial = new int[r - l + 1];
                for (int k = l; k <= r; k++) {
                    serial[k - l] = k;
                }
                list.add(serial);
                l++; //这句非常容易忘记加上
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}