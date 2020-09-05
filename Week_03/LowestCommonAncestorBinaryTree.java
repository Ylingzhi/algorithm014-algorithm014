public class LowestCommonAncestorBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val =x;
        }
    }

    //递归
    private TreeNode ans;

    public LowestCommonAncestorBinaryTree() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    //存储父节点
    //Hash存储父节点
//    Map<Integer,TreeNode> parent = new HashMap<Integer, TreeNode>();
//    Set<Integer> visited = new HashSet<Integer>();
//
//    public void dfs(TreeNode root) {
//        if (root.left != null) {
//            parent.put(root.left.val, root);
//            dfs(root.left);
//        }
//        if (root.right != null) {
//            parent.put(root.right.val, root);
//            dfs(root.right);
//        }
//    }
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        dfs(root);
//        while (p != null) {
//            visited.add(p.val);
//            p = parent.get(p.val);
//        }
//        while (q != null) {
//            if (visited.contains(q.val)) {
//                return q;
//            }
//            q = parent.get(q.val);
//        }
//        return null;
//    }

}
