public class IntBitVector {

    private int[] bitVector;

    private long maxIndex;

    IntBitVector(long bits) throws Exception {

        if (bits <= 0 || bits > 68719476704L) {
            throw new Exception("Bits must be between 1 and 68719476704");
        }

        maxIndex = bits - 1;

        int size = (int) (((bits - 1) >> 5) + 1);
        bitVector = new int[size];
    }

    void checkIndex(long index) throws Exception {
        if (index < 0 || index > maxIndex) {
            throw new Exception("Index must be between 0 and " + maxIndex);
        }
    }

    int getRow(long index) throws Exception {
        return (int) (index >> 5);

    }

    int getColumn(long index) throws Exception {
        return (int) (index % 32);
    }

    void setBit(long index) throws Exception {
        checkIndex(index);
        int row = getRow(index);
        int col = getColumn(index);
        int mask = 1 << col;
        bitVector[row] |= mask;
    }

    void unsetBit(long index) throws Exception {
        checkIndex(index);
        int row = getRow(index);
        int col = getColumn(index);
        int mask = ~(1 << col);
        bitVector[row] &= mask;
    }

    void inverseBit(long index) throws Exception {
        checkIndex(index);
        int row = getRow(index);
        int col = getColumn(index);
        int mask = 1 << col;
        bitVector[row] ^= mask;
    }

    boolean isSetBit(long index) throws Exception {
        checkIndex(index);
        int row = getRow(index);
        int col = getColumn(index);
        int mask = 1 << col;
        return (bitVector[row] & mask) != 0;
    }

}
