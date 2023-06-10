class ArrayMax {
  static void main() {
    final uniqueNumbers = [];

    List<String> phoneNumbers = [
      '+791610002030',
      '+791612222030',
      '+791610003122',
      '+791610002030',
    ];

    for (var phoneNumber in phoneNumbers) {
      bool alreadyExist = false;
      for (var uniqueNumberItem in uniqueNumbers) {
        if (uniqueNumberItem == phoneNumber) {
          alreadyExist = true;
          break;
        }
      }
      if (alreadyExist == false) {
        uniqueNumbers.add(phoneNumber);
      }
    }
    print(uniqueNumbers);
  }
}

void main() {
  ArrayMax.main();
}
