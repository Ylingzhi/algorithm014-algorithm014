//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 692 👎 0

public class MoveZero {

    //遍历迁移，补全零的方式
//    public void moveZeroes(int[] nums) {
//        //判空
//        if (nums == null || nums.length == 0) {
//            return;
//        }
//        //声明插入的零
//        int insertPos = 0;
//        //循环遍历非零的数
//        for (int num : nums) {
//            if (num !=0){
//                nums[insertPos++] = num;
//            }
//        }
//        //循环插入零补全数组
//        while (insertPos < nums.length) {
//            nums[insertPos++] = 0;
//        }
//    }

    public void moveZeroes(int[] nums) {
        //双指针
        //声明一个初始指针
        int pos = 0;
        //循环遍历元素
        for (int i =0;i<nums.length;i++) {
            //移动值不为零的元素
            if (nums[i] != 0) {
                if (i != pos) {
                    nums[pos] = nums[i];
                    nums[i] = 0;
                }
                pos++;
            }
        }
    }
}
