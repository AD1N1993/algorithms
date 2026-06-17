public class WatterWalls {

    public static void main(String[] args) {
        WatterWalls getMaxArea = new WatterWalls();
        int[] walls = { 2, 6, 7, 3, 5, 7, 4 };
        int result = getMaxArea.call(walls);
        System.out.println(result); // [9, 6, 3, 5, 1]
    }

    int call(int[] array) {
       int left = 0;
       int right = array.length - 1;
       int max = 0;

       while (left < right) {
        int width = right - left;
        int height = Math.min(array[left],array[right]);
        max = Math.max(max, height * width);
        if(array[left]<array[right]) left ++;
        else right--;
       }


       return max;
    }

}
