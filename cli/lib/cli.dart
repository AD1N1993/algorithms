import 'dart:math';

class ArrayMax {
  static showMaxArrayValue() {
    List<int> values = [25, 5, 12, 44, 123, 1, 2];
    int maxValue = 0;
    for (int i = 0; i < values.length; i++) {
      maxValue = max(maxValue, values[i]);
    }
    print(maxValue);
  }
}

void main() {
  ArrayMax.showMaxArrayValue();
}
