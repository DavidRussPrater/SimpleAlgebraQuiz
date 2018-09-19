package com.example.prate.quizapplication;

import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickOnQuestionOneEditText(){

        closeSoftKeyboard();
        onView(withId(R.id.answer_one_text)).perform(closeSoftKeyboard(), click());
        onView(withId(R.id.answer_one_text)).perform(typeText("10"));
    }

    @Test
    public void clickOnQuestionTwoCheckBoxes() {
        onView(withId(R.id.answer_one_text)).perform(click(), closeSoftKeyboard());
        closeSoftKeyboard();
        onView(withId(R.id.question_five)).perform(click());
        onView(withId(R.id.question_five)).perform(scrollTo());
        onView(withId(R.id.question_two_checkbox_one)).perform(click());
        onView(withId(R.id.question_two_checkbox_two)).perform(click());
        onView(withId(R.id.question_two_checkbox_three)).perform(click());
        onView(withId(R.id.question_two_checkbox_four)).perform(click());
        onView(withId(R.id.question_two_checkbox_two)).perform(click());
        onView(withId(R.id.question_two_checkbox_three)).perform(click());
    }

    @Test
    public void clickOnRadioGroupThreeQuestion() {
        closeSoftKeyboard();
        onView(withId(R.id.question_three_radio_group)).perform(scrollTo());
        onView(withId(R.id.question_three_radio_one)).perform(click());
        onView(withId(R.id.question_three_radio_two)).perform(click());
        onView(withId(R.id.question_three_radio_three)).perform(click());
        onView(withId(R.id.question_three_radio_four)).perform(click());
    }

    @Test
    public void clickOnQuestionFourEditText(){

        closeSoftKeyboard();
        onView(withId(R.id.answer_four_text)).perform(closeSoftKeyboard(), click());
        onView(withId(R.id.answer_four_text)).perform(typeText("24"));
    }

    @Test
    public void clickOnQuestionsFiveCheckBoxes() {
        onView(withId(R.id.answer_one_text)).perform(click(), closeSoftKeyboard());
        onView(withId(R.id.question_five_checkbox_one)).perform(click());
        onView(withId(R.id.question_five_checkbox_two)).perform(click());
        onView(withId(R.id.question_five_checkbox_three)).perform(click());
        onView(withId(R.id.question_five_checkbox_four)).perform(click());
        onView(withId(R.id.question_five_checkbox_four)).perform(click());
    }

    @Test
    public void clickOnRadioGroupSixQuestion() {
        onView(withId(R.id.answer_one_text)).perform(click(), closeSoftKeyboard());        closeSoftKeyboard();
        onView(withId(R.id.question_six_radio_one)).perform(scrollTo());
        onView(withId(R.id.question_six_radio_two)).perform(click());
        onView(withId(R.id.question_six_radio_three)).perform(click());
        onView(withId(R.id.question_six_radio_four)).perform(click());
        onView(withId(R.id.question_six_radio_two)).perform(click());
    }


    @Test
    public void checkAnswers() {
        onView(withId(R.id.answer_one_text)).perform(closeSoftKeyboard(), scrollTo());
        onView(withId(R.id.submit_answers)).perform(click());
    }


    @Test
    public void finalScoreAssertion() {

        clickOnQuestionOneEditText();
        clickOnQuestionTwoCheckBoxes();
        clickOnRadioGroupThreeQuestion();
        clickOnQuestionFourEditText();
        clickOnQuestionsFiveCheckBoxes();
        clickOnRadioGroupSixQuestion();
        checkAnswers();

    }
}