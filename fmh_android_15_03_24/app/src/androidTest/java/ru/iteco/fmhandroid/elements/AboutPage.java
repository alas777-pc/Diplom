package ru.iteco.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.core.AllOf.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class AboutPage {

    public ViewInteraction getVersionText;
    public ViewInteraction getTextPrivacyPolicyLink;
    public ViewInteraction getTextTermsOfUseLink;
    public int versionTitle;

    public AboutPage() {
        getVersionText = onView(allOf(withId(R.id.about_version_title_text_view),
                withText("Version:"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout.class)))));


        getTextPrivacyPolicyLink = onView(
                allOf(withId(R.id.about_privacy_policy_value_text_view), withText("https://vhospice.org/#/privacy-policy/"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))));


        getTextTermsOfUseLink = onView(
                allOf(withId(R.id.about_terms_of_use_value_text_view), withText("https://vhospice.org/#/terms-of-use"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))));

        versionTitle = R.id.about_version_title_text_view;


    }
}
