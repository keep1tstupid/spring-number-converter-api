package com.example.convertnum.service;

public interface ArabConverterService {
    public abstract int prepareNumber(String s);
    public abstract String convert(int number);
    public abstract String handleExceptionalCases(int number, char curr, char prev, char prev2);
}
