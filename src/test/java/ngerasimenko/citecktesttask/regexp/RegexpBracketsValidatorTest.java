package ngerasimenko.citecktesttask.regexp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RegexpBracketsValidatorTest {
    private final RegexpValidator regexpValidator;

    @Autowired
    public RegexpBracketsValidatorTest(RegexpValidator regexpValidator) {
        this.regexpValidator = regexpValidator;
    }

    @Test
    public void validateEmptyString() {
        String pattern = "";
        assertTrue(regexpValidator.validate(pattern));
    }

    @Test
    public void validateSimplePatternsWithSingleBrackets() {
        String pattern1 = "()";
        String pattern2 = "[]";
        assertTrue(regexpValidator.validate(pattern1), errorMessage(pattern1));
        assertTrue(regexpValidator.validate(pattern1), errorMessage(pattern2));
    }

    @Test
    public void validateSimplePatterns() {
        String pattern1 = "[]()";
        String pattern2 = "()[]";
        String pattern3 = "()[]()[]";
        assertTrue(regexpValidator.validate(pattern1), errorMessage(pattern1));
        assertTrue(regexpValidator.validate(pattern2), errorMessage(pattern2));
        assertTrue(regexpValidator.validate(pattern3), errorMessage(pattern3));
    }

    @Test
    public void validateSimpleNestedPatterns() {
        String pattern1 = "([])";
        String pattern2 = "[()]";
        assertTrue(regexpValidator.validate(pattern1), errorMessage(pattern1));
        assertTrue(regexpValidator.validate(pattern2), errorMessage(pattern2));
    }

    @Test
    public void validateComplexNestedPatterns() {
        String pattern1 = "([[]([])()])";
        String pattern2 = "([][[]()])";
        assertTrue(regexpValidator.validate(pattern1), errorMessage(pattern1));
        assertTrue(regexpValidator.validate(pattern2), errorMessage(pattern2));
    }

    @Test
    public void validateInvalidPatterns() {
        String pattern1 = "(";
        String pattern2 = ")";
        String pattern3 = "[";
        String pattern4 = "]";
        String pattern5 = ")(";
        String pattern6 = "][";
        String pattern7 = "[(])";
        String pattern8 = "([)]";
        String pattern9 = "([][[(]())]";
        assertFalse(regexpValidator.validate(pattern1), errorMessage(pattern1));
        assertFalse(regexpValidator.validate(pattern2), errorMessage(pattern2));
        assertFalse(regexpValidator.validate(pattern3), errorMessage(pattern3));
        assertFalse(regexpValidator.validate(pattern4), errorMessage(pattern4));
        assertFalse(regexpValidator.validate(pattern5), errorMessage(pattern5));
        assertFalse(regexpValidator.validate(pattern6), errorMessage(pattern6));
        assertFalse(regexpValidator.validate(pattern7), errorMessage(pattern7));
        assertFalse(regexpValidator.validate(pattern8), errorMessage(pattern8));
        assertFalse(regexpValidator.validate(pattern9), errorMessage(pattern9));
    }

    @Test
    public void validateValidPatternsWithContent() {
        String pattern1 = "()content";
        String pattern2 = "(content)";
        String pattern3 = "content(content)";
        assertTrue(regexpValidator.validate(pattern1), errorMessage(pattern1));
        assertTrue(regexpValidator.validate(pattern2), errorMessage(pattern2));
        assertTrue(regexpValidator.validate(pattern3), errorMessage(pattern3));
    }

    private String errorMessage(String pattern) {
        return "Invalid result for pattern " + pattern;
    }
}