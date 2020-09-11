package langtest;

import java.util.BitSet;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/7 16:18
 */
public class BitSetTest {

    public static void main(String[] args) {
        BitSetTest bitSetTest = new BitSetTest();
        bitSetTest.testBitSet();
    }

    public void testBitSet() {
        BitSet bitSet = new BitSet(20);
        bitSet.set(2);
        bitSet.set(5);
        bitSet.set(9);
        System.out.println(bitSet.get(2) + " " + bitSet.get(3));
        System.out.println(bitSet.cardinality());
    }
}
