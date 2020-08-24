import java.util.*;

public class LevelOrder {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

//        public List<List<Integer>> levelOrder(Node root) {
//            //利用队列实现广度优先搜索
//            List<List<Integer>> res = new ArrayList<>();
//            if (root == null) {
//                return res;
//            }
//
//            Queue<Node> queue = new LinkedList<>();
//            queue.add(root);
//            while (!queue.isEmpty()) {
//                List<Integer> level = new ArrayList<>();
//                int size = queue.size();
//                for (int i =0;i<size;i++) {
//                    Node node = queue.poll();
//                    level.add(node.val);
//                    queue.addAll(node.children);
//                }
//                res.add(level);
//            }
//            return res;
//        }

        public List<List<Integer>> levelOrder(Node root) {
            //简化的广度优先算法
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            List<Node> previousLayer = Arrays.asList(root);

            while (!previousLayer.isEmpty()) {
                List<Node> currentLayer = new ArrayList<>();
                List<Integer> previousVals = new ArrayList<>();
                for (Node node : previousLayer) {
                    previousVals.add(node.val);
                    currentLayer.addAll(node.children);
                }
                res.add(previousVals);
                previousLayer = currentLayer;
            }
            return res;
        }
    }
}
