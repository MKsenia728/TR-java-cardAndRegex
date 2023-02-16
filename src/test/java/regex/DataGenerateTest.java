package regex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.yaml.snakeyaml.parser.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class DataGenerateTest {
    DataGenerate dataGenerate = new DataGenerate();

    @RepeatedTest(name="Generate account", value=10)
    void generateAccountTest() {
        long res = dataGenerate.generateAccount();
        Pattern pattern = Pattern.compile("\\A[1-9]\\d{15}\\Z");
        Matcher matcher = pattern.matcher(String.valueOf(res));
        if (matcher.find())
            Assertions.assertEquals(Long.parseLong(matcher.group()), res, "Check account");
    }

    @RepeatedTest(name="Generate CVV", value=10)
    void generateCVVTest() {
        int res = dataGenerate.generateCVV();
        Pattern pattern = Pattern.compile("^[1-9]\\d{2}$");
        Matcher matcher = pattern.matcher(String.valueOf(res));
        if (matcher.find())
            Assertions.assertEquals(Integer.parseInt(matcher.group()), res, "Check CVV");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 12, 13})
    void generateMonthTestParam(int arg) {
        Pattern pattern = Pattern.compile("^[1-9][0-2]?$");
        Matcher matcher = pattern.matcher(String.valueOf(arg));
        if (matcher.find())
            Assertions.assertEquals(Integer.parseInt(matcher.group()), arg, "Check month");
    }

    @RepeatedTest(name="Generate month", value=10)
    void generateMonthTestMeth() {
        int res = dataGenerate.generateMonth();
        Pattern pattern = Pattern.compile("^[1-9][0-2]?$");
        Matcher matcher = pattern.matcher(String.valueOf(res));
        if (matcher.find())
            Assertions.assertEquals(Integer.parseInt(matcher.group()), res, "Check month");
    }

    @RepeatedTest(name="Generate year", value=10)
    void generateYear() {
        int res = dataGenerate.generateYear();
        Pattern pattern = Pattern.compile("^2[4-8]$");
        Matcher matcher = pattern.matcher(String.valueOf(res));
        if (matcher.find())
            Assertions.assertEquals(Integer.parseInt(matcher.group()), res, "Check year");
    }

    @RepeatedTest(name="Generate firstname", value=10)
    void generateFirstName() {
        Pattern pattern = Pattern.compile("^[A-Z][A-Za-z-']+$");
        String res = dataGenerate.generateFirstName();
        Matcher matcher = pattern.matcher(res);
        if (matcher.find())
            Assertions.assertEquals(matcher.group(), res, "Check firstname");
    }

    @RepeatedTest(name="Generate lastname", value=10)
    void generateLastName() {
        Pattern pattern = Pattern.compile("^[A-Z][A-Za-z-']+$");
        String res = dataGenerate.generateLastName();
        Matcher matcher = pattern.matcher(res);
        if (matcher.find())
            Assertions.assertEquals(matcher.group(), res, "Check lastname");
    }
}