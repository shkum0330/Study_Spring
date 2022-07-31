package hello.typeconverter.formatter;

import hello.typeconverter.WebConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MyNumberFormatterTest {

    MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    void parse() throws ParseException {
        Number result=formatter.parse("1,000", Locale.KOREA);
        assertThat(result).isEqualTo(1000L);
    }

    @Test
    void print() {
        String result=formatter.print(1000,Locale.KOREA);
        assertThat(result).isEqualTo("1,000");
    }
}