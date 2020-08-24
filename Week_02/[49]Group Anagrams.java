//<p>给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。</p>
//
//<p><strong>示例:</strong></p>
//
//<pre><strong>输入:</strong> <code>[&quot;eat&quot;, &quot;tea&quot;, &quot;tan&quot;, &quot;ate&quot;, &quot;nat&quot;, &quot;bat&quot;]</code>
//<strong>输出:</strong>
//[
//  [&quot;ate&quot;,&quot;eat&quot;,&quot;tea&quot;],
//  [&quot;nat&quot;,&quot;tan&quot;],
//  [&quot;bat&quot;]
//]</pre>
//
//<p><strong>说明：</strong></p>
//
//<ul>
//	<li>所有输入均为小写字母。</li>
//	<li>不考虑答案输出的顺序。</li>
//</ul>
//


import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //排序数组分类
        //思路：当 且仅当他们的排序字符串相等时，两个字符串是字母异位词
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}