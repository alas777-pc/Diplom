package ru.iteco.fmhandroid.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;


import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.data.WaitId;
import ru.iteco.fmhandroid.elements.AuthorizationPage;

public class AuthorizationSteps extends DataHelper {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    WaitId waitId = new WaitId();

    public void loginFieldInput(String input) {
        Allure.step("Заполнение поля логина");
        waitId.waitUntilElement(R.id.login_text_input_layout);
        authorizationPage.loginFieldAsTextField.perform(click());
        authorizationPage.loginFieldAsTextField.perform(replaceText(input), closeSoftKeyboard());
        authorizationPage.loginField.check(matches(isDisplayed()));
    }


    public void passwordFieldInput(String input) {
        Allure.step("Заполнение поля пароля");
        authorizationPage.passwordFieldAsTextField.perform(click());
        authorizationPage.passwordFieldAsTextField.perform(replaceText(input), closeSoftKeyboard());
        authorizationPage.passwordField.check(matches(isDisplayed()));
    }


    public void clickLoginBtn() {
        Allure.step("Нажатие кнопки входа");
        authorizationPage.loginButton.check(matches(isDisplayed()));
        authorizationPage.loginButton.perform(click());
    }


    public void checkAuthorizationPage() {
        Allure.step("Проверка отображения заголовка 'Authorization'");
        waitId.waitUntilElement("Authorization");
        authorizationPage.AuthorizationText.check(matches(isDisplayed()));
    }

}