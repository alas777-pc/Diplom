package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.data.WaitId.waitUntilElement;
import static ru.iteco.fmhandroid.elements.NewsPage.CPDeleteBtn;
import static ru.iteco.fmhandroid.elements.NewsPage.CPDialogWinOKBtn;
import static ru.iteco.fmhandroid.elements.NewsPage.CPDialogWindow;
import static ru.iteco.fmhandroid.elements.NewsPage.CPNewsCard;
import static ru.iteco.fmhandroid.elements.NewsPage.CPNewsCardChecking;
import static ru.iteco.fmhandroid.elements.NewsPage.CPNewsCardTitle;
import static ru.iteco.fmhandroid.elements.NewsPage.ControlPanel;
import static ru.iteco.fmhandroid.elements.NewsPage.ControlPanelTitle;
import static ru.iteco.fmhandroid.elements.NewsPage.CreatingNewsBtn;
import static ru.iteco.fmhandroid.elements.NewsPage.DateField;
import static ru.iteco.fmhandroid.elements.NewsPage.DiscriptionEN;
import static ru.iteco.fmhandroid.elements.NewsPage.DiscriptionFieldEN;
import static ru.iteco.fmhandroid.elements.NewsPage.ENSaveBtn;
import static ru.iteco.fmhandroid.elements.NewsPage.EditingBtn;
import static ru.iteco.fmhandroid.elements.NewsPage.EditingSectionTitle;
import static ru.iteco.fmhandroid.elements.NewsPage.NewCPTitleNews;
import static ru.iteco.fmhandroid.elements.NewsPage.NewsPageTitle;
import static ru.iteco.fmhandroid.elements.NewsPage.OpenCategoryList;
import static ru.iteco.fmhandroid.elements.NewsPage.Switcher;
import static ru.iteco.fmhandroid.elements.NewsPage.TimeField;
import static ru.iteco.fmhandroid.elements.NewsPage.TitleField;
import static ru.iteco.fmhandroid.elements.NewsPage.openDiscription;
import static ru.iteco.fmhandroid.elements.NewsPage.textInputEditText;


import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.DataHelper;
import ru.iteco.fmhandroid.elements.NewsPage;

public class NewsStep extends DataHelper {
    //Проверка отображения заголовка страницы "News"
    public static void checkNewsPageTitle() {
        waitUntilElement(R.id.container_list_news_include);
        NewsPageTitle.check(matches(withText("News")));
    }


    public static void selectCategoryFiler(String category) {
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        OpenCategoryList.perform(click(), closeSoftKeyboard());
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        NewsPage.SelectCategoryFromList(category);
    }


    public static void openControlPanelSection() {
        waitUntilElement(R.id.edit_news_material_button);
        ControlPanel.perform(click());
    }


    public static void checkControlPanelSectionTitle(String title) {
        waitUntilElement(title);
        ControlPanelTitle.check(matches(withText(title)));
    }


    public static void checkCPNewsCard() {
        waitUntilElement(R.id.news_item_material_card_view);
        CPNewsCard.check(matches(isDisplayed()));
    }


    public static void CPDeleteNews() {
        waitUntilElement(R.id.delete_news_item_image_view);
        CPNewsCardTitle();
        CPDeleteBtn.perform(click());
        CPDialogWindow.check(matches(isDisplayed()));
        CPDialogWinOKBtn.perform(click());
    }


    public static void checkDeleteCard() {
        CPNewsCardChecking.check(matches(not(withText(CPNewsCardTitle()))));
    }


    public static void openEditingSection() {
        EditingBtn.perform(click());
    }


    public static void checkEditingSectionTitle() {
        waitUntilElement(R.id.custom_app_bar_title_text_view);
        EditingSectionTitle.check(matches(isDisplayed()));
    }


    public static void replaceTitleEN(String title) {
        TitleField.perform(click());
        TitleField.perform(replaceText(title), closeSoftKeyboard());
    }


    public static void emptyTitleEN(String text) {
        textInputEditText.perform(click());
        textInputEditText.perform(clearText());
        textInputEditText.perform(replaceText(text), closeSoftKeyboard());
    }


    public static void DateFieldSet(String date) {
        DateField.perform(replaceText(date));
    }


    public static void TimeFieldSet(String time) {
        TimeField.perform(replaceText(time));
    }


    public static void DiscriptionSet(String text) {
        waitUntilElement(R.id.news_item_description_text_input_edit_text);
        DiscriptionFieldEN.perform(replaceText(text));
    }


    public static void checkDiscription(String text) {
        waitUntilElement(R.id.news_list_recycler_view);
        openDiscription.perform(click());
        waitUntilElement(R.id.news_item_description_text_view);
        DiscriptionEN.check(matches(withText(text)));
    }


    public static void clickSaveBtn() {
        ENSaveBtn.perform(click());
    }


    public static void openCreatingNews() {
        waitUntilElement(R.id.add_news_image_view);
        CreatingNewsBtn.perform(click());
    }


    public static void checkNewCreatingNewsTitle(String text) {
        waitUntilElement(R.id.news_item_title_text_view);
        NewCPTitleNews(text);
    }


    public static void checkSwitchCN() {
        waitUntilElement(R.id.switcher);
        Switcher.check(matches(isEnabled()));
    }

}