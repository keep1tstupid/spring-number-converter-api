package com.example.convertnum;

import com.example.convertnum.service.RomanConverterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ConverterServiceTest {

    @Autowired
    RomanConverterService converterService;

    @Test
    public void prepareStringTest() {
        String testingString = " TesT ";
        assertThat(testingString.toLowerCase().trim()
                .equals("test"));
    }

    @Test
    public void validateEmptyRomanTest() {
        String testingString = "";
        assertThat(converterService.validateRoman(testingString)).isFalse();
    }

    @Test
    public void validateInvalidRomanTest() {
        String testingString = "012";
        assertThat(converterService.validateRoman(testingString)).isFalse();
    }

    @Test
    public void validateValidRomanTest() {
        String testingString = "mdcclxiii";
        assertThat(converterService.validateRoman(testingString)).isTrue();
    }

    @Test
    public void checkInvalidRepetitionsITest() {
        String testingString = "iiii";
        assertThat(converterService.checkInvalidRepetitions(testingString)).isFalse();
    }

    @Test
    public void checkInvalidRepetitionsVTest() {
        String testingString = "vv";
        assertThat(converterService.checkInvalidRepetitions(testingString)).isFalse();
    }
}
