package leetcode.editor.cn;
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 192 👎 0


import java.util.Arrays;
import java.util.Scanner;

//java:最小的k个数
public class P剑指_offer_40_ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_40_ZuiXiaoDeKgeShuLcof().new Solution();
        //测试代码:
        int[] arr = new int[]{0,0,2,3,2,1,1,2,0,4};
        int k = 10;
        System.out.println(Arrays.toString(solution.getLeastNumbers(arr,k)));
    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {//解法一: 暴力解法
//    public int[] getLeastNumbers(int[] arr, int k) {
//        int[] result = new int[k];
//        int min ,tmp;
//        for (int i = 0; i < arr.length; i++){
//            min = i;
//            for(int j = i; j < arr.length; j++){
//                if(arr[min] > arr[j]) min = j;
//            }
//            if(i >= k) break;
//            tmp = arr[min];
//            arr[min] = arr[i];
//            arr[i] = tmp;
//            result[i] = arr[i];
//        }
//        return result;
//    }
//}
class Solution {//解法二。用堆排序来求topN
    int[] result;
    public int[] getLeastNumbers(int[] arr, int k) {
        result = new int[k];
        heapSort(arr, k);
        return result;
    }
    public void heapSort(int[] arr, int k){ //k和堆排序没关系, 只是用来解此题。
         int count = 0;//count只是为了统计result数组存了几个元素了, 与堆排序无关
        //下面这个for循环是为了建立初始堆, 循环一次建好。
        // 需要注意的是叶子节点是不需要调整的,第一个需要调整的是从后往前数的第一个非叶子节点
        for(int i = (arr.length-1)/2; i >= 0; i--){
            sift(arr, i, arr.length-1);
        }
        //建立好初始堆后, 下面这个依次将小顶堆的根节点arr[0]换到数组的末尾,让其不参与接下来的堆调整。然后就
        //开始依次调整堆了。
        for(int j = arr.length - 1; j >= 1; j--){
            //下面这个if/else语句是唯一和堆排序没关系的,只是用来解此题的。
            if(count < k) result[count++] = arr[0];
            else break;

            //每次循环将当前小顶堆的根节点arr[0]依次放到数组的尾部。因为arr[0]就是当前小顶堆的堆顶值(最小值)。
            int tmp = arr[0];
            arr[0] = arr[j]; //注意是相对尾部, 所以这里是arr[i],一次循环往回走一格
            arr[j] = tmp;
            //接下来开始调整堆。因为上面建好堆之后只有根节点arr[0]交换过, 所以只需要调整根节点。
            // 所以需要调整的节点low是0, 而此时堆的上界已经变成里的i-1, 也就是把刚刚交换出去的堆顶值排除在外了。
            sift(arr, 0, j-1);
        }
        //如果k的个数等于arr.length, 那么还需要执行下面的语句, 因为上面这个for循环只执行了arr.length-1次
        if(k == arr.length) result[count] = arr[0];
    }
    /**
     * @param arr
     * @param low 是当前堆里要调整的节点的位置
     * @param high 是当前堆的上界, 也就是当前堆的最大的数组索引下标
     */
    public void sift(int[] arr, int low, int high){
        int i = low, j = low * 2 + 1; //j是i的左孩子节点
        int temp = arr[i];
        while(j <= high){
            if(j + 1 <= high && arr[j] > arr[j+1]){ //如果i的右孩子节点存在,并且比左孩子更小,就让准备要和i节点交换的节点变为i的右孩子节点
                ++j;
            }
            if(temp > arr[j]) {
                //int temp = arr[i];  //temp装着i节点的值, 准备和自己的两个孩子中的一个交换
                arr[i] = arr[j];
                //arr[j] = temp;
                //交换完成后, i变成其交换了值的孩子, j继续变为i的左孩子。以便于继续循环看看交换下去了较大的值后,下面的节点是否还符合小顶堆的性质(父亲小,孩子大)
                i = j;
                j = j * 2 + 1;
            } else{
                break; //一旦发现当前父子节点符合小顶堆的性质,则他们的子节点都不需要调整了, 必然是符合性质的
            }
        }
        arr[i] = temp;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}