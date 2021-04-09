package sort.algorithms.summary;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        HeapSort test = new HeapSort();
        int[] arr = new int[]{0,0,2,3,2,1,1,2,0,4};
        test.heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public void heapSort(int[] arr){
        //下面这个for循环是为了建立初始堆, 循环一次建立一个顶点。
        // 需要注意的是叶子节点是不需要调整的,第一个需要调整的是从后往前数的第一个非叶子节点
        for(int i = (arr.length-1)/2; i >= 0; i--){
            sift(arr, i, arr.length -1);
        }
        //建立好初始堆后, 下面这个依次将小顶堆的根节点arr[0]换到数组的末尾,让其不参与接下来的堆调整。然后就
        //开始依次调整堆了。
        for(int i = arr.length - 1; i >= 1; i--){
            //每次循环将当前小顶堆的根节点arr[0]依次放到数组的尾部。因为arr[0]就是当前小顶堆的堆顶值(最小值)。
            int tmp = arr[0];
            arr[0] = arr[i]; //注意是相对尾部, 所以这里是arr[i],一次循环往回走一格
            arr[i] = tmp;
            //接下来开始调整堆。因为上面建好堆之后只有根节点arr[0]交换过, 所以只需要调整根节点。
            // 所以需要调整的节点low是0, 而此时堆的上界已经变成里的i-1, 也就是把刚刚交换出去的堆顶值排除在外了。
            sift(arr, 0, i-1);
        }
    }

    /**
     *
     * @param arr
     * @param low 是当前堆里要调整的节点的位置
     * @param high 是当前堆的上界, 也就是当前堆的最大的数组索引下标
     */
    public void sift(int[] arr, int low, int high){
        int i = low, j = low * 2 + 1; //j是i的左孩子节点
        while(j <= high){
            if(j + 1 <= high && arr[j] > arr[j+1]){ //如果i的右孩子节点存在,并且比左孩子更小,就让准备要和i节点交换的节点变为i的右孩子节点
                ++j;
            }
            if(arr[i] > arr[j]) {
                int temp = arr[i];  //temp装着i节点的值, 准备和自己的两个孩子中的一个交换
                arr[i] = arr[j];
                arr[j] = temp;
                //交换完成后, i变成其交换了值的孩子, j继续变为i的左孩子。以便于继续循环看看交换下去了较大的值后,下面的节点是否还符合小顶堆的性质(父亲小,孩子大)
                i = j;
                j = j * 2 + 1;
            } else{
                break; //一旦发现当前父子节点符合小顶堆的性质,则他们的子节点都不需要调整了, 必然是符合性质的
            }
        }
    }
    /**
     * 这个方法是上面这个方法的改良, 所用的内存空间会更少。区别也就是把int temp = arr[i]放到了while循环之外
     * @param arr
     * @param low 是当前堆里要调整的节点的位置
     * @param high 是当前堆的上界, 也就是当前堆的最大的数组索引下标
     */
    public void sift2(int[] arr, int low, int high){
        int i = low, j = low * 2 + 1;
        int temp = arr[i];  //把temp放到了while循环之外
        while(j <= high){
            if(j + 1 <= high && arr[j] > arr[j+1]){
                ++j;
            }
            if(temp > arr[j]) { //把arr[i] > arr[j]变成了temp > arr[j]
                //int temp = arr[i]; //这句放到了while循环之前
                arr[i] = arr[j];
                //arr[j] = temp; //把这句放到了循环之后, 因为temp没必要每次存到数组里,等确定temp的最终位置再存。

                i = j;
                j = j * 2 + 1;
            } else{
                break;
            }
        }
        arr[i] = temp; //把arr[j] = temp;变成了arr[i] = temp;并放到了while循环之后, 因为循环过后的i 就是j。

    }
}

