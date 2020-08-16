import java.util.Arrays;

public class Rotate {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] reverse = reverse(nums, 0, nums.length - 1);
        int[] reverse1 = reverse(nums, 0, k - 1);
        int[] reverse2 = reverse(nums, k, nums.length - 1);
        String string = Arrays.toString(reverse);
        String string1 = Arrays.toString(reverse1);
        String string2 = Arrays.toString(reverse2);
        System.out.println(string);
        System.out.println(string1);
        System.out.println(string2);
    }

    public int [] reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6,7};
        int k = 3;
        Rotate r = new Rotate();
        r.rotate(a,3);
    }
}
