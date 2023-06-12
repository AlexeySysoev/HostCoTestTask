package healthindicatorstest;

import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ProfilePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class HealthIndicatorsTest {
    private final String USER_NAME = "71450643575";
    private final String PASSWORD = "123";
    private final String BASE_URL = "https://pp86.hostco.ru/";
//    @BeforeEach
//    public void preSet(){
//
//
//    }
    @Test
    @DisplayName("Проверка успешного входа во вкладку 'Показатели здоровья' в личном кабинете")
    @Description("авторизация в ЛК с уже существующим профилем и переход на вкладку 'Показатели здоровья'")
    public void healthIndicatorsTabIsSuccessfullOpen(){
        MainPage mainPage = open(BASE_URL, MainPage.class);
        mainPage.signIn(USER_NAME,PASSWORD);
        ProfilePage profilePage = mainPage.profilePageButtonClick();
        profilePage.otherButtonClick();
        profilePage.getReadIndicatorButton().shouldBe(enabled);
    }
    @Test
    @DisplayName("Проверка работы селектора индикаторов здоровья")
    @Description("Переключаемся по элементам селектора и проверяем содержимое вкладки")
    public void changeSelectorIndicatorsViewActualIndicator(){

    }
    @Test
    @DisplayName("Проверка успешного создания новой записи")
    public void addNewRecordHealthIndicatorsIsOk(){
        MainPage mainPage = open(BASE_URL, MainPage.class);
        mainPage.signIn(USER_NAME,PASSWORD);
        ProfilePage profilePage = mainPage.profilePageButtonClick();
        profilePage.otherButtonClick();
        profilePage.getReadIndicatorButton().shouldBe(enabled);
        //profilePage.setAllIndicatorInputs();
        profilePage.getPopupSuccessMessage().shouldBe(visible);
    }
    @Test
    @DisplayName("Успешное удаление показателя")
    public void deleteRecordIsSuccess(){
        MainPage mainPage = open(BASE_URL, MainPage.class);
        mainPage.signIn(USER_NAME,PASSWORD);
        ProfilePage profilePage = mainPage.profilePageButtonClick();
        profilePage.otherButtonClick();
        profilePage.getReadIndicatorButton().shouldBe(enabled);
        //profilePage.setAllIndicatorInputs();
        profilePage.getPopupSuccessMessage().shouldBe(visible);

    }
    @Test
    @DisplayName("Отмена удаления записи")
    @Description("Нажимаем удалить запись, в модальном окне выбираем 'нет'")
    public void cancelDeletingRecordCheck(){

    }
    @Test
    @DisplayName("Проверка работы выборки по дате")
    @Description("Выбираем диапазон и сверяем результат с выводом данных на экране")
    public void dateSelectorViewCorrectData(){

    }
    @Test
    @DisplayName("Проверка настройки пороговых значений")
    @Description("меняем настройки и вводим значения внутри диапазона и за его границами")
    public void limitsOfHealthValuesCheck(){}
    @Test
    @DisplayName("Переключение страниц отображения показателей в пагинаторе")
    @Description("Нажимаем на номера страничек в пагинаторе")
    public void paginationSelectorSwitchToSelectedPage(){

    }
    @Test
    @DisplayName("Переключение страниц отображения показателей в пагинаторе кнопкой 'Вперед'")
    @Description("Нажимаем на кнопку 'Вперед' пагинаторе")
    public void nextButtonInPagginatorSwithToNextPage(){

    }
    @Test
    @DisplayName("Переключение страниц отображения показателей в пагинаторе кнопкой 'Назад'")
    @Description("Нажимаем на кнопку 'Назад' пагинаторе")
    public void backButtonInPagginatorSwithToPreviousPage(){

    }
    @Test
    @DisplayName("Проверка работы селектора отображения количества записей на странице")
    @Description("Переключение селектора и подсчет записей на странице")
    public void recordsCountSelectorViewCorrectCount(){

    }
    @AfterEach
    public void postSet(){
        Configuration.holdBrowserOpen = true;
    }
}
