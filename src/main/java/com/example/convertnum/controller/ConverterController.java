package com.example.convertnum.controller;

import com.example.convertnum.service.ArabConverterService;
import com.example.convertnum.service.RomanConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/convert/")
public class ConverterController {

    @Autowired
    RomanConverterService romanConverterService;

    @Autowired
    ArabConverterService arabConverterService;

    @GetMapping("/roman-to-arab/{romanNum}")
    @ResponseBody
    public ResponseEntity convertRoman(@PathVariable String romanNum) {
        String preparedString = romanConverterService.prepareString(romanNum);
        if (romanConverterService.validateRoman(preparedString)) {
            return ResponseEntity.ok(romanConverterService.convert(preparedString));
        } else {
            return ResponseEntity.status(422).body("Provided value cannot be converted");
        }
    }

    @GetMapping("/arab-to-roman/{arabNum}")
    @ResponseBody
    public ResponseEntity converArab(@PathVariable String arabNum) {
        int preparedNum = arabConverterService.prepareNumber(arabNum);
        if (preparedNum != 0) {
            return ResponseEntity.ok(arabConverterService.convert(preparedNum));
        } else {
            return ResponseEntity.status(422).body("Provided value cannot be converted");
        }
    }
}