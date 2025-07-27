package ru.iteco.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.core.AllOf.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public static ViewInteraction openNewsBtn = onView(withId(R.id.expand_material_button));


    public static ViewInteraction allNewsText = onView(
            allOf(withId(R.id.all_news_text_view), withText("ALL NEWS")));


    public static ViewInteraction allNewsBtn = onView(
            allOf(withId(R.id.all_news_text_view), withText("ALL NEWS")));


    public static ViewInteraction newsFeedTitle = onView(withId(R.id.container_list_news_include_on_fragment_main));

}
