package ngerasimenko.citecktesttask.zero;

import ngerasimenko.citecktesttask.zero.decimal.DecimalFarRightZeroIndexReplacer;
import ngerasimenko.citecktesttask.zero.decimal.DecimalFarRightZeroRegexpReplacer;
import ngerasimenko.citecktesttask.zero.decimal.DecimalFarRightZeroReplacer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@SpringBootTest
@TestInstance(PER_CLASS)
public class DecimalFarRightZeroReplacerTest {
    private DecimalFarRightZeroRegexpReplacer farRightZeroRegexpReplacer;
    private DecimalFarRightZeroIndexReplacer farRightZeroIndexReplacer;

    @Autowired
    public DecimalFarRightZeroReplacerTest(DecimalFarRightZeroRegexpReplacer farRightZeroRegexpReplacer,
                                           DecimalFarRightZeroIndexReplacer farRightZeroIndexReplacer) {
        this.farRightZeroRegexpReplacer = farRightZeroRegexpReplacer;
        this.farRightZeroIndexReplacer = farRightZeroIndexReplacer;
    }


    private Collection<DecimalFarRightZeroReplacer> replacers() {
        return Arrays.asList(
                farRightZeroRegexpReplacer,
                farRightZeroIndexReplacer
        );
    }

    @ParameterizedTest
    @MethodSource("replacers")
    public void zeroNumTest(DecimalFarRightZeroReplacer decimalFarRightZeroReplacer) {
        int zero = 0;
        assertEquals(1, decimalFarRightZeroReplacer.replace(zero));
    }

    @ParameterizedTest
    @MethodSource("replacers")
    public void numWithoutZerosTest(DecimalFarRightZeroReplacer decimalFarRightZeroReplacer) {
        int startStr = 234234234;
        assertEquals(startStr, decimalFarRightZeroReplacer.replace(startStr));
    }

    @ParameterizedTest
    @MethodSource("replacers")
    public void numWithOneZeroTest(DecimalFarRightZeroReplacer decimalFarRightZeroReplacer) {
        int startStr = 234232034;
        assertEquals(234232134, decimalFarRightZeroReplacer.replace(startStr));
    }

    @ParameterizedTest
    @MethodSource("replacers")
    public void numWithLastZeroTest(DecimalFarRightZeroReplacer decimalFarRightZeroReplacer) {
        int startStr = 234232030;
        assertEquals(234232031, decimalFarRightZeroReplacer.replace(startStr));
    }

    @ParameterizedTest
    @MethodSource("replacers")
    public void numWithMultipleZerosTest(DecimalFarRightZeroReplacer decimalFarRightZeroReplacer) {
        int startStr = 230232034;
        assertEquals(230232134, decimalFarRightZeroReplacer.replace(startStr));
    }
}