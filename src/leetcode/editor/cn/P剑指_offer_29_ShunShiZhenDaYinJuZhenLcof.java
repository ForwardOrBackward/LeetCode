package leetcode.editor.cn;
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 140 👎 0


import java.util.*;

//java:顺时针打印矩阵
public class P剑指_offer_29_ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_29_ShunShiZhenDaYinJuZhenLcof().new Solution();
        //测试代码:

        System.out.println(Arrays.toString(solution.spiralOrder(new int[][]{{1,2,3,10},{4,5,6,11},{7,8,9,12}})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        //解法1
//        public int[] spiralOrder(int[][] matrix) {
//            if(matrix == null || matrix.length==0) return new int[0];
//            int column = matrix[0].length;
//            int row = matrix.length;
//            int veer = 0; //这个变量用来记录掉转方向的次数,以便于知道下一步该往哪个方向走
//            int i = 0,j = 0; //记录当前所在的元素的下标
//            Set<String> set = new HashSet<>();
//            int[] result = new int[row*column]; //返回的结果数组
//            for(int k = 0; k < row*column ; k++){
//                //注意下面这个判断条件也很有意思,允许数组越界
//                if(set.contains(i+","+j)||j==column||i==row||j==-1){
//                    switch (veer%4) { //精髓在switch里
//                        case 0:
//                            j--;
//                            i++;
//                            break;
//                        case 1:
//                            i--;
//                            j--;
//                            break;
//                        case 2:
//                            i--;
//                            j++;
//                            break;
//                        case 3:
//                            i++;
//                            j++;
//                            break;
//                    }
//                    veer++;
//                }
//                set.add(i+","+j);
//                result[k] = matrix[i][j];
//                switch (veer%4){
//                    case 0:
//                        j++;
//                        break;
//                    case 1:
//                        i++;
//                        break;
//                    case 2:
//                        j--;
//                        break;
//                    case 3:
//                        i--;
//                        break;
//
//                }
//            }
//            return result;
//        }


//        //解法二
//        public int[] spiralOrder(int[][] matrix) {
//            if(matrix == null || matrix.length==0) return new int[0];
//            int column = matrix[0].length;
//            int row = matrix.length;
//            int veer = 0; //这个变量用来记录掉转方向的次数,以便于知道下一步该往哪个方向走
//            int i = 0,j = 0; //记录当前所在的元素的下标
//            Set<String> set = new HashSet<>();
//            int[] result = new int[row*column]; //返回的结果数组
//            for(int k = 0; k < row*column ; k++){
//                set.add(i+","+j);
//                result[k] = matrix[i][j];
//                switch (veer%4){
//                    case 0:
//                        if(set.contains(i+","+(j+1)) || j+1>=column){
//                            i++;
//                            veer++;
//                        } else {
//                            j++;
//                        }
//                        break;
//                    case 1:
//                        if(set.contains((i+1)+","+j) || i+1>=row){
//                            j--;
//                            veer++;
//                        } else {
//                            i++;
//                        }
//                        break;
//                    case 2:
//                        if(set.contains(i+","+(j-1)) || j-1<0){
//                            i--;
//                            veer++;
//                        } else {
//                            j--;
//                        }
//                        break;
//                    case 3:
//                        if(set.contains((i-1)+","+j) || i-1<0){
//                            j++;
//                            veer++;
//                        } else {
//                            i--;
//                        }
//                        break;
//                }
//            }
//            return result;
//        }


        //解法三:
        //因为顺时针方向循环时,每次走只会朝一个方向走(要么按行走,要么按列走),只要能知道每一次按行或列一次该走几步,就可以得到结果。
        //也就可以不需要用Set也能得到结果
        public int[] spiralOrder(int[][] matrix) {
            if(matrix == null || matrix.length==0) return new int[0];
            int column = matrix[0].length;
            int row = matrix.length;
            int veer = 0; //这个变量用来记录掉转方向的次数,以便于知道下一步该往哪个方向走
            int i = 0,j = 0; //记录当前所在的元素的下标
            int column_step = column, row_step = row;//这两个参数用来得到每一次掉转方向后接下来需要走几步
            int column_count = 0,row_count = 0; //这两个参数用来记录当前已经走了几步
            int[] result = new int[row*column]; //返回的结果数组
            for(int k = 0; k < row*column; k++){
                result[k] = matrix[i][j];
                if(veer%2==1) row_count++;
                else column_count++;
                if(row_count>=row_step || column_count>=column_step){
                    veer++;
                    column_count=0;
                    row_count=0;
                    if(veer%2==0) column_step--;
                    if(veer%2==1) row_step--;
                }
                switch (veer%4){
                    case 0:
                        j++;
                        break;
                    case 1:
                        i++;
                        break;
                    case 2:
                        j--;
                        break;
                    case 3:
                        i--;
                        break;
                }
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
