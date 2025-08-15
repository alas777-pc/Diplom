package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;


import static ru.iteco.fmhandroid.data.WaitId.waitUntilElement;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.elements.LoveIsAllPage;

public class LoveIsAllStep {
    LoveIsAllPage loveIsAllPage = new LoveIsAllPage();


    public void openDiscription(int num) {
        Allure.step("Открытие описания циатат");
        waitUntilElement(loveIsAllPage.missionList);
        loveIsAllPage.clickOnQuote(num);
    }


    public void viewDiscription(int num) {
        Allure.step("Проверка отображения цитат");
        waitUntilElement(loveIsAllPage.missionDiscription);
        loveIsAllPage.openDiscription(num).check(matches(isDisplayed()));
    }
    public static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
