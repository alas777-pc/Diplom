package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;


import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.WaitId;
import ru.iteco.fmhandroid.elements.LoveIsAllPage;

public class LoveIsAllStep {
    LoveIsAllPage loveIsAllPage = new LoveIsAllPage();
    WaitId waitId = new WaitId();

    public void openDiscription(int num) {
        Allure.step("Открытие описания циатат");
        waitId.waitUntilElement(R.id.our_mission_item_list_recycler_view);
        loveIsAllPage.clickOnQuote(num);
    }


    public void viewDiscription(int num) {
        Allure.step("Проверка отображения цитат");
        waitId.waitUntilElement(R.id.our_mission_item_description_text_view);
        loveIsAllPage.openDiscription(num).check(matches(isDisplayed()));
    }
}
