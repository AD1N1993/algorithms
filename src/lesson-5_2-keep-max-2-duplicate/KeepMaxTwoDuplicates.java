public class KeepMaxTwoDuplicates {

    public static void main(String[] args) {
        KeepMaxTwoDuplicates keepMaxTwoDuplicates = new KeepMaxTwoDuplicates();
        int[] array = { 1, 2, 2, 3, 3, 3, 4, 7, 7, 7 };
        int result = keepMaxTwoDuplicates.call(array);
        System.out.println(result); // 8
    }

    int call(int[] array) {
        if (array.length == 1)
            return 1;
        int L = 1;

        for (int R = 2; R < array.length; R++) {
            int val = array[R];

            if (val == array[L - 1]) {
                continue;
            }

            array[L + 1] = val;

            L++;
        }

        return L + 1;
    }
}
