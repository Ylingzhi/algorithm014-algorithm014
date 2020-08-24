//<p>给定两个字符串 <em>s</em> 和 <em>t</em> ，编写一个函数来判断 <em>t</em> 是否是 <em>s</em> 的字母异位词。</p>
//
//<p><strong>示例&nbsp;1:</strong></p>
//
//<pre><strong>输入:</strong> <em>s</em> = &quot;anagram&quot;, <em>t</em> = &quot;nagaram&quot;
//<strong>输出:</strong> true
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre><strong>输入:</strong> <em>s</em> = &quot;rat&quot;, <em>t</em> = &quot;car&quot;
//<strong>输出: </strong>false</pre>
//
//<p><strong>说明:</strong><br>
//你可以假设字符串只包含小写字母。</p>
//
//<p><strong>进阶:</strong><br>
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？</p>
//

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
//    public boolean isAnagram(String s, String t) {
//        //排序   //时间: O(nLogn)  空间：O（1）
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        char[] str1 = s.toCharArray();
//        char[] str2 = t.toCharArray();
//        Arrays.sort(str1);
//        Arrays.sort(str2);
//        return Arrays.equals(str1,str2);
//    }

    //哈希表  时间：O(n)  空间：O(1)
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        int [] counter = new int[26];
//        for (int i = 0;i<s.length();i++) {
//            counter[s.charAt(i) - 'a']++;
//            counter[t.charAt(i) - 'a']--;
//        }
//        for (int count:counter) {
//            if (count != 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}