package com.example.task1anagrams;

public class ReverseText {

    public static String reverseString(String inputText, String inputExceptions) {
        StringBuilder finalString = new StringBuilder();

        String[] splitWords = inputText.split(" ");
        for (String word : splitWords) {
            finalString.append(reverseWord(word, inputExceptions)).append(" ");
        }
        return finalString.toString();
    }

    public static String reverseWord(String word, String exceptions) {

        char[] wordArray = word.toCharArray();

        int startIndex = 0;
        int lastIndex = wordArray.length - 1;

        while (startIndex < lastIndex) {
            char tempFirst = wordArray[startIndex];
            while (lastIndex > startIndex) {
                char tempLast = wordArray[lastIndex];
                if (exceptions.length() == 0) {
                    wordArray[startIndex] = tempLast;
                    wordArray[lastIndex] = tempFirst;
                    startIndex++;
                    lastIndex--;
                    break;
                } else if (exceptions.indexOf(tempFirst) != -1) {
                    startIndex++;
                    break;
                } else if (exceptions.indexOf(tempLast) != -1) {
                    lastIndex--;
                } else {
                    wordArray[startIndex] = tempLast;
                    wordArray[lastIndex] = tempFirst;
                    startIndex++;
                    lastIndex--;
                    break;
                }
            }
        }
        return String.valueOf(wordArray);
    }
}



