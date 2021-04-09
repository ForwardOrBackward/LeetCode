package leetcode.editor.cn;
//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 
//
// 返回删除后的链表的头节点。 
//
// 注意：此题对比原题有改动 
//
// 示例 1: 
//
// 输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2: 
//
// 输入: head = [4,5,1,9], val = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明： 
//
// 
// 题目保证链表中节点的值互不相同 
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点 
// 
// Related Topics 链表 
// 👍 65 👎 0


import javax.management.ListenerNotFoundException;

//java:删除链表的节点
public class P剑指_offer_18_ShanChuLianBiaoDeJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_18_ShanChuLianBiaoDeJieDianLcof().new Solution();
        //测试代码:
        
    }
    //Definition for singly-linked list.
    class ListNode {
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
    //解法一(自写)
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null) return null;
        if(val == head.val) return head.next;
        ListNode temp = head;
        while (temp.next != null){
            if(val == temp.next.val){
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }
//    //解法二(大神写的,效率还没我的高)
//    public ListNode deleteNode(ListNode head, int val) {
//        if(head.val == val) return head.next;
//        ListNode pre = head, cur = head.next;
//        while(cur != null && cur.val != val) {
//            pre = cur;
//            cur = cur.next;
//        }
//        if(cur != null) pre.next = cur.next;
//        return head;
//    }
    //解法三(大神写的,效率还没我的高)
//public ListNode deleteNode(ListNode head, int val) {
//    if (head == null) return null;
//    if (head.val == val) return head.next;
//    ListNode cur = head;
//    while (cur.next != null && cur.next.val != val)
//        cur = cur.next;
//    if (cur.next != null)
//        cur.next = cur.next.next;
//    return head;
//}
//    //解法四(网上写的,效率还没我的高)
//    // 通过改变指向删除节点
//    public ListNode deleteNode(ListNode head, int val) {
//        // 空链表
//        if (head == null) { return null; }
//        // 至少有一个节点
//        boolean find = false;   // false表示没找到val，true表示找到了
//        // 新增头节点
//        ListNode phead = new ListNode(-1);
//        phead.next = head;
//        // slow指向要删除的节点的前驱，quick指向要删除的节点
//        ListNode slow = phead, quick = phead.next;
//        while (quick != null) {
//            if (quick.val == val) {     // 找到了
//                find = true;
//                break;
//            }
//            slow = slow.next;
//            quick = quick.next;
//        }
//        // 如果没找到就不用删，返回原链表
//        if (!find) { return head; }
//        // 找到了要删，改变前驱指向即可
//        slow.next = quick.next;
//        return phead.next;
//
//    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
