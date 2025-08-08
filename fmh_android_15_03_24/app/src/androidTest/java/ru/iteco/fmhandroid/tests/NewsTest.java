package ru.iteco.fmhandroid.tests;


import android.view.View;

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
import ru.iteco.fmhandroid.elements.AuthorizationPage;
import ru.iteco.fmhandroid.steps.AppBarStep;
import ru.iteco.fmhandroid.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.steps.MainStep;
import ru.iteco.fmhandroid.steps.NewsStep;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тестирование вкладки 'News'")

public class NewsTest extends DataHelper {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    AppBarStep appBarStep = new AppBarStep();
    MainStep mainStep = new MainStep();
    NewsStep newsStep = new NewsStep();
    private View decorView;

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
        appBarStep.clickNavigationNews();
        newsStep.checkNewsPageTitle();
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }


    @Test
    @Story("Создание новости с валидными данными (ID 38)")
    public void shouldCreateNews() {
        newsStep.openControlPanelSection();
        newsStep.checkControlPanelSectionTitle(controlPanelTitle);
        newsStep.openCreatingNews();
        newsStep.selectCategoryFiler(category_1);
        newsStep.emptyTitleEN(newNews);
        newsStep.DateFieldSet(futureDate(1));
        newsStep.TimeFieldSet(futureTimeMinute(1));
        newsStep.DiscriptionSet(newNews);
        newsStep.clickSaveBtn();
        newsStep.checkNewCreatingNewsTitle(newNews);
    }

    @Test
    @Story("Создание новости с оставлением поле заголовок пустым (ID 41)")
    public void shouldEditTitleEmpty() {
        newsStep.openControlPanelSection();
        newsStep.checkControlPanelSectionTitle(controlPanelTitle);
        newsStep.checkCPNewsCard();
        newsStep.openEditingSection();
        newsStep.checkEditingSectionTitle();
        newsStep.replaceTitleEN("");
        newsStep.clickSaveBtn();
        authorizationPage.errorMessageText("Fill empty fields", decorView);
    }

    @Test
    @Story("Создание новости без выбора категории (ID 42)")
    public void shouldCreateNewsEmptyCategory() {
        newsStep.openControlPanelSection();
        newsStep.checkControlPanelSectionTitle(controlPanelTitle);
        newsStep.openCreatingNews();
        newsStep.emptyTitleEN(newNews);
        newsStep.DateFieldSet(futureDate(1));
        newsStep.TimeFieldSet(futureTimeMinute(1));
        newsStep.DiscriptionSet(newNews);
        newsStep.clickSaveBtn();
        authorizationPage.errorMessageText("Fill empty fields", decorView);
    }

    @Test
    @Story("Создание новости без выбора даты публикации (ID 43)")
    public void shouldCreateNewsEmptyDate() {
        newsStep.openControlPanelSection();
        newsStep.checkControlPanelSectionTitle(controlPanelTitle);
        newsStep.openCreatingNews();
        newsStep.selectCategoryFiler(category_1);
        newsStep.emptyTitleEN(newNews);
        newsStep.TimeFieldSet(futureTimeMinute(1));
        newsStep.DiscriptionSet(newNews);
        newsStep.clickSaveBtn();
        authorizationPage.errorMessageText("Fill empty fields", decorView);
    }

    @Test
    @Story("Создание новости с оставлением поле описание пустым (ID 44)")
    public void shouldCreateNewsEmptyDiscription() {
        newsStep.openControlPanelSection();
        newsStep.checkControlPanelSectionTitle(controlPanelTitle);
        newsStep.openCreatingNews();
        newsStep.selectCategoryFiler(category_1);
        newsStep.emptyTitleEN(newNews);
        newsStep.DateFieldSet(futureDate(1));
        newsStep.TimeFieldSet(futureTimeMinute(1));
        newsStep.clickSaveBtn();
        authorizationPage.errorMessageText("Fill empty fields", decorView);
    }

    @Test
    @Story("Изменение новости  из панели редактирования (Control panel) (ID 52)")
    public void shouldEditDiscriptionEN() {
        newsStep.openControlPanelSection();
        newsStep.checkControlPanelSectionTitle(controlPanelTitle);
        newsStep.checkCPNewsCard();
        newsStep.openEditingSection();
        newsStep.checkEditingSectionTitle();
        newsStep.DiscriptionSet(textTitle);
        newsStep.clickSaveBtn();
        newsStep.checkDiscription(textTitle);
    }

    @Test
    @Story("Удаление новости, из панели редактирования (Control panel) (ID 54)")
    public void shouldDeleteNews() {
        newsStep.openControlPanelSection();
        newsStep.checkControlPanelSectionTitle(controlPanelTitle);
        newsStep.checkCPNewsCard();
        newsStep.CPDeleteNews();
        newsStep.checkDeleteCard();
    }
}