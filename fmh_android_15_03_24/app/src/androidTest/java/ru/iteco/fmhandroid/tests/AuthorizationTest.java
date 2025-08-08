package ru.iteco.fmhandroid.tests;


import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
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
import ru.iteco.fmhandroid.elements.AppBarPage;
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
@Epic("Тестирование авторизации")

public class AuthorizationTest extends DataHelper {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    AppBarPage appBarPage = new AppBarPage();
    WaitId waitId = new WaitId();
    AppBarStep appBarStep = new AppBarStep();
    MainStep mainStep = new MainStep();
    private View decorView;

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void loginAuth() {
        try {
            authorizationSteps.checkAuthorizationPage();
        } catch (androidx.test.espresso.PerformException e) {
            appBarStep.exit();
        }
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @After
    public void loginOut() {
        try {

            waitId.waitUntilElement(R.id.nav_host_fragment);
            authorizationPage.AuthorizationText.check(matches(isDisplayed()));
        } catch (androidx.test.espresso.NoMatchingViewException e) {
            waitId.waitUntilElement(R.id.authorization_image_button);
            appBarPage.exitBtn.check(matches(isDisplayed()));
            appBarPage.exitBtn.perform(click());
            waitId.waitUntilElement(android.R.id.title);
            appBarPage.logOut.perform(click());
        }
    }

    @Test
    @Story("Авторизация с валидными данными (ID 2)")
    public void ValidAuthorization() {
        authorizationSteps.loginFieldInput(validLogin);
        authorizationSteps.passwordFieldInput(validPassword);
        authorizationSteps.clickLoginBtn();
        mainStep.checkNewsTitle();
    }

    @Test
    @Story("Авторизация с невалидным логином и валидным паролем (ID 3)")
    public void InvalidAuthorization() {

        authorizationSteps.loginFieldInput(invalidInput);
        authorizationSteps.passwordFieldInput(validPassword);
        authorizationSteps.clickLoginBtn();
        authorizationPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }

    @Test
    @Story("Авторизация с валидным логином и невалидным паролем (ID 4)")
    public void InvalidAuthorization2() {
        authorizationSteps.loginFieldInput(validLogin);
        authorizationSteps.passwordFieldInput(invalidInput);
        authorizationSteps.clickLoginBtn();
        authorizationPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }

    @Test
    @Story("Авторизация незарегистрированного пользователя (невалидный логин и пароль) (ID 5)")
    public void InvalidAuthorization3() {
        authorizationSteps.loginFieldInput(invalidInput);
        authorizationSteps.passwordFieldInput(invalidInput);
        authorizationSteps.clickLoginBtn();
        authorizationPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }

    @Test
    @Story("Авторизация с логином, состоящим из пробелов, и валидным паролем (ID 6)")
    public void InvalidAuthorization4() {
        authorizationSteps.loginFieldInput("   ");
        authorizationSteps.passwordFieldInput(validPassword);
        authorizationSteps.clickLoginBtn();
        authorizationPage.errorMessageText("Login and password cannot be empty", decorView);
    }

    @Test
    @Story("Авторизация с валидным логином, и паролем, состоящим из пробелов (ID 7)")
    public void InvalidAuthorization5() {
        authorizationSteps.loginFieldInput(validLogin);
        authorizationSteps.passwordFieldInput("   ");
        authorizationSteps.clickLoginBtn();
        authorizationPage.errorMessageText("Login and password cannot be empty", decorView);
    }


    @Test
    @Story("Авторизация с пустым логином, и валидным паролем (ID 8)")
    public void InvalidAuthorization6() {
        authorizationSteps.loginFieldInput("");
        authorizationSteps.passwordFieldInput("");
        authorizationSteps.clickLoginBtn();
        authorizationPage.errorMessageText("Login and password cannot be empty", decorView);
    }

    @Test
    @Story("Авторизация с корректным логином и пустым паролем (ID 9)")
    public void InvalidAuthorization7() {
        authorizationSteps.loginFieldInput("");
        authorizationSteps.passwordFieldInput(validPassword);
        authorizationSteps.clickLoginBtn();
        authorizationPage.errorMessageText("Login and password cannot be empty", decorView);
    }

    @Test
    @Story("Введения в поле логин спецсимволов (ID 12)")
    public void InvalidAuthorization8() {
        authorizationSteps.loginFieldInput(validLogin);
        authorizationSteps.passwordFieldInput(specialSimbols);
        authorizationSteps.clickLoginBtn();
        authorizationPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }

    @Test
    @Story("Авторизация с валидным логином, введенным разным регистром и валидным паролем (ID 15)")
    public void registrPasswordAuthorization() {
        authorizationSteps.loginFieldInput(validLogin);
        authorizationSteps.passwordFieldInput(registrPassword);
        authorizationSteps.clickLoginBtn();
        authorizationPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }
}
