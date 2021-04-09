package leetcode.editor.cn;
//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法 
// 👍 83 👎 0



//java:合并两个排序的链表
public class P剑指_offer_25_HeBingLiangGePaiXuDeLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_25_HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        //测试代码:
        
    }


//Definition for singly-linked list.
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
//class Solution {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1 == null) return l2;
//        if(l2 == null) return l1;
//        ListNode result;
//        if(l1.val<=l2.val) {
//            result = new ListNode(l1.val);
//            l1 = l1.next;
//        }
//        else{
//            result = new ListNode(l2.val);
//            l2 = l2.next;
//        }
//
//        ListNode temp = result;
//        while(l1 != null && l2 != null){
//            if(l1.val <= l2.val){
//                temp.next = new ListNode(l1.val);
//                l1 = l1.next;
//            }else{
//                temp.next = new ListNode(l2.val);
//                l2 = l2.next;
//            }
//            temp = temp.next;
//        }
//        if(l1 != null){
//            temp.next = l1;
//        }
//        if(l2 != null){
//            temp.next = l2;
//        }
//        return result;
//    }
//}
//class Solution { //解法2
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1 == null) return l2;
//        if(l2 == null) return l1;
//        ListNode result,assist1,assist2,assist1Before,assist2Before;
//        if(l1.val<=l2.val) {
//            result = l1;
//            assist1 = l1.next;
//            assist1Before = l1;
//            assist2 = l2;
//            assist2Before = null;
//        }
//        else{
//            result = l2;
//            assist1 = l2.next;
//            assist1Before = l2;
//            assist2 = l1;
//            assist2Before = null;
//        }
//        while(assist1 != null && assist2 != null){
//            if(assist1.val <= assist2.val){
//                assist1Before = assist1;
//                assist1 = assist1.next;
//            }else{
//                assist2Before = assist2;
//                assist2 = assist2.next;
//                assist1Before.next = assist2Before;
//                assist1Before = assist2Before;
//                assist1Before.next = assist1;
//
//            }
//        }
////        if(assist1 != null){
////            temp.next = l1;
////        }
//        if(assist2 != null){
//            assist1Before.next = assist2;
//        }
//        return result;
//    }
//}
//class Solution { //解法3 对解法1略微改良。
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1 == null) return l2;
//        if(l2 == null) return l1;
//        ListNode result,assist1,assist2,temp;
//        if(l1.val<=l2.val) {
//            result = new ListNode(l1.val);
//            assist1 = l1.next;
//            assist2 = l2;
//        }
//        else{
//            result = new ListNode(l2.val);
//            assist1 = l2.next;
//            assist2 = l1;
//        }
//        temp = result;
//        while(assist1 != null && assist2 != null){
//            if(assist1.val <= assist2.val){
//                temp.next = new ListNode(assist1.val);
//                assist1 = assist1.next;
//            }else{
//                temp.next = new ListNode(assist2.val);
//                assist2 = assist2.next;
//            }
//            temp = temp.next;
//        }
//        if(assist1 != null){
//            temp.next = assist1;
//        }
//        if(assist2 != null){
//            temp.next = assist2;
//        }
//        return result;
//    }
//}
class Solution { //解法4 网上大神解法，精简。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}