import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    //递归
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return helper(0, 0, inorder.length - 1, preorder, inorder);
//    }
//
//    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
//        if (preStart > preorder.length - 1 || inStart > inEnd) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[preStart]);
//        int inIndex = 0; // Index of current root in inorder
//        for (int i = inStart; i <= inEnd; i++) {
//            if (inorder[i] == root.val) {
//                inIndex = i;
//            }
//        }
//        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
//        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
//        return root;
//    }

    //前序遍历是 [root, [左子树的前序遍历结果],[右子树的前序遍历结果]]
    //中序遍历是 [[左子树的中序遍历结果], root, [右子树的中序遍历结果]]
    //思路：中序遍历时，我们使用Hash表来帮助我快速定位根节点，降低时间复杂度，对于hash映射，键表示一个元素，值表示其在中序遍历中出现的位置，后续构建二叉树中，我们只需要
    //O（1）的时间对根节点进行定位

    private Map<Integer,Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder,int[] inorder,int pre_left,int pre_right,int in_left,int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        //前序遍历中的第一个节点就是根节点
        int pre_root = pre_left;
        //中序遍历中定位根节点
        int in_root = indexMap.get(preorder[pre_root]);

        //先把根节点建立起来
        TreeNode root = new TreeNode(preorder[pre_root]);
        //得到左子树中的节点数目
        int size_left_subtree = in_root - in_left;
        //递归构造左子树，并连接到根节点
        //前序遍历中，[从左边界+1开始的size_left_subtree] 个元素就对应了中序遍历中 [从左边界开始到根节点定位-1] 的元素
        root.left = myBuildTree(preorder,inorder,pre_left + 1,pre_left + size_left_subtree,in_left,in_root - 1);
        //递归构造右子树，并连接到根节点
        //前序遍历中，[从左边界+1+左子树节点数目 开始到 右边界] 的元素就对应了中序遍历中 [从 根节点定位+1 到 右边界] 的元素
        root.right = myBuildTree(preorder,inorder,pre_left + size_left_subtree + 1,pre_right,in_root + 1,in_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
