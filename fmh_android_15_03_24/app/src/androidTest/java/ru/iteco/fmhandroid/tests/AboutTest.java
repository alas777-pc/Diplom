package ru.iteco.fmhandroid.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.elements.AboutPage;
import ru.iteco.fmhandroid.steps.AboutStep;
import ru.iteco.fmhandroid.steps.AppBarStep;
import ru.iteco.fmhandroid.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.steps.MainStep;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutTest extends DataHelper {

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
        AppBarStep.clickNavigationBtn();
        AppBarStep.clickNavigationAbout();
        AboutStep.checkVersionTitle();
    }
    @Test
    @Story("Переход по ссылке Политика конфедециальности (ID 60)")
    public void shouldGoToPrivacyPolicy() {
        Intents.init();
        AboutPage.textPrivacyPolicyLink.perform(click());
        intended(hasData("https://vhospice.org/#/privacy-policy/"));
        Intents.release();
    }

    @Test
    @Story("Переход по ссылке Правила использования (ID 59)")
    public void shouldGoToTermsOfUse() {
        Intents.init();
        AboutPage.textTermsOfUseLink.perform(click());
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        Intents.release();
    }
}
