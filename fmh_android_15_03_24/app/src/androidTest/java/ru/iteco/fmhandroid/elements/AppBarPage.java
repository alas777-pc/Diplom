package ru.iteco.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.core.AllOf.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;

public class AppBarPage extends DataHelper {

    public static ViewInteraction navigationButton = onView(withId(R.id.main_menu_image_button));


    public static ViewInteraction navigationNews = onView(allOf(withId(android.R.id.title),
            withText("News")));


    public static ViewInteraction navigationAbout = onView(allOf(withId(android.R.id.title),
            withText("About")));


    public static ViewInteraction navigationMain = onView(allOf(withId(android.R.id.title),
            withText("Main")));


    public static ViewInteraction loveIsAllBtn = onView(
            allOf(withId(R.id.our_mission_image_button), withContentDescription("Our Mission")));


    public static ViewInteraction exitBtn = onView(withId(R.id.authorization_image_button));


    public static ViewInteraction logOut = onView(allOf(withId(android.R.id.title), withText("Log out")));
}
