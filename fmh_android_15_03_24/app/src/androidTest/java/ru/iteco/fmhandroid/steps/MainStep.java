package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.data.WaitId.waitUntilElement;
import static ru.iteco.fmhandroid.elements.MainPage.allNewsBtn;
import static ru.iteco.fmhandroid.elements.MainPage.allNewsText;
import static ru.iteco.fmhandroid.elements.MainPage.newsFeedTitle;
import static ru.iteco.fmhandroid.elements.MainPage.openNewsBtn;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;

public class MainStep extends DataHelper {

    public static void clickOpenNewsBtn() {
        waitUntilElement(R.id.expand_material_button);
        openNewsBtn.check(matches(isDisplayed()));
        openNewsBtn.perform(click());
    }


    public static void checkAllNewsText() {
        waitUntilElement(R.id.all_news_text_view);
        allNewsText.check(matches(isDisplayed()));
        allNewsText.check(matches(withText(allNewsTitle)));
    }


    public static void clickAllNewsText() {
        waitUntilElement(R.id.all_news_text_view);
        allNewsBtn.check(matches(isDisplayed()));
        allNewsBtn.perform(click());
    }


    public static void checkNewsTitle() {
        waitUntilElement(R.id.container_list_news_include_on_fragment_main);
        newsFeedTitle.check(matches(isDisplayed()));
    }

}
