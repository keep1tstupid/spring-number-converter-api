package com.example.convertnum;

import com.example.convertnum.service.ArabConverterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ArabConverterServiceTest {

    @Autowired
    ArabConverterService arabConverterService;

    @Test
    public void prepareValidNumberTest() {
        String number1 = "123";
        String number2 = "3500";
        assertThat(arabConverterService.prepareNumber(number1)).isEqualTo(123);
        assertThat(arabConverterService.prepareNumber(number2)).isEqualTo(3500);
    }

    @Test
    public void prepareInvalidNumberTest() {
        String number1 = "5000";
        String number2 = "-10";
        assertThat(arabConverterService.prepareNumber(number1)).isEqualTo(0);
        assertThat(arabConverterService.prepareNumber(number2)).isEqualTo(0);
    }

    @Test
    public void handleExceptionalCasesTest() {
        assertThat(arabConverterService.handleExceptionalCases(4, 'i', 'v', 'x')
                .equals("iv"));
        assertThat(arabConverterService.handleExceptionalCases(6, 'i', 'v', 'x')
                .equals("vi"));
        assertThat(arabConverterService.handleExceptionalCases(9, 'i', 'v', 'x')
                .equals("ix"));
    }

    @Test
    public void convertTest() {
        assertThat(arabConverterService.convert(123).equals("CXXIII"));
        assertThat(arabConverterService.convert(2564).equals("MMDLXIV"));
    }
}
