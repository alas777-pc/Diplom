package ru.iteco.fmhandroid.tests;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.IsNot.not;
import static ru.iteco.fmhandroid.data.WaitId.waitUntilElement;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.elements.LoveIsAllPage;
import ru.iteco.fmhandroid.steps.AppBarStep;
import ru.iteco.fmhandroid.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.steps.MainStep;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class LoveIsAllTest extends DataHelper {
    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void loginAuth() {
        try {
            MainStep.checkNewsTitle();
        } catch (androidx.test.espresso.PerformException e) {
            AuthorizationSteps.loginFieldInput(validLogin);
            AuthorizationSteps.passwordFieldInput(validPassword);
            AuthorizationSteps.clickLoginBtn();
        }
        MainStep.checkNewsTitle();
        AppBarStep.clickLoveIsAllBtn();
        AppBarStep.checkLoveIsAllBtn();
    }


    @Test
    @Story("Разворачивание цитат (ID 57)")
    public void ShouldOpenDescription() {
        waitUntilElement(R.id.our_mission_item_list_recycler_view);
        LoveIsAllPage.clickOnQuote(num);
        waitUntilElement(R.id.our_mission_item_description_text_view);
        LoveIsAllPage.openDiscription(num).check(matches(isDisplayed()));
    }

    @Test
    @Story("Сворачивание цитат (ID 57)")
    public void ShouldCloseDescription() {
        ShouldOpenDescription();

        waitUntilElement(R.id.our_mission_item_list_recycler_view);
        LoveIsAllPage.clickOnQuote(num);
        waitUntilElement(R.id.our_mission_item_description_text_view);
        LoveIsAllPage.openDiscription(num).check(matches(not(isDisplayed())));
    }

}
