package ru.iteco.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.core.AllOf.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public ViewInteraction openNewsBtn;
    public ViewInteraction allNewsText;
    public ViewInteraction allNewsBtn;
    public ViewInteraction newsFeedTitle;

    public MainPage() {
        openNewsBtn = onView(withId(R.id.expand_material_button));
        allNewsText = onView(
                allOf(withId(R.id.all_news_text_view), withText("ALL NEWS")));
        allNewsBtn = onView(
                allOf(withId(R.id.all_news_text_view), withText("ALL NEWS")));
        newsFeedTitle = onView(withId(R.id.container_list_news_include_on_fragment_main));


    }


}
