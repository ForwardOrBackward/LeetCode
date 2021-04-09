package leetcode.editor.cn;
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 346 👎 0


import java.util.*;

//java:字符串中的第一个唯一字符
public class P387_FirstUniqueCharacterInAString{
    public static void main(String[] args) {
        Solution solution = new P387_FirstUniqueCharacterInAString().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {//方法一
//    public int firstUniqChar(String s) {
//        int temp = 0;
//        Map<Character,Integer> map = new HashMap<>();
//        for(int i = 0; i< s.length(); i++) {
//            char ch = s.charAt(i);
//            map.put(ch, map.getOrDefault(ch,0) + 1);
//        }
//        for(int i = 0; i< s.length(); i++) {
//            if (map.get(s.charAt(i)) == 1) {
//                return i;
//            }
//        }
//            return -1;
//    }
//}
//class Solution { //方法二
//    public int firstUniqChar(String s) {
//        Map<Character,Integer> map = new HashMap<>();
//        int n = s.length();
//        for(int i = 0; i< n; i++) {
//            char ch = s.charAt(i);
//            if(map.containsKey(ch)) map.put(ch, -1);
//            else map.put(ch, i);
//        }
//        int min = n; //因为map中的遍历是没有按添加进map里的次序遍历的，所以需要一个min来反复比较以得到最小的位置索引
//        for(Map.Entry<Character, Integer> i : map.entrySet()){
//            int position = i.getValue();
//            if(position!= -1 && min > position) min = position;
//        }
//        if (min == n) min = -1;  //如果遍历完min还是等于n，那么就返回-1
//        return min;
//    }
//}
class Solution { //方法三。队列
        public int firstUniqChar(String s) {
            Map<Character,Integer> map = new HashMap<>();
            int n = s.length();
            for(int i = 0; i< n; i++) {
                char ch = s.charAt(i);
                if(map.containsKey(ch)) map.put(ch, -1);
                else map.put(ch, i);
            }
            int min = n; //因为map中的遍历是没有按添加进map里的次序遍历的，所以需要一个min来反复比较以得到最小的位置索引
            for(Map.Entry<Character, Integer> i : map.entrySet()){
                int position = i.getValue();
                if(position!= -1 && min > position) min = position;
            }
            if (min == n) min = -1;  //如果遍历完min还是等于n，那么就返回-1
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}