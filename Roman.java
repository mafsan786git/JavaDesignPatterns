
import java.util.HashMap;
import java.util.Map;

public class Roman {
    public static void main(String[] arg) {
        int convertedNumber = romanToInt("MCMXCIV");
        System.out.println("Converted roman values : " + convertedNumber);
    }

    private static int romanToInt(String romanValues) {
        return convertRomanValuesInIntegerSecondSolution(romanValues);
    }

    // SOLUTION 1
    // time O(n)
    // space O(1)
    private static int convertRomanValuesInInteger(String romanValues, Map<String, Integer> romanToIntegerMap) {
        int convertedNumber = 0;
        for (int index = 0; index < romanValues.length(); index++) {
            String currentRoman = String.valueOf(romanValues.charAt(index));
            int currentNumber = romanToIntegerMap.get(currentRoman);
            if (index != romanValues.length() - 1) {
                currentRoman += romanValues.charAt(index + 1);
            }
            if (romanToIntegerMap.containsKey(currentRoman)) {
                currentNumber = romanToIntegerMap.get(currentRoman);
                index++;
            }
            convertedNumber += currentNumber;
        }
        return convertedNumber;
    }

    private static Map<String, Integer> createRomanToIntegerHashMap() {
        Map<String, Integer> romanToIntegerMap = new HashMap<>();
        romanToIntegerMap.put("I", 1);
        romanToIntegerMap.put("IV", 4);
        romanToIntegerMap.put("V", 5);
        romanToIntegerMap.put("IX", 9);
        romanToIntegerMap.put("X", 10);
        romanToIntegerMap.put("XL", 40);
        romanToIntegerMap.put("L", 50);
        romanToIntegerMap.put("XC", 90);
        romanToIntegerMap.put("C", 100);
        romanToIntegerMap.put("CD", 400);
        romanToIntegerMap.put("D", 500);
        romanToIntegerMap.put("CM", 900);
        romanToIntegerMap.put("M", 1000);
        return romanToIntegerMap;
    }

    // SECOND SOLUTION
    private static int convertRomanValuesInIntegerSecondSolution(String romanValues) {
        int convertedNumber = 0;
        for (int index = 0; index < romanValues.length(); index++) {
            if(index != romanValues.length()-1 && fetchIntegerValueWithRespectToRomanValue(romanValues.charAt(index)) < fetchIntegerValueWithRespectToRomanValue(romanValues.charAt(index+1))){
                convertedNumber -= fetchIntegerValueWithRespectToRomanValue(romanValues.charAt(index));
            }else {
                convertedNumber += fetchIntegerValueWithRespectToRomanValue(romanValues.charAt(index));
            }
        }
        return convertedNumber;
    }

    private static int fetchIntegerValueWithRespectToRomanValue(char romanValue) {
        switch (romanValue) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

}
