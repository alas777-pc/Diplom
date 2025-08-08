package ru.iteco.fmhandroid.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.steps.MainStep;
import ru.iteco.fmhandroid.steps.NewsStep;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тестирование вкладки 'Main'")

public class MainTest extends DataHelper {
    MainStep mainStep = new MainStep();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    NewsStep newsStep = new NewsStep();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
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
    }

    @Test
    @Story("Свернуть/развернуть раздел новостей (ID 19)")
    public void ShouldCloseAndOpenNewsFeed() {
        mainStep.clickOpenNewsBtn();
        mainStep.clickOpenNewsBtn();
        mainStep.checkAllNewsText();
    }

    @Test
    @Story("Переход к странице с новостями (ID 20)")
    public void ShouldGoToNews() {
        mainStep.clickAllNewsText();
        newsStep.checkNewsPageTitle();
    }
}
