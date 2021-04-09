package leetcode.editor.cn;
//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 281 👎 0


//java:最长回文串
public class P409_LongestPalindrome{
    public static void main(String[] args) {
        Solution solution = new P409_LongestPalindrome().new Solution();
        //测试代码:
        
    }    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {//方法一。官方解法。这种解法的好处是如果要将该回文串构造出来也很简单。
//    public int longestPalindrome(String s) {
//        int[] count = new int[128];
//        for(int i = 0; i < s.length(); i++){
//            count[s.charAt(i)]++;
//        }
//        int result = 0;
//        for(int v : count){
//            result += v / 2 * 2; //精妙,这里只做偶数次的叠加。
//            //如果result还是偶数次并且v有剩余,则result++,使回文串最长。
//            if((result & 1) == 0 && (v & 1) == 1) result++;
//        }
//        return result;
//    }
//}
class Solution { //方法二。大神解法。比官方解法更加节省空间,以及效率更高
    public int longestPalindrome(String s) {
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1; //和官方的区别写法
        }
        int ans = 0;
        //下面这个for循环只进行偶数次的累加, 不像官方还把奇数次的也算上去了, 这里比官方答案少了很多次条件判断
        for (int x: cnt) {
            // 字符出现的次数最多用偶数次。
            ans += x - (x & 1); //也可以写成 ans += x /2 * 2;
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        //因为不需要将回文串具体表示出来, 所以不需要知道到底哪个字符多了,只有有剩余的字符, 就可以+1了。
        return ans < s.length() ? ans + 1 : ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
