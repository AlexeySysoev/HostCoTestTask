package healthindicatorstest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import pages.MainPage;
import pages.ProfilePage;
import utils.PrepareTestData;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HealthsIndicatorsTest {

    private ProfilePage profilePage;
    private final String USER_NAME = "71450643575";
    private final String PASSWORD = "123";
    private final String BASE_URL = "https://pp86.hostco.ru/";
    private PrepareTestData prepareTestData = new PrepareTestData();
    private HashMap<String, String> testData = prepareTestData.getIndicatorsTestData();

    @BeforeEach
    public void preSet() {
        Configuration.holdBrowserOpen = true;
        MainPage mainPage = open(BASE_URL, MainPage.class);
        mainPage.signIn(USER_NAME, PASSWORD);
        profilePage = mainPage.profilePageButtonClick();
        profilePage.otherButtonClick();
    }

    @Test
    @DisplayName("Проверка успешного входа во вкладку 'Показатели здоровья' в личном кабинете")
    @Description("авторизация в ЛК с уже существующим профилем и переход на вкладку 'Показатели здоровья'")
    public void healthIndicatorsTabIsSuccessfullOpen() {
        profilePage.getReadIndicatorButton().shouldBe(enabled);
    }


    @ParameterizedTest
    @ValueSource(strings = {"Температура", "Вес", "Давление", "Уровень сахара в крови",
            "Пульс", "Настроение", "Алкоголь в крови", "Амбивалентность",
            "Общее состояние здоровья", "Состояние кожных покровов"})
    @DisplayName("Проверка работы селектора индикаторов здоровья")
    @Description("Переключаемся по элементам селектора и проверяем содержимое вкладки")
    public void changeSelectorIndicatorsViewActualIndicator(String item) throws InterruptedException {
        //создание показателей
        profilePage.setAllIndicatorInputs(testData);
        profilePage.getPopupSuccessMessage().shouldBe(visible);
        //выбор показателя из списка селектора
        profilePage.getChoiseIndicatorSelector().click();
        $(By.xpath(String.format(".//li[contains(@aria-label,'%s')]", item))).click();
        Thread.sleep(200);
        ElementsCollection indicatorsFromTablePage = $$(By.xpath(".//div[@class='col indicator']/child::div[@class='sml break-word']"));
        for (SelenideElement selenideElement : indicatorsFromTablePage) {
            assertTrue(selenideElement.getText().equals(item));
        }
    }

    @Test
    @DisplayName("Проверка успешного создания новой записи")
    public void addNewRecordHealthIndicatorsIsOk() {
        profilePage.setAllIndicatorInputs(testData);
        profilePage.getPopupSuccessMessage().shouldBe(visible);
    }

    @Test
    @DisplayName("Редактирование записи")
    @Description("Тест в стадии разработки")
    public void editHealthIndicatorRecordIsOk() {
        //создаем показатель
        profilePage.getReadIndicatorButton().click();
        profilePage.setTemperatureInput(prepareTestData.getIntValueFromRange(340, 420));
        profilePage.getSaveButtonHealthRecordForm().click();
        profilePage.getCloseSuccessPopupButton().click();
        //выбор показателя
        String indicatorName = "Температура";
        profilePage.selectIndicatorFromSelector(indicatorName);

        profilePage.getEditIndicatorButton().click();
        profilePage.getEditIndicatorInput().clear();
        String valueForChange = prepareTestData.getIntValueFromRange(340, 420);
        profilePage.getEditIndicatorInput().setValue(valueForChange);
        profilePage.getSaveButtonEditIndicatorForm().click();
        String valueFromPage = $(By.xpath(".//div[@class='sml break-word']/span")).getText();
        System.out.println("Значение для замены " + valueForChange + "Значение со страницы: " + valueFromPage);
        //assertTrue(valueForChange.equals(valueFromPage));
    }

    @Test
    @DisplayName("Успешное удаление показателя")
    @Description("удаление происходит, но нет факта подтверждения")
    public void deleteRecordIsSuccess() {
        //создаем показатель
        profilePage.getReadIndicatorButton().click();
        profilePage.setTemperatureInput(prepareTestData.getIntValueFromRange(340, 420));
        profilePage.getSaveButtonHealthRecordForm().click();
        //удаление показателя
        profilePage.deleteIndicatorFromStory();
    }

    @Test
    @DisplayName("Отмена удаления записи")
    @Description("Нажимаем удалить запись, в модальном окне выбираем 'нет'. " +
            "нет факта подтверждения отмены удаления")
    public void cancelDeletingRecordCheck() {
        //создаем показатель
        profilePage.getReadIndicatorButton().click();
        profilePage.setTemperatureInput(prepareTestData.getIntValueFromRange(340, 420));
        profilePage.getSaveButtonHealthRecordForm().click();
        //отмена удаления показателя
        profilePage.cancelDeletingRecord();
    }

    @Test
    @Disabled
    @DisplayName("Проверка работы выборки по дате")
    @Description("Выбираем диапазон и сверяем результат с выводом данных на экране")
    public void dateSelectorViewCorrectData() {

    }

    @Test
    @Disabled
    @DisplayName("Проверка настройки пороговых значений")
    @Description("меняем настройки и вводим значения внутри диапазона и за его границами")
    public void limitsOfHealthValuesCheck() {
    }

    @Test
    @Disabled
    @DisplayName("Переключение страниц отображения показателей в пагинаторе")
    @Description("Нажимаем на номера страничек в пагинаторе")
    public void paginationSelectorSwitchToSelectedPage() {

    }

    @Test
    @Disabled
    @DisplayName("Переключение страниц отображения показателей в пагинаторе кнопкой 'Вперед'")
    @Description("Нажимаем на кнопку 'Вперед' пагинаторе")
    public void nextButtonInPagginatorSwithToNextPage() {

    }

    @Test
    @Disabled
    @DisplayName("Переключение страниц отображения показателей в пагинаторе кнопкой 'Назад'")
    @Description("Нажимаем на кнопку 'Назад' пагинаторе")
    public void backButtonInPagginatorSwithToPreviousPage() {

    }

    @Test
    @Disabled
    @DisplayName("Проверка работы селектора отображения количества записей на странице")
    @Description("Переключение селектора и подсчет записей на странице")
    public void recordsCountSelectorViewCorrectCount() {

    }

    @AfterEach
    public void postSet() {
        WebDriverRunner.getWebDriver().quit();
    }
}
