package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.data.WaitId;
import ru.iteco.fmhandroid.elements.AboutPage;


public class AboutStep extends DataHelper {
    AboutPage aboutPage = new AboutPage();

    public void checkVersionTitle() {
        Allure.step("Проверка отображения надписи 'Version'");
        WaitId.waitUntilElement(R.id.about_version_title_text_view);
        aboutPage.getVersionText.check(matches(isDisplayed()));
        aboutPage.getVersionText.check(matches(withText(versionText)));


    }
}
