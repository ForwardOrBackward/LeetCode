package leetcode.editor.cn;
//输入两个链表，找出它们的第一个公共节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lis
//ts/ 
// 
// Related Topics 链表 
// 👍 160 👎 0


import java.util.HashSet;
import java.util.List;
import java.util.Set;

//java:两个链表的第一个公共节点
public class P剑指_offer_52_LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_52_LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof().new Solution();
        //测试代码:
        
    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//public class Solution { //方法一。暴力解法
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode a = headA;
//        while (a != null){
//            ListNode b = headB;
//            while (b != null){
//                //注意:判断当前a和b节点是不是公共节点,也就是判断是不是同一节点,
//                // 那么也就是判断引用地址是否相等, 而不仅仅是判断a.val是不是等于b.val
//                if(a == b) return a;
//                b = b.next;
//            }
//            a = a.next;
//        }
//        return null;
//    }
//}
//public class Solution { //方法二。将两个链表依次存入Set集合, 第一个add()失败的就是公共节点
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        Set<ListNode> set = new HashSet<>();
//        ListNode tmp = headA;
//        while (tmp != null){
//            set.add(tmp);
//            tmp = tmp.next;
//        }
//        tmp = headB;
//        while (tmp != null){
//            if(!set.add(tmp)) return tmp;
//            tmp = tmp.next;
//        }
//        return null;
//    }
//}
//public class Solution { //方法三。将两个链表"同时"放入Set集合中,一个链表放完后再把另一个单独放入set
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        Set<ListNode> set = new HashSet<>();
//        ListNode a = headA;
//        ListNode b = headB;
//        while (a != null && b !=null){
//            if(!set.add(a)) return a;
//            if(!set.add(b)) return b;
//            a = a.next;
//            b = b.next;
//        }
//        while (a != null){
//            if(!set.add(a)) return a;
//            a = a.next;
//        }
//        while (b != null){
//            if(!set.add(b)) return b;
//            b = b.next;
//        }
//        return null;
//    }
//}
//public class Solution { //方法四。根据大神思路自写。(性能比上面三个方法优良很多)
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if(headA == null || headB == null) return null; //这句判断一定要写, 否则会返回非空链表的第一个节点。
//        ListNode a = headA;
//        ListNode b = headB;
//        while(a != null || b != null){ //注意只有a和b同时为null才结束循环, 也就是相当于循环条件是 !(a == null && b == null)
//            if(a == null) a = headB;
//            if(b == null) b = headA;
//            if(a == b) return a; //要注意此句放的位置, 不能放在循环的最前面,否则当其中一个为null时,会和null比较, 应该先换head
//            a = a.next;
//            b = b.next;
//        }
//        return null;
//    }
//}
public class Solution {//方法五。大神写法。非常简洁
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = (A != null ? A.next : headB);
            B = (B != null ? B.next : headA);
        }
        return A;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}