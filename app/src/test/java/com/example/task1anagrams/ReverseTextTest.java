package com.example.task1anagrams;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseTextTest {

    @Test
    public void reverse_string_correct_working() {
        String[] inputText = {"Foxminded", "Foxminded cool 24/7", "a1bcd efg!h"};
        String[] exceptions = {"x", "xl", ""};
        String[] results = {"dexdnimoF", "dexdnimoF oocl 7/42", "d1cba hgf!e"};
        for (int i = 0; i < inputText.length; i++){
            String actual = ReverseText.reverseString(inputText[i], exceptions[i]);
            assertEquals(results[i], actual);
        }
    }

    @Test (expected = NullPointerException.class)
    public void NULL_to_input_string(){
        ReverseText.reverseString(null, "x");
    }

    @Test (expected = NullPointerException.class)
    public void NULL_to_exception_string(){
        ReverseText.reverseString("Foxminded", null);
    }

}