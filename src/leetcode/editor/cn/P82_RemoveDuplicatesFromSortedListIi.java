package leetcode.editor.cn;
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 592 👎 0


import leetcode.editor.cn.P剑指_offer_25_HeBingLiangGePaiXuDeLianBiaoLcof.ListNode;

import java.util.*;

//java:删除排序链表中的重复元素 II
public class P82_RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
        Solution solution = new P82_RemoveDuplicatesFromSortedListIi().new Solution();
        //测试代码:
        
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//class Solution {//解法一。用HashMap统计每个值出现的次数(没有用上链表有序的特点)
//    public ListNode deleteDuplicates(ListNode head) {
//        Map<Integer,Integer> map = new HashMap<>();
//        ListNode cur = head;
//        while (cur != null){
//            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
//            cur = cur.next;
//        }
//        while (head != null && map.get(head.val) > 1) head = head.next;
//        if(head == null) return null;
//        cur = head;
//        while (cur.next != null){
//            if(map.get(cur.next.val) > 1) cur.next = cur.next.next;
//            else cur = cur.next;
//        }
//        return head;
//    }
//}
//class Solution {//用Set。虽然用到了有序这个特性,但效果不是很好。
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null) return null;
//        HashSet<Integer> set = new HashSet<>();
//        ListNode cur = head;
//        int temp = head.val - 1;//temp初始值设为head.val - 1保证了在升序链表中temp值的唯一性
//        for (;cur != null; cur = cur.next){
//            if(!set.add(cur.val)){
//                temp = cur.val;
//                continue;
//            }
//            if(set.contains(temp)){
//                set.remove(temp);
//            }
//        }
//        if(set.contains(temp)){
//            set.remove(temp);
//        }
//        while (head != null && !set.contains(head.val)) head = head.next;
//        if(head == null) return null;
//        cur = head;
//        while (cur.next != null){
//            if(!set.contains(cur.next.val)) cur.next = cur.next.next;
//            else cur = cur.next;
//        }
//        return head;
//
//    }
//}
class Solution {//解法三。官方解法。用哑结点
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(head.val -1);//这里将dummy.val设为
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int tmp = cur.next.val;
                while (cur.next != null && cur.next.val == tmp) {
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }

        }
        return dummy.next;

    }
}
//class Solution {//解法四。根据官方解法改编, 效果一般。
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null) return null;
//        ListNode dummy = new ListNode(head.val -1);//这里将dummy.val设为
//        dummy.next = head;
//        ListNode cur = dummy;
//        int tmp = dummy.val;
//        while (cur.next != null && cur.next.next != null){
//            if(cur.next.val == cur.next.next.val || cur.next.val == tmp) {
//                tmp = cur.next.val;
//                cur.next = cur.next.next;
//            }else cur = cur.next;
//        }
//        if(cur.next.val == tmp) cur.next = cur.next.next;
//        return dummy.next;
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

}
