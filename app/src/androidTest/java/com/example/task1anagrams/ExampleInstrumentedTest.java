package com.example.task1anagrams;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Rule;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);
    @Test

    public void clickButtonReverse() {
        String[] inputText = {"Foxminded", "Foxminded cool 24/7", "a1bcd efg!h"};
        String[] exceptions = {"x", "xl", ""};
        String[] results = {"dexdnimoF", "dexdnimoF oocl 7/42", "d1cba hgf!e"};
        for (int i = 0; i < inputText.length; i++) {
            onView(withId(R.id.edt_exception_symbols)).perform(clearText());
            onView(withId(R.id.edt_input_text)).perform(clearText());
            onView(withId(R.id.edt_exception_symbols)).perform(typeText(exceptions[i]), closeSoftKeyboard());
            onView(withId(R.id.edt_input_text)).perform(typeText(inputText[i]), closeSoftKeyboard());
            onView(withId(R.id.btn_convert)).perform(click());
            onView(withId(R.id.txt_reverse)).check(matches(withText(results[i])));
        }
    }

}


