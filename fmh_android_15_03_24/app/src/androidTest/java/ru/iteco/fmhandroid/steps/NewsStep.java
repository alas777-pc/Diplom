package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;


import static ru.iteco.fmhandroid.data.WaitId.waitUntilElement;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.elements.AppBarPage;
import ru.iteco.fmhandroid.elements.NewsPage;

public class NewsStep extends DataHelper {
    NewsPage newsPage = new NewsPage();
    AppBarPage appBarPage = new AppBarPage();

    public void checkNewsPageTitle() {
        Allure.step("Проверка отображения заголовка страницы 'News'");
        waitUntilElement(newsPage.containerInclude);
        newsPage.NewsPageTitle.check(matches(withText("News")));
    }


    public void selectCategoryFiler(String category) {
        Allure.step("Выбор категории из выпадающего списка");
        waitUntilElement(newsPage.newsCategoty);
        newsPage.OpenCategoryList.perform(click(), closeSoftKeyboard());
        waitUntilElement(newsPage.newsCategoty);
        onView(withText(category))
                .inRoot(RootMatchers
                        .isPlatformPopup())
                .perform(click());
    }


    public void openControlPanelSection() {
        Allure.step("Открытие раздела 'Control panel'");
        waitUntilElement(newsPage.newsMaterialButton);
        newsPage.ControlPanel.perform(click());
    }


    public void checkControlPanelSectionTitle(String title) {
        Allure.step("Проверка открытия раздела 'Control panel'");
        waitUntilElement(title);
        newsPage.ControlPanelTitle.check(matches(withText(title)));
    }


    public void checkCPNewsCard() {
        Allure.step("Проверка наличия карточек новостей в разделе 'Control panel'");
        waitUntilElement(newsPage.newsMaterialCard);
        newsPage.CPNewsCard.check(matches(isDisplayed()));
    }


    public void CPDeleteNews() {
        Allure.step("Удаление новости");
        waitUntilElement(newsPage.deleteNews);
        CPNewsCardTitle();
        newsPage.CPDeleteBtn.perform(click());
        newsPage.CPDialogWindow.check(matches(isDisplayed()));
        newsPage.CPDialogWinOKBtn.perform(click());
    }


    public void checkDeleteCard() {
        Allure.step("Проверка удаления карточки");
        newsPage.CPNewsCardChecking.check(matches(not(withText(CPNewsCardTitle()))));
    }


    public void openEditingSection() {
        Allure.step("Открытие раздела 'Editing News'");
        newsPage.EditingBtn.perform(click());
    }


    public void checkEditingSectionTitle() {
        Allure.step("Проверка открытия раздела 'Editing News'");
        waitUntilElement(appBarPage.appBarTitle);
        newsPage.EditingSectionTitle.check(matches(isDisplayed()));
    }


    public void replaceTitleEN(String title) {
        Allure.step("Изменение заголовка новости");
        newsPage.TitleField.perform(click());
        newsPage.TitleField.perform(replaceText(title), closeSoftKeyboard());
    }


    public void emptyTitleEN(String text) {
        Allure.step("Проверка отображания нового заголовка  в карточке новости");
        newsPage.textInputEditText.perform(click());
        newsPage.textInputEditText.perform(clearText());
        newsPage.textInputEditText.perform(replaceText(text), closeSoftKeyboard());
    }


    public void DateFieldSet(String date) {
        Allure.step("Введение даты в поле");
        newsPage.DateField.perform(replaceText(date));
    }


    public void TimeFieldSet(String time) {
        Allure.step("Введение времени");
        newsPage.TimeField.perform(replaceText(time));
    }


    public void DiscriptionSet(String text) {
        Allure.step("Изменение описания");
        waitUntilElement(newsPage.newsItemDescription);
        newsPage.DiscriptionFieldEN.perform(replaceText(text));
    }


    public void checkDiscription(String text) {
        Allure.step("Проверка открытия описания");
        waitUntilElement(newsPage.newsListRecycler);
        newsPage.openDiscription.perform(click());
        waitUntilElement(newsPage.newsItemDescriptionText);
        newsPage.DiscriptionEN.check(matches(withText(text)));
    }


    public void clickSaveBtn() {
        Allure.step("Нажатие кнопки Save");
        newsPage.ENSaveBtn.perform(click());
    }


    public void openCreatingNews() {
        Allure.step("Открытие раздела 'Creating news'");
        waitUntilElement(newsPage.addNewsImage);
        newsPage.CreatingNewsBtn.perform(click());
    }


    public void checkNewCreatingNewsTitle(String text) {
        Allure.step("Заголовок раздела 'Creating news'");
        waitUntilElement(newsPage.newsItemTitle);
        onView(allOf(
                (withId(newsPage.newsItemTitle)), withText(text))).check(matches(withText(text)));
    }



    public String CPNewsCardTitle() {
        String firstCardTitle = onView(first(
                allOf(withId(newsPage.newsItemTitle),
                        withParent(withParent(withId(newsPage.newsMaterialCard)))))).toString();
        return firstCardTitle;
    }




    public static Matcher<View> childAtPosition(
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


    public static <T> Matcher<T> first(final Matcher<T> matcher) {
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