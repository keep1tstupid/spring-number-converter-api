package com.example.convertnum.service;


public interface RomanConverterService {
    public abstract String prepareString(String s);
    public abstract boolean checkInvalidRepetitions(String s);
    public abstract boolean validateRoman(String s);
    public abstract int convert(String s);
}
