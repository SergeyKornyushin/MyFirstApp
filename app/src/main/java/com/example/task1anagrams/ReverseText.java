package com.example.task1anagrams;

import android.text.TextUtils;
import java.util.ArrayList;

public class ReverseText extends MainActivity {

    public static int exceptionIndex = 0;
    public static String exceptionsString = "";

    public String reverseText(String myString) {
        ArrayList<Character> listFinal = new ArrayList<>();

        char[] allExceptionsArray = exceptionsString.toCharArray();
        ArrayList<Character> listExceptions = new ArrayList<>();

        for (char exceptionSymbol : allExceptionsArray) {
            listExceptions.add(exceptionSymbol);
        }

        String[] splitWords = myString.split(" ");

        for (String word : splitWords) {

            char[] inputTextToArray = word.toCharArray();
            ArrayList<Character> listInput = new ArrayList<>();

            for (char inputSymbol : inputTextToArray) {
                listInput.add(inputSymbol);
            }

            exceptionIndex = 0;
            int startIndex = 0;
            int lastIndex = listInput.size() - 1;
            outer:
            while (startIndex < lastIndex) {
                char tempFirst = listInput.get(startIndex);
                inner:
                while (lastIndex > startIndex) {
                    char tempLast = listInput.get(lastIndex);
                    if (listExceptions.size() == 0) {
                        listInput.remove(startIndex);
                        listInput.add(startIndex, tempLast);
                        listInput.remove(lastIndex);
                        listInput.add(lastIndex, tempFirst);
                        startIndex++;
                        lastIndex--;
                        continue outer;
                    }
                    while (exceptionIndex < listExceptions.size()) {
                        if (listExceptions.get(exceptionIndex) == tempFirst) {
                            startIndex++;
                            exceptionIndex = 0;
                            continue outer;
                        } else if (listExceptions.get(exceptionIndex) == tempLast) {
                            lastIndex--;
                            exceptionIndex = 0;
                            continue inner;
                        } else {
                            if (exceptionIndex != listExceptions.size() - 1) {
                                exceptionIndex++;
                            } else {
                                listInput.remove(startIndex);
                                listInput.add(startIndex, tempLast);
                                listInput.remove(lastIndex);
                                listInput.add(lastIndex, tempFirst);
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
            listFinal.addAll(listInput);
            listFinal.add(' ');
        }
        return TextUtils.join("", listFinal);
    }

    public String addExceptionSymbol(char[] inputTextToArray) {
        ArrayList<Character> listOfExceptions = new ArrayList<Character>();
        StringBuilder tempExceptionString = new StringBuilder();

        for (char c : inputTextToArray) {
            if (c != ' ') {
                tempExceptionString.append(c);
            }
        }
        char[] exceptions = tempExceptionString.toString().toCharArray();

        for (char exception : exceptions) {
            if (!listOfExceptions.contains(exception)) {
                listOfExceptions.add(exception);
            }
        }
        exceptionsString = TextUtils.join("", listOfExceptions);
        return exceptionsString;
    }

    public void clearExceptions() {
        exceptionsString = "";
        exceptionIndex = 0;
    }

}
