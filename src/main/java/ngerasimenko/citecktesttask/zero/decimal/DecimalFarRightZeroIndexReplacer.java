package ngerasimenko.citecktesttask.zero.decimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("index")
public class DecimalFarRightZeroIndexReplacer implements DecimalFarRightZeroReplacer {

    private static String replaceZeroWithIndex(String str, int index) {
        return str.substring(0, index) + "1" + str.substring(index + 1);
    }

    public int replace(int number) {
        String numStr = Integer.toString(number);
        int indexOfZero = numStr.lastIndexOf("0");
        if (indexOfZero == -1) {
            return number;
        }
        String resultStr = replaceZeroWithIndex(numStr, indexOfZero);
        return Integer.parseInt(resultStr);
    }
}
