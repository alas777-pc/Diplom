package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import static ru.iteco.fmhandroid.data.WaitId.waitUntilElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.elements.MainPage;

public class MainStep extends DataHelper {
    MainPage mainPage = new MainPage();

    public void clickOpenNewsBtn() {
        Allure.step("Сворачивание/разворачивание ленты новостей");
        waitUntilElement(mainPage.materialButton);
        mainPage.openNewsBtn.check(matches(isDisplayed()));
        mainPage.openNewsBtn.perform(click());
    }


    public void checkAllNewsText() {
        Allure.step("Проверка отображения 'All news'");
        waitUntilElement(mainPage.allNews);
        mainPage.allNewsText.check(matches(isDisplayed()));
        mainPage.allNewsText.check(matches(withText(allNewsTitle)));
    }


    public void clickAllNewsText() {
        Allure.step("Переход на страницу новостей через 'All news'");
        waitUntilElement(mainPage.allNews);
        mainPage.allNewsBtn.check(matches(isDisplayed()));
        mainPage.allNewsBtn.perform(click());
    }


    public void checkNewsTitle() {
        Allure.step("Проверка заголовка на главной странице");
        waitUntilElement(mainPage.containerList);
        mainPage.newsFeedTitle.check(matches(isDisplayed()));
    }

}
