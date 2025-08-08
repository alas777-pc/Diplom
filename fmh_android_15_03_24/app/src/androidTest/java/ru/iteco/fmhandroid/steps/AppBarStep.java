package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.data.WaitId;
import ru.iteco.fmhandroid.elements.AppBarPage;
import ru.iteco.fmhandroid.elements.LoveIsAllPage;

public class AppBarStep extends DataHelper {
    AppBarPage appBarPage = new AppBarPage();
    LoveIsAllPage loveIsAllPage = new LoveIsAllPage();
    WaitId waitId = new WaitId();

    public void clickNavigationBtn() {
        Allure.step("Нажатие на иконку 'бургер'");
        waitId.waitUntilElement(R.id.custom_app_bar_title_text_view);
        appBarPage.navigationButton.check(matches(isDisplayed()));
        appBarPage.navigationButton.perform(click());
    }


    public void clickNavigationNews() {
        Allure.step("Нажатие на 'News' в навигационном меню");
        waitId.waitUntilElement(android.R.id.title);
        appBarPage.navigationNews.check(matches(isDisplayed()));
        appBarPage.navigationNews.perform(click());
    }


    public void clickNavigationAbout() {
        Allure.step("Нажатие на 'About' в навигационном меню");
        waitId.waitUntilElement(android.R.id.title);
        appBarPage.navigationAbout.check(matches(isDisplayed()));
        appBarPage.navigationAbout.perform(click());
    }


    public void clickLoveIsAllBtn() {
        Allure.step("Нажатие на иконку 'бабочка'");
        waitId.waitUntilElement(R.id.our_mission_image_button);
        appBarPage.loveIsAllBtn.check(matches(isDisplayed()));
        appBarPage.loveIsAllBtn.perform(click());
    }


    public void checkLoveIsAllBtn() {
        Allure.step("Проверка отображения заголовка 'Love is all'");
        waitId.waitUntilElement(R.id.our_mission_title_text_view);
        loveIsAllPage.loveIsAllText.check(matches(isDisplayed()));
        loveIsAllPage.loveIsAllText.check(matches(withText(loveTitle)));
    }


    public void exit() {
        Allure.step("Выход из приложения");
        waitId.waitUntilElement(R.id.authorization_image_button);
        appBarPage.exitBtn.check(matches(isDisplayed()));
        appBarPage.exitBtn.perform(click());
        waitId.waitUntilElement(android.R.id.title);
        appBarPage.logOut.perform(click());
    }
}
