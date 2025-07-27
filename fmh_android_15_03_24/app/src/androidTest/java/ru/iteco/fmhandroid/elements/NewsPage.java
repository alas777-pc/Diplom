package ru.iteco.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class NewsPage {

    public static ViewInteraction NewsPageTitle = onView(allOf(withText("News"),
            withParent(withParent(withId(R.id.container_list_news_include)))));


    public static void NewsBox(int number) {
        int num = number - 1;
        onView(childAtPosition(withId(R.id.news_list_recycler_view), num)).perform(click());
    }


    public static ViewInteraction openDiscription(int number) {
        int num = number - 1;
        return onView(
                allOf(withId(R.id.news_item_description_text_view),
                        withParent(withParent(childAtPosition(withId(R.id.news_list_recycler_view), num)))));
    }


    public static ViewInteraction RefreshBtn = onView(
            allOf(withId(R.id.news_retry_material_button), withText("Refresh"),
                    childAtPosition(
                            allOf(withId(R.id.all_news_cards_block_constraint_layout),
                                    childAtPosition(
                                            withId(R.id.container_list_news_include),
                                            2)),
                            3)));


    public static ViewInteraction FilterNewsSection = onView(withId(R.id.filter_news_material_button));


    public static ViewInteraction FilterNewsSectionitle = onView(
            allOf(withId(R.id.filter_news_title_text_view), withText("Filter news")));


    public static ViewInteraction OpenCategoryList = onView(
            allOf(withId(com.google.android.material.R.id.text_input_end_icon), withContentDescription("Show dropdown menu")));


    public static ViewInteraction CategoryList = onView(withId(R.id.news_item_category_text_auto_complete_text_view));


    public static void SelectCategoryFromList(String category) {
        onView(withText(category))
                .inRoot(RootMatchers
                        .isPlatformPopup())
                .perform(click());
    }


    public static ViewInteraction categoryNews = onView(first
            (withId(R.id.news_item_category_text_view)));


    public static ViewInteraction notNewsYet = onView(
            allOf(withId(R.id.empty_news_list_text_view), withText("There is nothing here yet…")));


    public static ViewInteraction filterBtn = onView(
            allOf(withId(R.id.filter_button), withText("Filter")));


    public static ViewInteraction CancelBtnFiler = onView(
            allOf(withId(R.id.cancel_button), withText("Cancel"),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.nav_host_fragment),
                                    0),
                            7),
                    isDisplayed()));

    public static ViewInteraction ControlPanel = onView(
            allOf(withId(R.id.edit_news_material_button),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.container_list_news_include),
                                    0),
                            3)));


    public static ViewInteraction ControlPanelTitle = onView(
            allOf(withText("Control panel"),
                    withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))));


    public static ViewInteraction CPNewsCard = onView(first(
            allOf(withParent(allOf(withId(R.id.news_item_material_card_view),
                    withParent(withId(R.id.news_list_recycler_view)))))));


    public static ViewInteraction CPNewsCardChecking = onView(first(
            allOf(withId(R.id.news_item_title_text_view),
                    withParent(withParent(withId(R.id.news_item_material_card_view))))));


    public static String CPNewsCardTitle() {
        String firstCardTitle = onView(first(
                allOf(withId(R.id.news_item_title_text_view),
                        withParent(withParent(withId(R.id.news_item_material_card_view)))))).toString();
        return firstCardTitle;
    }


    public static ViewInteraction CPDeleteBtn = onView(first(
            allOf(withId(R.id.delete_news_item_image_view), withContentDescription("News delete button"),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.news_item_material_card_view),
                                    0),
                            14))));


    public static ViewInteraction CPDialogWindow = onView(
            allOf(withId(android.R.id.message), withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
                    withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class)))));


    public static ViewInteraction CPDialogWinOKBtn = onView(
            allOf(withId(android.R.id.button1), withText("OK"),
                    childAtPosition(
                            childAtPosition(
                                    withClassName(is("android.widget.ScrollView")),
                                    0),
                            3)));


    public static ViewInteraction EditingBtn = onView(first(
            allOf(withId(R.id.edit_news_item_image_view), withContentDescription("News editing button"))));


    public static ViewInteraction EditingSectionTitle = onView(
            allOf(withId(R.id.custom_app_bar_title_text_view), withText("Editing"),
                    withParent(allOf(withId(R.id.container_custom_app_bar_include_on_fragment_create_edit_news),
                            withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))))));


    public static ViewInteraction ENCategoryField = onView(
            allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));


    public static ViewInteraction TitleField = onView(
            allOf(withId(R.id.news_item_title_text_input_edit_text)));


    public static ViewInteraction CPTitleNews = onView(first(
            allOf(withId(R.id.news_item_title_text_view),
                    withParent(withParent(withId(R.id.news_item_material_card_view))))));


    public static ViewInteraction DateField = onView(
            allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));


    public static ViewInteraction DateEN = onView(first(
            allOf(withId(R.id.news_item_publication_date_text_view))));


    public static ViewInteraction TimeField = onView(
            allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));


    public static ViewInteraction DiscriptionFieldEN = onView(
            allOf(withId(R.id.news_item_description_text_input_edit_text)));


    public static ViewInteraction openDiscription = onView(first(
            allOf(withId(R.id.news_list_recycler_view))));


    public static ViewInteraction DiscriptionEN = onView(first(
            allOf(withId(R.id.news_item_description_text_view))));


    public static ViewInteraction Switcher = onView(
            allOf(withId(R.id.switcher)));


    public static ViewInteraction checkStatusText = onView(first(
            allOf(withId(R.id.news_item_published_text_view))));


    public static ViewInteraction ENSaveBtn = onView(
            allOf(withId(R.id.save_button)));


    public static ViewInteraction ENCancelBtn = onView(
            allOf(withId(R.id.cancel_button)));


    public static ViewInteraction CreatingNewsBtn = onView(
            allOf(withId(R.id.add_news_image_view)));


    public static ViewInteraction CreatingNewsTitle = onView(
            allOf(withId(R.id.custom_app_bar_title_text_view)));


    public static void NewCPTitleNews(String text) {
        onView(allOf(
                (withId(R.id.news_item_title_text_view)), withText(text))).check(matches(withText(text)));
    }


    public static ViewInteraction textInputEditText = onView(
            allOf(withId(R.id.news_item_title_text_input_edit_text)));


    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }


        };
    }


    private static <T> Matcher<T> first(final Matcher<T> matcher) {
        return new BaseMatcher<T>() {
            boolean isFirst = true;

            @Override
            public boolean matches(final Object item) {
                if (isFirst && matcher.matches(item)) {
                    isFirst = false;
                    return true;
                }
                return false;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("should return first matching item");
            }
        };
    }
}
