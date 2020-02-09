package ngerasimenko.citecktesttask.regexp;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RegexpBracketsValidator implements RegexpValidator {
    private static final Map<Character, Character> BRACKETS_MATCH_MAP = Map.of(
            '[', ']',
            '(', ')'
    );
    private static final Set<Character> OPENING_BRACKETS = Set.copyOf(BRACKETS_MATCH_MAP.keySet());
    private static final Set<Character> CLOSING_BRACKETS = Set.copyOf(BRACKETS_MATCH_MAP.values());

    private static boolean isOpeningBracket(Character c) {
        return OPENING_BRACKETS.contains(c);
    }

    private static boolean isClosingBracket(Character c) {
        return CLOSING_BRACKETS.contains(c);
    }

    @Nullable
    private static Character getMatchingOpeningBracket(Character c) {
        for (Map.Entry<Character, Character> entry : BRACKETS_MATCH_MAP.entrySet()) {
            if (Objects.equals(entry.getValue(), c)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public boolean validate(@NonNull String pattern) {
        Deque<Character> bracketsQueue = new ArrayDeque<>();

        for (char c : pattern.toCharArray()) {
            if (isOpeningBracket(c)) {
                bracketsQueue.add(c);
            } else if (isClosingBracket(c)) {
                Character lastOpenedBracket = bracketsQueue.peekLast();
                if (Objects.equals(lastOpenedBracket, getMatchingOpeningBracket(c))) {
                    bracketsQueue.pollLast();
                } else {
                    return false;
                }
            }
        }

        return bracketsQueue.isEmpty();
    }
}

