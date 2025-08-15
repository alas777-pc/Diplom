package ru.iteco.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

import static ru.iteco.fmhandroid.steps.LoveIsAllStep.childAtPosition;



import androidx.test.espresso.ViewInteraction;



import ru.iteco.fmhandroid.R;

public class LoveIsAllPage {
    public ViewInteraction loveIsAllText;
    public ViewInteraction recyclerView;
    public int missionImageButton;
    public int missionTitle;
    public int missionList;
    public int missionDiscription;

    public LoveIsAllPage() {
        loveIsAllText = onView(
                allOf(withId(R.id.our_mission_title_text_view), withText("Love is all")));
        recyclerView = onView(withId(R.id.our_mission_item_list_recycler_view));
        missionImageButton = R.id.our_mission_image_button;
        missionTitle = R.id.our_mission_title_text_view;
        missionList = R.id.our_mission_item_list_recycler_view;
        missionDiscription = R.id.our_mission_item_description_text_view;


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


}
