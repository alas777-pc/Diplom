package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import static ru.iteco.fmhandroid.data.WaitId.waitUntilElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.elements.AppBarPage;
import ru.iteco.fmhandroid.elements.AuthorizationPage;
import ru.iteco.fmhandroid.elements.LoveIsAllPage;

public class AppBarStep extends DataHelper {
    AppBarPage appBarPage = new AppBarPage();
    LoveIsAllPage loveIsAllPage = new LoveIsAllPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();

    public void clickNavigationBtn() {
        Allure.step("Нажатие на иконку 'бургер'");
        waitUntilElement(appBarPage.appBarTitle);
        appBarPage.navigationButton.check(matches(isDisplayed()));
        appBarPage.navigationButton.perform(click());
    }


    public void clickNavigationNews() {
        Allure.step("Нажатие на 'News' в навигационном меню");
        waitUntilElement(authorizationPage.titleElement);
        appBarPage.navigationNews.check(matches(isDisplayed()));
        appBarPage.navigationNews.perform(click());
    }


    public void clickNavigationAbout() {
        Allure.step("Нажатие на 'About' в навигационном меню");
        waitUntilElement(authorizationPage.titleElement);
        appBarPage.navigationAbout.check(matches(isDisplayed()));
        appBarPage.navigationAbout.perform(click());
    }


    public void clickLoveIsAllBtn() {
        Allure.step("Нажатие на иконку 'бабочка'");
        waitUntilElement(loveIsAllPage.missionImageButton);
        appBarPage.loveIsAllBtn.check(matches(isDisplayed()));
        appBarPage.loveIsAllBtn.perform(click());
    }


    public void checkLoveIsAllBtn() {
        Allure.step("Проверка отображения заголовка 'Love is all'");
        waitUntilElement(loveIsAllPage.missionTitle);
        loveIsAllPage.loveIsAllText.check(matches(isDisplayed()));
        loveIsAllPage.loveIsAllText.check(matches(withText(loveTitle)));
    }


    public void exit() {
        Allure.step("Выход из приложения");
        waitUntilElement(authorizationPage.imageButton);
        appBarPage.exitBtn.check(matches(isDisplayed()));
        appBarPage.exitBtn.perform(click());
        waitUntilElement(android.R.id.title);
        appBarPage.logOut.perform(click());
    }
}
