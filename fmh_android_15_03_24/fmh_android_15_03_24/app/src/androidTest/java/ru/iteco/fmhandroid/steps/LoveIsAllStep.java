package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.data.WaitId.waitUntilElement;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.elements.LoveIsAllPage;

public class LoveIsAllStep {
    public static void openDiscription (int num) {
        waitUntilElement(R.id.our_mission_item_list_recycler_view);
        LoveIsAllPage.clickOnQuote(num);
    }

    //Проверка отображения цитат
    public static void viewDiscription (int num) {
        waitUntilElement(R.id.our_mission_item_description_text_view);
        LoveIsAllPage.openDiscription(num).check(matches(isDisplayed()));
    }
}
