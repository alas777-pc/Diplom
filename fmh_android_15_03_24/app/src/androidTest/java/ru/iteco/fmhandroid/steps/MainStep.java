package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.data.WaitId;
import ru.iteco.fmhandroid.elements.MainPage;

public class MainStep extends DataHelper {
    MainPage mainPage = new MainPage();
    WaitId waitId = new WaitId();

    public void clickOpenNewsBtn() {
        Allure.step("Сворачивание/разворачивание ленты новостей");
        waitId.waitUntilElement(R.id.expand_material_button);
        mainPage.openNewsBtn.check(matches(isDisplayed()));
        mainPage.openNewsBtn.perform(click());
    }


    public void checkAllNewsText() {
        Allure.step("Проверка отображения 'All news'");
        waitId.waitUntilElement(R.id.all_news_text_view);
        mainPage.allNewsText.check(matches(isDisplayed()));
        mainPage.allNewsText.check(matches(withText(allNewsTitle)));
    }


    public void clickAllNewsText() {
        Allure.step("Переход на страницу новостей через 'All news'");
        waitId.waitUntilElement(R.id.all_news_text_view);
        mainPage.allNewsBtn.check(matches(isDisplayed()));
        mainPage.allNewsBtn.perform(click());
    }


    public void checkNewsTitle() {
        Allure.step("Проверка заголовка на главной странице");
        waitId.waitUntilElement(R.id.container_list_news_include_on_fragment_main);
        mainPage.newsFeedTitle.check(matches(isDisplayed()));
    }

}
