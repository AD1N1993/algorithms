//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BitBasicsDemo {
    public static void main(String[] args) throws Exception {
        BitOperations bitOperations = new BitOperations();

        System.out.println(bitOperations.setBit(22, 5));
        System.out.println(bitOperations.unsetBit(22, 5));
        System.out.println(bitOperations.inverseBit(22, 5));
        System.out.println(bitOperations.isSetBit(22, 1));
        System.out.println(bitOperations.swap(-1096045653));
        System.out.println(bitOperations.getCountDifExample1(22, 23));
        System.out.println(bitOperations.getCountDifExample2(22, 23));
        bitOperations.demonstrateShifts(10);
        bitOperations.demonstrateArithmeticShift(10, 2);

        IntBitVector bitVector = new IntBitVector(96);
        bitVector.setBit(70);
        System.out.println(bitVector.isSetBit(70));
    }
}
