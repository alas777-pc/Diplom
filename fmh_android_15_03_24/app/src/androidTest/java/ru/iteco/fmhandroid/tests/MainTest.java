package ru.iteco.fmhandroid.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.steps.MainStep;
import ru.iteco.fmhandroid.steps.NewsStep;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class MainTest extends DataHelper {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
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
    }
    @Test
    @Story("Свернуть/развернуть раздел новостей (ID 19)")
    public void ShouldCloseAndOpenNewsFeed() {
        MainStep.clickOpenNewsBtn();
        MainStep.clickOpenNewsBtn();
        MainStep.checkAllNewsText();
    }

    @Test
    @Story("Переход к странице с новостями (ID 20)")
    public void ShouldGoToNews() {
        MainStep.clickAllNewsText();
        NewsStep.checkNewsPageTitle();
    }
}
