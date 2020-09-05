import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permutations {
    //回溯方式解决，列出所有的可能
    public List<List<Integer>> premute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums,len,0,path,used,res);
        return res;
    }

    public void dfs(int[] nums,int len, int depth,Deque<Integer> path,boolean[] used,List<List<Integer>> res) {
        if(depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0;i < len;i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("递归之前 =>" + path);
                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
                System.out.println("递归之后 =>" + path);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutations permutations = new Permutations();
        List<List<Integer>> lists = permutations.premute(nums);
        System.out.println(lists);
    }
}
