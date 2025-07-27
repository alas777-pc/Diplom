package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.data.WaitId.waitUntilElement;
import static ru.iteco.fmhandroid.elements.AppBarPage.exitBtn;
import static ru.iteco.fmhandroid.elements.AppBarPage.logOut;
import static ru.iteco.fmhandroid.elements.AppBarPage.loveIsAllBtn;
import static ru.iteco.fmhandroid.elements.AppBarPage.navigationAbout;
import static ru.iteco.fmhandroid.elements.AppBarPage.navigationButton;

import static ru.iteco.fmhandroid.elements.AppBarPage.navigationNews;
import static ru.iteco.fmhandroid.elements.LoveIsAllPage.loveIsAllText;


import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;

public class AppBarStep extends DataHelper {

    public static void clickNavigationBtn() {
        waitUntilElement(R.id.custom_app_bar_title_text_view);
        navigationButton.check(matches(isDisplayed()));
        navigationButton.perform(click());
    }


    public static void clickNavigationNews() {
        waitUntilElement(android.R.id.title);
        navigationNews.check(matches(isDisplayed()));
        navigationNews.perform(click());
    }


    public static void clickNavigationAbout() {
        waitUntilElement(android.R.id.title);
        navigationAbout.check(matches(isDisplayed()));
        navigationAbout.perform(click());
    }


    public static void clickLoveIsAllBtn() {
        waitUntilElement(R.id.our_mission_image_button);
        loveIsAllBtn.check(matches(isDisplayed()));
        loveIsAllBtn.perform(click());
    }


    public static void checkLoveIsAllBtn() {
        waitUntilElement(R.id.our_mission_title_text_view);
        loveIsAllText.check(matches(isDisplayed()));
        loveIsAllText.check(matches(withText(loveTitle)));
    }


    public static void exit() {
        waitUntilElement(R.id.authorization_image_button);
        exitBtn.check(matches(isDisplayed()));
        exitBtn.perform(click());
        waitUntilElement(android.R.id.title);
        logOut.perform(click());
    }
}
