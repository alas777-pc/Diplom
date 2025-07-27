package ru.iteco.fmhandroid.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.data.WaitId.waitUntilElement;
import static ru.iteco.fmhandroid.elements.AuthorizationPage.AuthorizationText;
import static ru.iteco.fmhandroid.elements.AuthorizationPage.loginButton;
import static ru.iteco.fmhandroid.elements.AuthorizationPage.loginField;
import static ru.iteco.fmhandroid.elements.AuthorizationPage.loginFieldAsTextField;
import static ru.iteco.fmhandroid.elements.AuthorizationPage.passwordField;
import static ru.iteco.fmhandroid.elements.AuthorizationPage.passwordFieldAsTextField;



import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;

public class AuthorizationSteps extends DataHelper {

    public static void loginFieldInput(String input) {
        waitUntilElement(R.id.login_text_input_layout);
        loginFieldAsTextField.perform(click());
        loginFieldAsTextField.perform(replaceText(input), closeSoftKeyboard());
        loginField.check(matches(isDisplayed()));
    }


    public static void passwordFieldInput(String input) {
        passwordFieldAsTextField.perform(click());
        passwordFieldAsTextField.perform(replaceText(input), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed()));
    }


    public static void clickLoginBtn () {
        loginButton.check(matches(isDisplayed()));
        loginButton.perform(click());
    }


    public static void checkAuthorizationPage () {
        waitUntilElement("Authorization");
        AuthorizationText.check(matches(isDisplayed()));
    }

}