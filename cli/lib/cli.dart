class ArrayShift {
  static int removeElementAtIndex(List<int> array, int index) {
    for (int i = index + 1; i < array.length; i++) {
      array[i - 1] = array[i];
    }
    return array.length - 1;
  }

  static int removeDuplicates(List<int> array) {
    int length = array.length;
    int i = 0;
    while (i < length) {
      bool isFound = false;
      for (int k = i + 1; k < length; k++) {
        if (array[i] == array[k]) {
          isFound = true;
          break;
        }
      }

      if (isFound == false) {
        i++;
        continue;
      } else {
        for (int j = i + 1; j < length; j++) {
          array[j - 1] = array[j];
        }
        length--;
      }
    }
    array.length = length;
    return length;
  }
}

void main() {
  final array = [1, 2, 3, 4, 5, 10, 22, 33, 44, 55, 66, 77, 88, 99, 100];
  final length = ArrayShift.removeElementAtIndex(array, 10);
  // print(length);
  // print(array);

  final assignations = [1, 1, 1, 4, 5, 1, 6, 7, 8, 9, 10, 1];
  final assignationsLength = ArrayShift.removeDuplicates(assignations);
  print(assignations);
}
