package ru.iteco.fmhandroid.tests;


import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.elements.AuthorizationPage;
import ru.iteco.fmhandroid.steps.AppBarStep;
import ru.iteco.fmhandroid.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.steps.MainStep;
import ru.iteco.fmhandroid.steps.NewsStep;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class NewsTest extends DataHelper {
    private View decorView;

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
        AppBarStep.clickNavigationNews();
        NewsStep.checkNewsPageTitle();
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }


    @Test
    @Story("Создание новости с валидными данными (ID 38)")
    public void shouldCreateNews() {
        NewsStep.openControlPanelSection();
        NewsStep.checkControlPanelSectionTitle(controlPanelTitle);
        NewsStep.openCreatingNews();
        NewsStep.selectCategoryFiler(category_1);
        NewsStep.emptyTitleEN(newNews);
        NewsStep.DateFieldSet(futureDate(1));
        NewsStep.TimeFieldSet(futureTimeMinute(1));
        NewsStep.DiscriptionSet(newNews);
        NewsStep.clickSaveBtn();
        NewsStep.checkNewCreatingNewsTitle(newNews);
    }

    @Test
    @Story("Создание новости с оставлением поле заголовок пустым (ID 41)")
    public void shouldEditTitleEmpty() {
        NewsStep.openControlPanelSection();
        NewsStep.checkControlPanelSectionTitle(controlPanelTitle);
        NewsStep.checkCPNewsCard();
        NewsStep.openEditingSection();
        NewsStep.checkEditingSectionTitle();
        ;
        NewsStep.replaceTitleEN("");
        NewsStep.clickSaveBtn();
        AuthorizationPage.errorMessageText("Fill empty fields", decorView);
    }

    @Test
    @Story("Создание новости без выбора категории (ID 42)")
    public void shouldCreateNewsEmptyCategory() {
        NewsStep.openControlPanelSection();
        NewsStep.checkControlPanelSectionTitle(controlPanelTitle);
        NewsStep.openCreatingNews();
        NewsStep.emptyTitleEN(newNews);
        NewsStep.DateFieldSet(futureDate(1));
        NewsStep.TimeFieldSet(futureTimeMinute(1));
        NewsStep.DiscriptionSet(newNews);
        NewsStep.clickSaveBtn();
        AuthorizationPage.errorMessageText("Fill empty fields", decorView);
    }

    @Test
    @Story("Создание новости без выбора даты публикации (ID 43)")
    public void shouldCreateNewsEmptyDate() {
        NewsStep.openControlPanelSection();
        NewsStep.checkControlPanelSectionTitle(controlPanelTitle);
        NewsStep.openCreatingNews();
        NewsStep.selectCategoryFiler(category_1);
        NewsStep.emptyTitleEN(newNews);
        NewsStep.TimeFieldSet(futureTimeMinute(1));
        NewsStep.DiscriptionSet(newNews);
        NewsStep.clickSaveBtn();
        AuthorizationPage.errorMessageText("Fill empty fields", decorView);
    }

    @Test
    @Story("Создание новости с оставлением поле описание пустым (ID 44)")
    public void shouldCreateNewsEmptyDiscription() {
        NewsStep.openControlPanelSection();
        NewsStep.checkControlPanelSectionTitle(controlPanelTitle);
        NewsStep.openCreatingNews();
        NewsStep.selectCategoryFiler(category_1);
        NewsStep.emptyTitleEN(newNews);
        NewsStep.DateFieldSet(futureDate(1));
        NewsStep.TimeFieldSet(futureTimeMinute(1));
        NewsStep.clickSaveBtn();
        AuthorizationPage.errorMessageText("Fill empty fields", decorView);
    }

    @Test
    @Story("Изменение новости  из панели редактирования (Control panel) (ID 52)")
    public void shouldEditDiscriptionEN() {
        NewsStep.openControlPanelSection();
        NewsStep.checkControlPanelSectionTitle(controlPanelTitle);
        NewsStep.checkCPNewsCard();
        NewsStep.openEditingSection();
        NewsStep.checkEditingSectionTitle();
        NewsStep.DiscriptionSet(textTitle);
        NewsStep.clickSaveBtn();
        //Assert
        NewsStep.checkDiscription(textTitle);
    }

    @Test
    @Story("Удаление новости, из панели редактирования (Control panel) (ID 54)")
    public void shouldDeleteNews() {
        NewsStep.openControlPanelSection();
        NewsStep.checkControlPanelSectionTitle(controlPanelTitle);
        NewsStep.checkCPNewsCard();
        NewsStep.CPDeleteNews();
        NewsStep.checkDeleteCard();
    }
}