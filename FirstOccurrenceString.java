import java.util.Scanner;

public class FirstOccurrenceString {
        // haystack = "satbutsad",
        // needle = "sad"
        /**haystack = "satsatsad", i = 2
         * needle = "sad", n = 2
         * sadbutsad 
         * sa 
         * 
         * 
         */

         /**
          * 
          * A A A C A A A A 
          *
          */
    public static void main(String[] args) { 
        Scanner inputStream = new Scanner(System.in);
        // String hayStack = inputStream.nextLine();
        // String needle = inputStream.nextLine();
        String hayStack = "abc" + new String(new char[10000]).replace("\0", "d") + "efg";
        String needle = "efg";
        inputStream.close();
        int indexOfFirstOccurrence = 0;
        // System.out.println("start of KMP : " + System.currentTimeMillis());
        // int indexOfFirstOccurrence = findFirstIndexOfNeedleInHayStackByKMP(hayStack,needle);
        // System.out.println(indexOfFirstOccurrence);
        // System.out.println("end of KMP : " + System.currentTimeMillis());
        // System.out.println();
        // System.out.println();
        // System.out.println("start of Naive : " + System.currentTimeMillis());
        // indexOfFirstOccurrence = findFirstIndexOfNeedleInHayStack(hayStack,needle);
        // System.out.println(indexOfFirstOccurrence);
        // System.out.println("end of Naive : " + System.currentTimeMillis());
        indexOfFirstOccurrence =  strStr(hayStack,needle);
        System.out.println(indexOfFirstOccurrence);
    }
    private static int findFirstIndexOfNeedleInHayStack(String hayStack,String needle){
        int indexOfFirstOccurrence = -1;
        if(hayStack.length() == 0 || needle.length() == 0 || hayStack.length() < needle.length()){
            return indexOfFirstOccurrence;
        }
        for(int indexOfHay = 0; indexOfHay < hayStack.length()-needle.length() + 1; indexOfHay++){
            if(hayStack.charAt(indexOfHay) == needle.charAt(0)){
                int tempIndex = indexOfHay;
                for(int indexOfNeedle=0;indexOfNeedle < needle.length();indexOfNeedle++){
                    if(hayStack.charAt(tempIndex) != needle.charAt(indexOfNeedle)){
                        break;
                    }
                    tempIndex++;
                }
                if(tempIndex-indexOfHay == needle.length()){
                    return indexOfHay;
                }
            }
        }
        return indexOfFirstOccurrence;
    }

    private static int findFirstIndexOfNeedleInHayStackByKMP(String hayStack,String pattern){
        int indexOfFirstOccurrence = -1;
        if(hayStack.length() == 0 || pattern.length() == 0 || hayStack.length() < pattern.length()){
            return indexOfFirstOccurrence;
        }
        int[] longestPrefixSuffix = new int[pattern.length()];
        populateLongestPrefixSuffixList(longestPrefixSuffix,pattern);
        int indexOfHay = 0;
        int indexOfPattern = 0;
        while((hayStack.length()-indexOfHay) >= (pattern.length()-indexOfPattern)){
            if(hayStack.charAt(indexOfHay) == pattern.charAt(indexOfPattern)){
                indexOfPattern++;
                indexOfHay++;
            }
            if(indexOfPattern == pattern.length()){
                return indexOfHay-indexOfPattern;
            }
            else if(indexOfHay < hayStack.length() && pattern.charAt(indexOfPattern) != hayStack.charAt(indexOfHay)){
                if(indexOfPattern != 0){
                    indexOfPattern = longestPrefixSuffix[indexOfPattern-1];
                }else{
                    indexOfHay++;
                }
            }
        }
        return indexOfFirstOccurrence;
    }

    private static void populateLongestPrefixSuffixList(int[] longestPrefixSuffix,String pattern){
        int lpsLength = 0;
        int indexOfPattern = 1;
        longestPrefixSuffix[lpsLength] = 0;
        while(indexOfPattern < pattern.length()){
            if(pattern.charAt(indexOfPattern) == pattern.charAt(lpsLength)){
                lpsLength++;
                longestPrefixSuffix[indexOfPattern] = lpsLength;
                indexOfPattern++;
            }else{
                if(lpsLength != 0 ){
                    lpsLength = longestPrefixSuffix[lpsLength-1];
                }else{
                    longestPrefixSuffix[indexOfPattern] = lpsLength;
                    indexOfPattern++;
                }
            }
        }
    }

    private static int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        int nIndex = 0;
        for(int i=0; i<hLen; i++){
            // as long as the characters are equal, increment needleIndex
            if(haystack.charAt(i)==needle.charAt(nIndex)){
                nIndex++;
            }
            else{
                // start from the next index of previous start index
                i=i-nIndex;
                // needle should start from index 0
                nIndex=0;
            }
            // check if needleIndex reached needle length
            if(nIndex==nLen){
                // return the first index
                return i-nLen+1;
            }
        }
        return -1;
    }

}
