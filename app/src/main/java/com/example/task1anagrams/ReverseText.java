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
            ArrayList<Character> listInput = new ArrayList<>();

            for (char inputSymbol : wordArray) {
                listInput.add(inputSymbol);
            }

            int exceptionIndex = 0;
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

}
