package ngerasimenko.citecktesttask.zero;

import org.springframework.stereotype.Component;

/**
 * Примем, что в бинарном числе смотрим только на значащую часть числа.
 * Таким образом в числе 0b1111 (0b0...0111) крайнего правого нуля нет.
 * Исключение - число 0, которое представлено только нулём (0b0)
 */
@Component
public class FarRightBinaryZeroReplacer {
    private static boolean onesOnly(int number) {
        return ((number + 1) & number) == 0;
    }

    public int replace(int number) {
        if (number > 0 && onesOnly(number)) {
            return number;
        }

        return number | (number + 1);
    }
}
