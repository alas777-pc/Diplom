package ru.iteco.fmhandroid.tests;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.IsNot.not;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.data.WaitId;
import ru.iteco.fmhandroid.elements.LoveIsAllPage;
import ru.iteco.fmhandroid.steps.AppBarStep;
import ru.iteco.fmhandroid.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.steps.MainStep;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тестирование вкладки 'LoveIsAll'")
public class LoveIsAllTest extends DataHelper {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    AppBarStep appBarStep = new AppBarStep();
    LoveIsAllPage loveIsAllPage = new LoveIsAllPage();
    MainStep mainStep = new MainStep();
    WaitId waitId = new WaitId();
    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void loginAuth() {
        try {
            mainStep.checkNewsTitle();
        } catch (androidx.test.espresso.PerformException e) {
            authorizationSteps.loginFieldInput(validLogin);
            authorizationSteps.passwordFieldInput(validPassword);
            authorizationSteps.clickLoginBtn();
        }
        mainStep.checkNewsTitle();
        appBarStep.clickLoveIsAllBtn();
        appBarStep.checkLoveIsAllBtn();
    }


    @Test
    @Story("Разворачивание цитат (ID 57)")
    public void ShouldOpenDescription() {
        waitId.waitUntilElement(R.id.our_mission_item_list_recycler_view);
        loveIsAllPage.clickOnQuote(num);
        waitId.waitUntilElement(R.id.our_mission_item_description_text_view);
        loveIsAllPage.openDiscription(num).check(matches(isDisplayed()));
    }

    @Test
    @Story("Сворачивание цитат (ID 57)")
    public void ShouldCloseDescription() {
        ShouldOpenDescription();

        waitId.waitUntilElement(R.id.our_mission_item_list_recycler_view);
        loveIsAllPage.clickOnQuote(num);
        waitId.waitUntilElement(R.id.our_mission_item_description_text_view);
        loveIsAllPage.openDiscription(num).check(matches(not(isDisplayed())));
    }

}
