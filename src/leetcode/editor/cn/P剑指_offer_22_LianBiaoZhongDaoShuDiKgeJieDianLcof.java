package leetcode.editor.cn;
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 98 👎 0


//java:链表中倒数第k个节点
public class P剑指_offer_22_LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_22_LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        //测试代码:

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    //解法一(自写)
    class Solution {
        private int count = 0;
        public ListNode getKthFromEnd(ListNode head, int k) {
            if(head==null) return null;
            ListNode temp = getKthFromEnd(head.next,k);
            count++;
            if(count == k) return head;
            return temp; //没有找到第k个节点时, 会一直递归返回null。找到第k个节点后,就一直递归返回第k个节点了
        }
    }

//    //解法二(思路来自大神, 没我写的效率高)
//    class Solution {
//        public ListNode getKthFromEnd(ListNode head, int k) {
//            ListNode  former = head, later = head;
//            for(int i = 0; i < k; i++){
//                former = former.next;
//            }
//            while (former != null){
//                former = former.next;
//                later = later.next;
//            }
//            return later;
//        }
//    }

//    //解法三(思路来自大神, 来自解法二的优化,少用一次循环,效率跟我差不多)
//    class Solution {
//        public ListNode getKthFromEnd(ListNode head, int k) {
//            ListNode  former = head, later = head;
//            int count = 0;
//            while (former != null){
//                former = former.next;
//                if(++count > k) later = later.next;
//            }
//            return later;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}
