public class RemoveAllN {


    public static void main(String[] args) {
        RemoveAllN removeAllN = new RemoveAllN();
        int[] array = {1, 2, 3, 4, 5, 5, 5, 8, 9, 10};
        int n = 5;
        int result = removeAllN.removeAllN(array, n);
        System.out.println(result);
    }

    int removeAllN(int[] array, int n) {
        int L = 0;

        for (int R = 0; R < array.length; R++) {
            int val = array[R];

            if (val == n) {
                continue;
            }

            array[L] = val;
            L++;
        }

        return L;
    }
} 
