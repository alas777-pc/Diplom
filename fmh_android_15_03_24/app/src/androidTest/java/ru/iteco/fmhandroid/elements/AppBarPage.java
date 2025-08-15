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
    public ViewInteraction navigationButton;
    public ViewInteraction navigationNews;
    public ViewInteraction navigationAbout;
    public ViewInteraction navigationMain;
    public ViewInteraction loveIsAllBtn;
    public ViewInteraction exitBtn;
    public ViewInteraction logOut;
    public int appBarTitle;

    public AppBarPage() {
        navigationButton = onView(withId(R.id.main_menu_image_button));
        navigationNews = onView(allOf(withId(android.R.id.title),
                withText("News")));
        navigationAbout = onView(allOf(withId(android.R.id.title),
                withText("About")));
        navigationMain = onView(allOf(withId(android.R.id.title),
                withText("Main")));
        loveIsAllBtn = onView(
                allOf(withId(R.id.our_mission_image_button), withContentDescription("Our Mission")));
        exitBtn = onView(withId(R.id.authorization_image_button));
        logOut = onView(allOf(withId(android.R.id.title), withText("Log out")));
        appBarTitle = R.id.custom_app_bar_title_text_view;


    }


}
