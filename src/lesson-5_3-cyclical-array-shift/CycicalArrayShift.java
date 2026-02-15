import java.util.Arrays;

public class CycicalArrayShift {

    public static void main(String[] args) {
        CycicalArrayShift cycicalArrayShift = new CycicalArrayShift();
        int[] array = { 1, 5, 3, 6, 9 };
        cycicalArrayShift.call(array, 3);
        System.out.println(Arrays.toString(array)); // [9, 6, 3, 5, 1]
    }

    void call(int[] array, int n) {
        int shift = n % array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, shift - 1);
        reverse(array, shift, array.length - 1);

    }

    void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

}
