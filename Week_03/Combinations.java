import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

    //回溯

//    private List<List<Integer>> res = new ArrayList<>();
//
//    private void combine(int n, int k, int begin, Stack<Integer> pre) {
//        if (pre.size() == k) {
//            res.add(new ArrayList<>(pre));
//            return;
//        }
//        //分析i的上界
//        for (int i = begin;i <= n;i++) {
//            pre.add(i);
//            combine(n,k,i+1,pre);
//            pre.pop();
//        }
//    }
//
//    public List<List<Integer>> combine(int n, int k) {
//        //特殊判断
//        if (n <= 0 || k <= 0 || n < k) {
//            return res;
//        }
//        combine(n, k, 1, new Stack<>());
//        return res;
//    }

    public List<List<Integer>> combine(int n, int k) {
        //递归
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }

        List<List<Integer>> res = combine(n-1, k-1);
        res.forEach(e -> e.add(n));
        res.addAll(combine(n-1, k));
        return res;
    }
}
