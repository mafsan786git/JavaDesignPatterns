public class LCPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    private static String longestCommonPrefix(String[] strs) {
        StringBuilder longestCommonPrefix = new StringBuilder();
        if (strs.length > 0) {
            String firstWord = strs[0];
            boolean charIsCommon = true;
            for (int index = 0; index < firstWord.length(); index++) {
                for (int i = 1; i < strs.length; i++) {
                    if(index >= strs[i].length() || strs[i].charAt(index) != firstWord.charAt(index)){
                        charIsCommon = false;
                        break;
                    }
                    strs[i].indexOf(firstWord);
                }
                if (charIsCommon) {
                    longestCommonPrefix.append(firstWord.charAt(index));
                }else {
                    break;
                }
            }
        }
        return longestCommonPrefix.toString();
    }
}