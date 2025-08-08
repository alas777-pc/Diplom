package ru.iteco.fmhandroid.elements;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;

public class AuthorizationPage extends DataHelper {

    public ViewInteraction loginField;
    public ViewInteraction loginFieldAsTextField;
    public ViewInteraction passwordField;
    public ViewInteraction passwordFieldAsTextField;
    public ViewInteraction loginButton;
    public ViewInteraction AuthorizationText;

    public AuthorizationPage() {
        loginField = onView(withId(R.id.login_text_input_layout));
        loginFieldAsTextField = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.login_text_input_layout))));
        passwordField = onView(withId(R.id.password_text_input_layout));
        passwordFieldAsTextField = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.password_text_input_layout))));
        loginButton = onView(withId(R.id.enter_button));
        AuthorizationText = onView(withText("Authorization"));
    }


    public void errorMessageText(String text, View decorView) {
        onView(withText(text))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }
}


