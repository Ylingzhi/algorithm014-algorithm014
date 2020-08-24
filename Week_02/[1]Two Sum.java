//<p>给定一个整数数组 <code>nums</code>&nbsp;和一个目标值 <code>target</code>，请你在该数组中找出和为目标值的那&nbsp;<strong>两个</strong>&nbsp;整数，并返回他们的数组下标。</p>
//
//<p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例:</strong></p>
//
//<pre>给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[<strong>0</strong>] + nums[<strong>1</strong>] = 2 + 7 = 9
//所以返回 [<strong>0, 1</strong>]
//</pre>
//

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}