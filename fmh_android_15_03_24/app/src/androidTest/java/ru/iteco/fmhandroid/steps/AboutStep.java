package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.data.WaitId.waitUntilElement;
import static ru.iteco.fmhandroid.elements.AboutPage.VersionText;


import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;

public class AboutStep extends DataHelper {

    public static void checkVersionTitle() {
        waitUntilElement(R.id.about_version_title_text_view);
        VersionText.check(matches(isDisplayed()));
        VersionText.check(matches(withText(versionText)));
    }

}
