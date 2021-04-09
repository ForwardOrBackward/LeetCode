package leetcode.editor.cn;
//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 127 👎 0


//java:反转链表
public class P剑指_offer_24_FanZhuanLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_24_FanZhuanLianBiaoLcof().new Solution();
        //测试代码:
        
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
//        //解法一
//        if(head == null) return null;
//        ListNode later = head, former = head.next;
//        head.next = null;
//        while (former != null){
//            later = former;
//            former = former.next;
//            later.next = head;
//            head = later;
//        }
//        return head;
        
//        //解法二(来自大神思路,其实跟我的思路一致,只是比我多用了一个变量temp)
//        if(head == null) return null;
//        ListNode later = null, former = head;
//        ListNode temp;
//        while (former != null){
//            temp = later;
//            later = former;
//            former = former.next;
//            later.next = temp;
//        }
//        return later;

        //解法三(递归)
        if(head.next == null) return null;
        reverseList(head.next);
        head.next = head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
