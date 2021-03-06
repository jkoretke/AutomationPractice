package com.example.jeffreykoretke.automationpractice;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import android.support.test.rule.ActivityTestRule;

import static android.support.test.espresso.Espresso.onView;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    private String textBefore, textAfter, inputString;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        textBefore = "Not Changed";
        textAfter = "Changed!";
        inputString = "TURTLE!";
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.jeffreykoretke.automationpractice", appContext.getPackageName());
    }

    /**
     * check intial state of textview
     */
    @Test
    public void checkTextView(){

        onView(withId(R.id.textView)).check(matches(withText(textBefore)));

    }

    /**
     * click button and check that textview was updated with new text
     */
    @Test
    public void clickButtonAndCheckTextView(){

        onView(withId(R.id.change_text_btn)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText(textAfter)));
    }

    /**
     * Enter text, click button and check that the text is displayed
     */
    @Test
    public void inputOutputText(){
        onView(withId(R.id.input_text)).perform(typeText(inputString), closeSoftKeyboard());
        onView(withText("display text")).perform(click());
        onView(withId(R.id.display_text_view)).check(matches(withText(inputString)));
    }
}
