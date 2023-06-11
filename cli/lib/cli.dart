class BinarySearch {
  static int binarySearch(List<int> array, int search) {
    int left = 0;
    int right = array.length - 1;
    int middle = ((left + right) / 2).floor();

    while (left <= right) {
      if (array[middle] < search) {
        left = middle + 1;
      } else if (middle > search) {
        right = middle - 1;
      } else {
        return middle;
      }
    }
    return -1;
  }
}

void main() {
  final index = BinarySearch.binarySearch(
      [1, 2, 3, 4, 5, 10, 22, 33, 44, 55, 66, 77, 88, 99, 100], 10);

  print(index);
}
