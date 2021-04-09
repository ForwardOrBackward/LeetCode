package leetcode.editor.cn;
//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 
// 👍 61 👎 0


import java.util.Arrays;
import java.util.Stack;

//java:包含min函数的栈
public class P剑指_offer_30_BaoHanMinhanShuDeZhanLcof{
    public static void main(String[] args) {
        MinStack solution = new P剑指_offer_30_BaoHanMinhanShuDeZhanLcof().new MinStack();
        //测试代码:
        solution.push(2147483646);
        solution.push(2147483646);
        solution.push(2147483647);
        solution.top();
        solution.pop();
        solution.min();
        solution.pop();
        solution.min();
        solution.pop();
        solution.push(2147483647);
        solution.top();
        solution.min();
        solution.push(-2147483648);
        solution.top();
        solution.min();
        solution.pop();
        solution.min();
        System.out.println(Integer.MIN_VALUE);

    }    
//leetcode submit region begin(Prohibit modification and deletion)
    //解法一(自写)
//class MinStack {
//        int[] stack;
//        int topIndex;
//        int minIndex = 0;  //minIndex初值设为0是有一些小bug的。
//    /** initialize your data structure here. */
//    public MinStack() {
//        stack = new int[2];
//        topIndex = -1;
//    }
//
//    public void push(int x) {
//        if(topIndex == stack.length-1){
//            stack = Arrays.copyOf(stack, stack.length*2);
//        }
//        topIndex++;
//        stack[topIndex] = x;
//        if(x < stack[minIndex]) minIndex = topIndex;
//    }
//
//    public void pop() {
//        if(minIndex == topIndex && minIndex != 0) {
//            minIndex = topIndex-1;
//            for (int i = topIndex-2; i >= 0; i--){
//                if(stack[i] <= stack[minIndex]) minIndex = i;
//            }
//        }
//        topIndex--;
//    }
//
//    public int top() {
//        return stack[topIndex];
//    }
//
//    public int min() {
//        return stack[minIndex];
//    }
//}

      //解法二(根据大神思路改编解法一)
//    class  MinStack{
//        int[] stackElements, stackMin;
//        int topElements,topMin;
//        public MinStack(){
//            stackElements = new int[10];
//            stackMin = new int[6];
//            topElements = -1;
//            topMin = -1;
//        }
//        public void push(int x) {
//            if(topElements == stackElements.length-1){
//                stackElements = Arrays.copyOf(stackElements, stackElements.length*2);
//            }
//            stackElements[++topElements] = x;
//            if(topMin == -1 || stackMin[topMin] >= x){ //注意这里是>=而不是> 。这是精髓。
//                if(topMin == stackMin.length-1){
//                    stackMin = Arrays.copyOf(stackMin, stackMin.length+stackMin.length/2);
//                }
//                stackMin[++topMin] = x;
//            }
//        }
//        public void pop() {
//            if(stackElements[topElements] == stackMin[topMin]){
//                topMin--;
//            }
//            topElements--;
//
//        }
//        public int top() {
//            return stackElements[topElements];
//        }
//        public int min() {
//            return stackMin[topMin];
//        }
//    }

//class MinStack { //大神解法
//        Stack<Integer> A, B;
//        public MinStack() {
//            A = new Stack<>();
//            B = new Stack<>();
//        }
//        public void push(int x) {
//            A.add(x);
//            if(B.empty() || B.peek() >= x) //注意这里是>=而不是> 。这是精髓。
//                B.add(x);
//        }
//        public void pop() {
//            //这里因为A.pop()和B.peek()返回的都是Integer类型的对象,而不是其中有一个是int型的,所以不会自动拆箱,所以不能用==
//            if(A.pop().equals(B.peek()))
//                B.pop();
//        }
//        public int top() {
//            return A.peek();
//        }
//        public int min() {
//            return B.peek();
//        }
//    }
class MinStack { //时隔许久, 再做了一遍, 和上面的解法相同
    public Stack<Integer> minNums;
    public Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        minNums = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        if(minNums.isEmpty() || minNums.peek() >= x) minNums.push(x);
        stack.push(x);
    }

    public void pop() {
        //if(stack.pop() == minNums.peek()) minNums.pop(); //这是错误的写法。比较的是Integer而不是int
        if(stack.pop().equals(minNums.peek())) minNums.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minNums.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
