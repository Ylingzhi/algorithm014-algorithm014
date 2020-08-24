//<p>给定一个二叉树，返回它的&nbsp;<em>前序&nbsp;</em>遍历。</p>
//
//<p>&nbsp;<strong>示例:</strong></p>
//
//<pre><strong>输入:</strong> [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//<strong>输出:</strong> [1,2,3]
//</pre>
//
//<p><strong>进阶:</strong>&nbsp;递归算法很简单，你可以通过迭代算法完成吗？</p>
//

import javax.swing.tree.TreeNode;
import java.util.LinkedList;

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
//    public List<Integer> preorderTraversal(TreeNode root) {
//        //迭代  时间（O(n)）空间（O(n)）
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        LinkedList<Integer> output = new LinkedList<>();
//        if (root == null) {
//            return output;
//        }
//
//        stack.add(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pollLast();
//            output.add(node.val);
//            if (node.right != null) {
//                stack.add(node.right);
//            }
//            if (node.left != null) {
//                stack.add(node.left);
//            }
//        }
//        return output;
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        //迭代优化
        List<Integer> output = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        //只将右节点压入栈中，左节点与自身节点直接访问
        TreeNode temp = root;
        while (temp != null) {
            //访问自身节点
            output.add(temp.val);
            //如果在右节点则入栈
            if (temp.right != null) {
                stack.push(temp.right);
            }
            //访问左节点
            if (temp.left != null) {
                temp = temp.left;
            }else {
                //弹出栈顶节点
                if (!stack.isEmpty()) {
                    temp = stack.poll();
                }else {
                    break;
                }
            }
        }
     return output;
    }
}