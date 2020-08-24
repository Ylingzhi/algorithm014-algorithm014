//<p>给定一个二叉树，返回它的<em>中序&nbsp;</em>遍历。</p>
//
//<p><strong>示例:</strong></p>
//
//<pre><strong>输入:</strong> [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//<strong>输出:</strong> [1,3,2]</pre>
//
//<p><strong>进阶:</strong>&nbsp;递归算法很简单，你可以通过迭代算法完成吗？</p>
//

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //    public List<Integer> inorderTraversal(TreeNode root) {
//        //递归   时间复杂度 O(n)  空间复杂度: 最坏情况是O(n),平均情况是O(logn)
//        List<Integer> res = new ArrayList<>();
//        helper(root,res);
//        return res;
//    }
//
//    public void helper(TreeNode root,List<Integer> res){
//        if (root != null) {
//            if (root.left != null) {
//                helper(root.left,res);
//            }
//            res.add(root.val);
//            if (root.right != null) {
//                helper(root.right,res);
//            }
//        }
//    }



//    public List<Integer> inorderTraversal(TreeNode root) {
//        //基于栈的遍历   时间O(n)  空间：O(n)
//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode curr = root;
//        while (curr != null || !stack.isEmpty()) {
//            while (curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//
//            curr = stack.pop();
//            res.add(curr.val);
//            curr = curr.right;
//        }
//        return res;
//    }

    //莫里斯遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            }else {
                pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return res;
    }
}