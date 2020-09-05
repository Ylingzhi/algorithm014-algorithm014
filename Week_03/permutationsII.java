import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class permutationsII {

    //回溯模型
    //1.路径：也就是已经做出的选择
    //2.选择列表：也就是当前可以做的选择
    //3.结束条件
    //基本架构 如下：
    //LinkedList result = new LinkedList();
    //public void backtrack(路径，选择列表) {
    // if (满足结束条件) {
    //      result.add(结果);
    //  }
    //  for (选择：选择列表) {
    //      做出选择;
    //      backtrack(路径，选择列表);
    //      撤销选择;
    //  }
    // }
    //关键点是递归之前做选择，在递归之后撤销选择
    //本题题意返回所有不重复的全排列，有限制条件，所以进行剪枝
    //
    //1.给数组排序，便于剪枝
    //2.已经选择过的方案，不需要放进结果集里
    //3.如果当前节点与它的前一个节点一样，并且其他的前一个节点已经被遍历过了，那我们也不需要了

    //1.声明一个存放结果集的集合
    public List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return result;
        }

        //首先给数组排序
        Arrays.sort(nums);
        //调用回溯函数
        findUnique(nums,new boolean[nums.length],new LinkedList<Integer>());
        return result;
    }


    public void findUnique(int[] nums,boolean[] visited,LinkedList<Integer> trace) {
        //结束条件
        if (trace.size() == nums.length) {
            result.add(new LinkedList<>(trace));
            return;
        }
        //选择列表
        for (int i = 0;i < nums.length; i++) {
            //选择过的不需要放入
            if (visited[i]) {
                continue;
            }
            //接下来，如果当前节点与他的前一个节点一样，并其他的前一个节点已经被遍历过了，那我们也就不需要了。
            if (i < 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                break;
            }
            //做出选择
            trace.add(nums[i]);
            visited[i] = true;
            findUnique(nums,visited,trace);
            //撤销选择
            trace.removeLast();
            visited[i] = false;
        }
    }
}
