package ru.iteco.fmhandroid.tests;

import static ru.iteco.fmhandroid.data.WaitId.waitUntilElement;
import static ru.iteco.fmhandroid.elements.AppBarPage.exitBtn;
import static ru.iteco.fmhandroid.elements.AppBarPage.logOut;
import static ru.iteco.fmhandroid.elements.AuthorizationPage.AuthorizationText;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.elements.AuthorizationPage;
import ru.iteco.fmhandroid.steps.AppBarStep;
import ru.iteco.fmhandroid.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.steps.MainStep;
import ru.iteco.fmhandroid.ui.AppActivity;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class AuthorizationTest extends DataHelper {
    private View decorView;

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void loginAuth() {
        try {
            AuthorizationSteps.checkAuthorizationPage();
        } catch (androidx.test.espresso.PerformException e) {
            AppBarStep.exit();
        }
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @After
    public void loginOut() {
        try {

            waitUntilElement(R.id.nav_host_fragment);
            AuthorizationText.check(matches(isDisplayed()));
        } catch (androidx.test.espresso.NoMatchingViewException e) {
            waitUntilElement(R.id.authorization_image_button);
            exitBtn.check(matches(isDisplayed()));
            exitBtn.perform(click());
            waitUntilElement(android.R.id.title);
            logOut.perform(click());
        }
    }

    @Test
    @Story("Авторизация с валидными данными (ID 2)")
    public void ValidAuthorization() {
        AuthorizationSteps.loginFieldInput(validLogin);
        AuthorizationSteps.passwordFieldInput(validPassword);
        AuthorizationSteps.clickLoginBtn();
        MainStep.checkNewsTitle();
    }

    @Test
    @Story("Авторизация с невалидным логином и валидным паролем (ID 3)")
    public void InvalidAuthorization() {

        AuthorizationSteps.loginFieldInput(invalidInput);
        AuthorizationSteps.passwordFieldInput(validPassword);
        AuthorizationSteps.clickLoginBtn();
        AuthorizationPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }

    @Test
    @Story("Авторизация с валидным логином и невалидным паролем (ID 4)")
    public void InvalidAuthorization2() {
        AuthorizationSteps.loginFieldInput(validLogin);
        AuthorizationSteps.passwordFieldInput(invalidInput);
        AuthorizationSteps.clickLoginBtn();
        AuthorizationPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }

    @Test
    @Story("Авторизация незарегистрированного пользователя (невалидный логин и пароль) (ID 5)")
    public void InvalidAuthorization3() {
        AuthorizationSteps.loginFieldInput(invalidInput);
        AuthorizationSteps.passwordFieldInput(invalidInput);
        AuthorizationSteps.clickLoginBtn();
        AuthorizationPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }

    @Test
    @Story("Авторизация с логином, состоящим из пробелов, и валидным паролем (ID 6)")
    public void InvalidAuthorization4() {
        AuthorizationSteps.loginFieldInput("   ");
        AuthorizationSteps.passwordFieldInput(validPassword);
        AuthorizationSteps.clickLoginBtn();
        AuthorizationPage.errorMessageText("Login and password cannot be empty", decorView);
    }

    @Test
    @Story("Авторизация с валидным логином, и паролем, состоящим из пробелов (ID 7)")
    public void InvalidAuthorization5() {
        AuthorizationSteps.loginFieldInput(validLogin);
        AuthorizationSteps.passwordFieldInput("   ");
        AuthorizationSteps.clickLoginBtn();
        AuthorizationPage.errorMessageText("Login and password cannot be empty", decorView);
    }


    @Test
    @Story("Авторизация с пустым логином, и валидным паролем (ID 8)")
    public void InvalidAuthorization6() {
        AuthorizationSteps.loginFieldInput("");
        AuthorizationSteps.passwordFieldInput("");
        AuthorizationSteps.clickLoginBtn();
        AuthorizationPage.errorMessageText("Login and password cannot be empty", decorView);
    }

    @Test
    @Story("Авторизация с корректным логином и пустым паролем (ID 9)")
    public void InvalidAuthorization7() {
        AuthorizationSteps.loginFieldInput("");
        AuthorizationSteps.passwordFieldInput(validPassword);
        AuthorizationSteps.clickLoginBtn();
        AuthorizationPage.errorMessageText("Login and password cannot be empty", decorView);
    }

    @Test
    @Story("Введения в поле логин спецсимволов (ID 12)")
    public void InvalidAuthorization8() {
        AuthorizationSteps.loginFieldInput(validLogin);
        AuthorizationSteps.passwordFieldInput(specialSimbols);
        AuthorizationSteps.clickLoginBtn();
        AuthorizationPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }

    @Test
    @Story("Авторизация с валидным логином, введенным разным регистром и валидным паролем (ID 15)")
    public void registrPasswordAuthorization() {
        AuthorizationSteps.loginFieldInput(validLogin);
        AuthorizationSteps.passwordFieldInput(registrPassword);
        AuthorizationSteps.clickLoginBtn();
        AuthorizationPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }
}
