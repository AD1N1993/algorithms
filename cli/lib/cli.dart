import 'dart:math';

class ArrayMax {
  static int findMaxUnderBoundary(
      {required List<int> array, required int topBoundary}) {

    int currentMax = -double.maxFinite.toInt();
    for (int i = 0; i < array.length; i++) {
      if (array[i] < topBoundary) {
        currentMax = max(currentMax, array[i]);
      }
    }

    return currentMax;
  }

  static List<int> findTopElements(
      {required List<int> array, required int numberOfElements}) {
    List<int> resList = List<int>.filled(numberOfElements, 0);
    int prevMax = double.maxFinite.toInt();
    for (int i = 0; i < numberOfElements; i++) {
      int currMax = findMaxUnderBoundary(array: array, topBoundary: prevMax);
      prevMax = currMax;
      resList[i] = currMax;
    }
    return resList;
  }
}

void main() {
  print(ArrayMax.findTopElements(
      array: [10, 40, 50, 60, 22, 11], numberOfElements: 3));
}
