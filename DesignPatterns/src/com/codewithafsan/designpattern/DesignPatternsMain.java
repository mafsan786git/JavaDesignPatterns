package com.codewithafsan.designpattern;

public class DesignPatternsMain {
    public static void main(String[] args) {
        TaxCalculator taxCalculator = getTaxCalculator();
        System.out.println(taxCalculator.calculateTax());
    }

    private static TaxCalculator getTaxCalculator() {
        return new TaxCalculator2019();
    }
}
