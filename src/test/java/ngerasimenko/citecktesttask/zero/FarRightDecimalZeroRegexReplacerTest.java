package ngerasimenko.citecktesttask.zero;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FarRightDecimalZeroRegexReplacerTest {
    private FarRightDecimalZeroRegexpReplacer farRightZeroReplacer;

    @Autowired
    FarRightDecimalZeroRegexReplacerTest(FarRightDecimalZeroRegexpReplacer farRightZeroReplacer) {
        this.farRightZeroReplacer = farRightZeroReplacer;
    }

    @Test
    public void zeroNumTest() {
        int zero = 0;
        assertEquals(1, farRightZeroReplacer.replace(zero));
    }

    @Test
    public void numWithoutZerosTest() {
        int startStr = 234234234;
        assertEquals(startStr, farRightZeroReplacer.replace(startStr));
    }

    @Test
    public void numWithOneZeroTest() {
        int startStr = 234232034;
        assertEquals(234232134, farRightZeroReplacer.replace(startStr));
    }

    @Test
    public void numWithLastZeroTest() {
        int startStr = 234232030;
        assertEquals(234232031, farRightZeroReplacer.replace(startStr));
    }

    @Test
    public void numWithMultipleZerosTest() {
        int startStr = 230232034;
        assertEquals(230232134, farRightZeroReplacer.replace(startStr));
    }
}