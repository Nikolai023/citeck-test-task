package ngerasimenko.citecktesttask.zero.decimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@Qualifier("regexp")
public class DecimalFarRightZeroRegexpReplacer implements DecimalFarRightZeroReplacer {
    private static final Pattern PATTERN = Pattern.compile("0(?!.*0)");

    public int replace(int number) {
        String numStr = Integer.toString(number);
        String resultNumStr = PATTERN.matcher(numStr).replaceFirst("1");
        return Integer.parseInt(resultNumStr);
    }
}
