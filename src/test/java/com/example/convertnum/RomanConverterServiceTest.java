package com.example.convertnum;

import com.example.convertnum.service.RomanConverterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class RomanConverterServiceTest {

    @Autowired
    RomanConverterService romanConverterService;

    @Test
    public void prepareStringTest() {
        String testingString = " TesT ";
        assertThat(romanConverterService.prepareString(testingString)
                .equals("test"));
    }

    @Test
    public void validateEmptyRomanTest() {
        String testingString = "";
        assertThat(romanConverterService.validateRoman(testingString)).isFalse();
    }

    @Test
    public void validateInvalidRomanTest() {
        String testingString = "012";
        assertThat(romanConverterService.validateRoman(testingString)).isFalse();
    }

    @Test
    public void validateValidRomanTest() {
        String testingString = "mdcclxiii";
        assertThat(romanConverterService.validateRoman(testingString)).isTrue();
    }

    @Test
    public void checkInvalidRepetitionsITest() {
        String testingString = "iiii";
        assertThat(romanConverterService.checkInvalidRepetitions(testingString)).isFalse();
    }

    @Test
    public void checkInvalidRepetitionsVTest() {
        String testingString = "vv";
        assertThat(romanConverterService.checkInvalidRepetitions(testingString)).isFalse();
    }
}
