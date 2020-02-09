package ngerasimenko.citecktesttask.zero;

import ngerasimenko.citecktesttask.zero.binary.BinaryFarRightZeroReplacer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BinaryFarRightZeroReplacerTest {
    private BinaryFarRightZeroReplacer zeroReplacer;

    @Autowired
    public BinaryFarRightZeroReplacerTest(BinaryFarRightZeroReplacer zeroReplacer) {
        this.zeroReplacer = zeroReplacer;
    }

    @Test
    public void zeroNumTest() {
        assertEquals(1, zeroReplacer.replace(0));
    }

    @Test
    public void noZeroNumTest() {
        int num = 0b1111;
        assertEquals(num, zeroReplacer.replace(num));
    }

    @Test
    public void singleZeroNumTest() {
        int num = 0b1101;
        assertEquals(0b1111, zeroReplacer.replace(num));
    }

    @Test
    public void multipleZeroNumTest() {
        int num = 0b1001;
        assertEquals(0b1011, zeroReplacer.replace(num));
    }
}