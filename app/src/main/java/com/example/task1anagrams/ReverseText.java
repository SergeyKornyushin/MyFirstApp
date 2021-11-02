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
            char tempLast = wordArray[lastIndex];
            if (exceptions.isEmpty()) {
                if (!Character.isLetter(tempFirst)) {
                    startIndex++;
                } else if (!Character.isLetter(tempLast)) {
                    lastIndex--;
                } else {
                    wordArray[startIndex] = tempLast;
                    wordArray[lastIndex] = tempFirst;
                    startIndex++;
                    lastIndex--;
                }
            } else if (exceptions.indexOf(tempFirst) != -1) {
                startIndex++;
            } else if (exceptions.indexOf(tempLast) != -1) {
                lastIndex--;
            } else {
                wordArray[startIndex] = tempLast;
                wordArray[lastIndex] = tempFirst;
                startIndex++;
                lastIndex--;
            }
        }
        return String.valueOf(wordArray);
    }
}



