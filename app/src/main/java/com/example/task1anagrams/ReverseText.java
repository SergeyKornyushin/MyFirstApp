package com.example.task1anagrams;

public class ReverseText {

    public static String reverseString(String inputText, String inputExceptions){
        StringBuilder finalString = new StringBuilder();

        String[] splitWords = inputText.split(" ");
        for (String word : splitWords){
            finalString.append(reverseWord(word, inputExceptions)).append(" ");
        } return finalString.toString();
    }

    public static String reverseWord(String word, String exceptions) {

        char[] wordArray = word.toCharArray();
        char[] exceptionsArray = exceptions.toCharArray();

        int exceptionIndex = 0;
        int startIndex = 0;
        int lastIndex = wordArray.length - 1;
        outer:
        while (startIndex < lastIndex) {
            char tempFirst = wordArray[startIndex];
            inner:
            while (lastIndex > startIndex) {
                char tempLast = wordArray[lastIndex];
                if (exceptionsArray.length == 0) {
                    wordArray[startIndex] = tempLast;
                    wordArray[lastIndex] = tempFirst;
                    startIndex++;
                    lastIndex--;
                    continue outer;
                }
                while (exceptionIndex < exceptionsArray.length) {
                    if (exceptionsArray[exceptionIndex] == tempFirst) {
                        startIndex++;
                        exceptionIndex = 0;
                        continue outer;
                    } else if (exceptionsArray[exceptionIndex] == tempLast) {
                        lastIndex--;
                        exceptionIndex = 0;
                        continue inner;
                    } else {
                        if (exceptionIndex != exceptionsArray.length - 1) {
                            exceptionIndex++;
                        } else {
                            wordArray[startIndex] = tempLast;
                            wordArray[lastIndex] = tempFirst;
                            startIndex++;
                            lastIndex--;
                            exceptionIndex = 0;
                            continue outer;
                        }
                    }
                }
                lastIndex--;
            }
            startIndex++;
        }
        return String.valueOf(wordArray);
    }
}
