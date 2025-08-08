package ru.iteco.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;

public class LoveIsAllPage {
    public ViewInteraction loveIsAllText;
    public ViewInteraction recyclerView;

    public LoveIsAllPage() {
        loveIsAllText = onView(
                allOf(withId(R.id.our_mission_title_text_view), withText("Love is all")));
        recyclerView = onView(withId(R.id.our_mission_item_list_recycler_view));

    }


    public ViewInteraction openDiscription(int num) {
        int number = num - 1;
        return onView(allOf(withId(R.id.our_mission_item_description_text_view),
                withParent(withParent(childAtPosition(withId(R.id.our_mission_item_list_recycler_view), number)))));
    }


    public void clickOnQuote(int num) {
        int number = num - 1;
        onView(childAtPosition(withId(R.id.our_mission_item_list_recycler_view), number)).perform(click());
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
