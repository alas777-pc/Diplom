package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import static ru.iteco.fmhandroid.elements.NewsPage.CPNewsCardTitle;

import static ru.iteco.fmhandroid.elements.NewsPage.NewCPTitleNews;


import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.data.WaitId;
import ru.iteco.fmhandroid.elements.NewsPage;

public class NewsStep extends DataHelper {
    NewsPage newsPage = new NewsPage();
    WaitId waitId = new WaitId();

    public void checkNewsPageTitle() {
        Allure.step("Проверка отображения заголовка страницы 'News'");
        waitId.waitUntilElement(R.id.container_list_news_include);
        newsPage.NewsPageTitle.check(matches(withText("News")));
    }


    public void selectCategoryFiler(String category) {
        Allure.step("Выбор категории из выпадающего списка");
        waitId.waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        newsPage.OpenCategoryList.perform(click(), closeSoftKeyboard());
        waitId.waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        newsPage.SelectCategoryFromList(category);
    }


    public void openControlPanelSection() {
        Allure.step("Открытие раздела 'Control panel'");
        waitId.waitUntilElement(R.id.edit_news_material_button);
        newsPage.ControlPanel.perform(click());
    }


    public void checkControlPanelSectionTitle(String title) {
        Allure.step("Проверка открытия раздела 'Control panel'");
        waitId.waitUntilElement(title);
        newsPage.ControlPanelTitle.check(matches(withText(title)));
    }


    public void checkCPNewsCard() {
        Allure.step("Проверка наличия карточек новостей в разделе 'Control panel'");
        waitId.waitUntilElement(R.id.news_item_material_card_view);
        newsPage.CPNewsCard.check(matches(isDisplayed()));
    }


    public void CPDeleteNews() {
        Allure.step("Удаление новости");
        waitId.waitUntilElement(R.id.delete_news_item_image_view);
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
        waitId.waitUntilElement(R.id.custom_app_bar_title_text_view);
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
        waitId.waitUntilElement(R.id.news_item_description_text_input_edit_text);
        newsPage.DiscriptionFieldEN.perform(replaceText(text));
    }


    public void checkDiscription(String text) {
        Allure.step("Проверка открытия описания");
        waitId.waitUntilElement(R.id.news_list_recycler_view);
        newsPage.openDiscription.perform(click());
        waitId.waitUntilElement(R.id.news_item_description_text_view);
        newsPage.DiscriptionEN.check(matches(withText(text)));
    }


    public void clickSaveBtn() {
        Allure.step("Нажатие кнопки Save");
        newsPage.ENSaveBtn.perform(click());
    }


    public void openCreatingNews() {
        Allure.step("Открытие раздела 'Creating news'");
        waitId.waitUntilElement(R.id.add_news_image_view);
        newsPage.CreatingNewsBtn.perform(click());
    }


    public void checkNewCreatingNewsTitle(String text) {
        Allure.step("Заголовок раздела 'Creating news'");
        waitId.waitUntilElement(R.id.news_item_title_text_view);
        NewCPTitleNews(text);
    }


}