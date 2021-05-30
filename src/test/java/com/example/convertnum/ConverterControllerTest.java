package com.example.convertnum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ConverterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void convertValidRomanNumTest() throws Exception {
        String url = "/api/convert/roman-to-arab/" + "XIV";
        mockMvc.perform(get(url)).andExpect(status().isOk());
    }

    @Test
    public void convertInvalidRomanNumTest() throws Exception {
        String url = "/api/convert/roman-to-arab/" + "00h";
        mockMvc.perform(get(url)).andExpect(status().is4xxClientError());
    }

    @Test
    public void convertValidArabNumTest() throws Exception {
        String url = "/api/convert/arab-to-roman/" + "2647";
        mockMvc.perform(get(url)).andExpect(status().isOk());
    }

    @Test
    public void convertInvalidArabNumTest() throws Exception {
        String url = "/api/convert/arab-to-roman/" + "-6";
        mockMvc.perform(get(url)).andExpect(status().is4xxClientError());
    }
}
