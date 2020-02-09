package ngerasimenko.citecktesttask.zero;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class FarRightDecimalZeroRegexpReplacer {
    private static final Pattern PATTERN = Pattern.compile("0(?!.*0)");

    public int replace(int number) {
        String numStr = Integer.toString(number);
        String resultNumStr = PATTERN.matcher(numStr).replaceFirst("1");
        return Integer.parseInt(resultNumStr);
    }
}
