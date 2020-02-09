package ngerasimenko.citecktesttask.regexp;

import org.springframework.lang.NonNull;

public interface RegexpValidator {
    boolean validate(@NonNull String pattern);
}
