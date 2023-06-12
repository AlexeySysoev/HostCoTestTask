package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Utils;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.enabled;

public class ProfilePage {
    @FindBy(how = How.XPATH, using = ".//a[text()='Разное']")
    SelenideElement otherButton;
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Записать показатель')]")
    SelenideElement recordIndicatorButton;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'dropdown ui-dropdown')]")
    SelenideElement choiceIndicatorSelector;
    @FindBy(how = How.XPATH, using = ".//li[contains(@aria-label,'Температура')]")
    SelenideElement liChoiseIndicatorSelector;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'ui-dialog-content')]//div[contains(@class,'ui-g-6')]//input")
    ElementsCollection indicatorInputs;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'ui-dialog-content')]//textarea")
    ElementsCollection indicatorTextareas;

    @FindBy(how = How.XPATH, using = ".//span[contains(@class,'create-date-calendar')]")
    SelenideElement dateAndTimeCalendar;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'ui-dialog-content')]//button[@type='submit']")
    SelenideElement saveButtonHealthRecordForm;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'ui-toast-message-content')]//div[text()='Успешно']")
    SelenideElement popupSuccessMessage;
    @FindBy(how = How.XPATH, using = ".//div[@class='row mychildren ng-star-inserted']//a[contains(text(),'Удалить')]")
    SelenideElement deleteIndicatorButton;
    @FindBy(how = How.XPATH, using = ".//div[@class='row mychildren ng-star-inserted']//a[contains(text(),'Редактировать')]")
    SelenideElement editIndicatorButton;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'ui-dialog-footer')]//button[contains(text(),'Да')]")
    SelenideElement yesDeleteConfirmButton;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'ui-dialog-footer')]//button[contains(text(),'Нет')]")
    SelenideElement noDeleteConfirmButton;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'ui-dialog-content')]//input[contains(@class,'create-date')]")
    SelenideElement editTimeOfIndicator;
    // для инпутов редактирования записи
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'ui-dialog-content')]//div[contains(@class,'ui-g-6')]//input")
    SelenideElement editIndicatorInput;
    //для текстэрии редактирования записи
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'ui-dialog-content')]//div[contains(@class,'ui-g-6')]//textarea")
    SelenideElement editIndicatorTextArea;
    @FindBy(how = How.XPATH, using = ".//a[contains(@class,'ui-toast-close-icon')]")
    SelenideElement closeSuccessPopupButton;
    @FindBy(how = How.XPATH, using = ".//b[text()='Сохранить']/parent::button")
    SelenideElement saveButtonEditIndicatorForm;

    public void otherButtonClick(){
        otherButton.click();
    }
    public SelenideElement getSaveButtonEditIndicatorForm() {
        return saveButtonEditIndicatorForm;
    }
    public SelenideElement getCloseSuccessPopupButton() {
        return closeSuccessPopupButton;
    }
    public SelenideElement getChoiseIndicatorSelector() {
        return choiceIndicatorSelector;
    }
    public SelenideElement getLiChoiseIndicatorSelector() {
        return liChoiseIndicatorSelector;
    }
    public SelenideElement getEditIndicatorTextArea(){
        return editIndicatorTextArea;
    }
    public SelenideElement getEditIndicatorInput(){
        return editIndicatorInput;
    }
    public SelenideElement getEditTimeOfIndicator(){
        return editTimeOfIndicator;
    }
    public SelenideElement getNoDeleteConfirmButton(){
        return noDeleteConfirmButton;
    }
    public SelenideElement getYesDeleteConfirmButton(){
        return yesDeleteConfirmButton;
    }
    public SelenideElement getEditIndicatorButton(){
        return editIndicatorButton;
    }
    public SelenideElement getDeleteIndicatorButton(){
        return deleteIndicatorButton;
    }
    public SelenideElement getPopupSuccessMessage(){
        return popupSuccessMessage;
    }
    public SelenideElement getReadIndicatorButton(){
        return recordIndicatorButton;
    }
    public SelenideElement getDateAndTimeCalendar(){
        return dateAndTimeCalendar;
    }
    public SelenideElement getSaveButtonHealthRecordForm(){
        return saveButtonHealthRecordForm;
    }
    public void selectIndicatorFromSelector(){
        getChoiseIndicatorSelector().click();
        getLiChoiseIndicatorSelector().click();
    }
    public void cancelDeletingRecord() {
        Utils.scrollToElement(getDeleteIndicatorButton());
        getDeleteIndicatorButton().pressEnter();
        getNoDeleteConfirmButton().click();
    }
    public void deleteIndicatorFromStory(){
        Utils.scrollToElement(getDeleteIndicatorButton());
        getDeleteIndicatorButton().pressEnter();
        getYesDeleteConfirmButton().click();
    }
    public void setEditIndicatorValue(String value){
        if (getEditIndicatorInput().isDisplayed()) {
            getEditIndicatorInput().setValue(value);
        } else if (getEditIndicatorTextArea().isDisplayed()) {
            getEditIndicatorTextArea().setValue(value);
        } else System.out.println("Нет поля для ввода значения!");
    }
    public void setAllIndicatorInputs(HashMap<String,String> testData){
        recordIndicatorButton.click();
        setTemperatureInput(testData.get("temperature"));
        setWeightInput(testData.get("weight"));
        setPressure1(testData.get("pressure1"));
        setPressure2(testData.get("pressure2"));
        setSugarLevel(testData.get("sugar"));
        setPulse(testData.get("pulse"));
        setAlcoholLevel(testData.get("alcohol"));
        setAmbivalent(testData.get("ambivalent"));
        setMood(testData.get("mood"));
        setGeneralHealthLevel(testData.get("generalHealthLevel"));
        setSkinCondition(testData.get("skinCondition"));
        getSaveButtonHealthRecordForm().click();
    }
    public void setTemperatureInput(String temperature){
        indicatorInputs.get(0).setValue(temperature);
    }
    public void setWeightInput(String weight){
        indicatorInputs.get(1).setValue(weight);
    }
    public void setPressure1(String pressure1){
        indicatorInputs.get(2).setValue(pressure1);
    }
    public void setPressure2(String pressure2){
        indicatorInputs.get(3).setValue(pressure2);
    }
    public void setSugarLevel(String sugarLevel){
        indicatorInputs.get(4).setValue(sugarLevel);
    }
    public void setPulse(String pulse){
        indicatorInputs.get(5).setValue(pulse);
    }
    public void setAlcoholLevel(String alcoholLevel){
        indicatorInputs.get(6).setValue(alcoholLevel);
    }
    public void setAmbivalent(String ambivalention){
        indicatorInputs.get(7).setValue(ambivalention);
    }
    public void setMood(String mood){
        indicatorTextareas.get(0).setValue(mood);
    }
    public void setGeneralHealthLevel(String healthLevel){
        indicatorTextareas.get(1).setValue(healthLevel);
    }
    public void setSkinCondition(String skinCondition){
        indicatorTextareas.get(2).setValue(skinCondition);
    }


}
