import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int [] digits = {4,3,2,1};
        PlusOne po = new PlusOne();
        int[] res = po.plusOne(digits);
        System.out.println(Arrays.toString(res));
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
