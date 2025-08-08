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
import io.qameta.allure.kotlin.Epic;
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
@Epic("Тестирование вкладки 'About'")
public class AboutTest extends DataHelper {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    AboutStep aboutStep = new AboutStep();

    AboutPage aboutPage = new AboutPage();
    AppBarStep appBarStep = new AppBarStep();
    MainStep mainStep = new MainStep();

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
        appBarStep.clickNavigationBtn();
        appBarStep.clickNavigationAbout();
        aboutStep.checkVersionTitle();
    }

    @Test
    @Story("Переход по ссылке Политика конфедециальности (ID 60)")
    public void shouldGoToPrivacyPolicy() {
        Intents.init();
        aboutPage.getTextPrivacyPolicyLink.perform(click());
        intended(hasData("https://vhospice.org/#/privacy-policy/"));
        Intents.release();
    }

    @Test
    @Story("Переход по ссылке Правила использования (ID 59)")
    public void shouldGoToTermsOfUse() {
        Intents.init();
        aboutPage.getTextTermsOfUseLink.perform(click());
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        Intents.release();
    }
}
