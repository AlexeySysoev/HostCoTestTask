package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {
    @FindBy(how = How.XPATH, using = ".//a[text()='Разное']")
    SelenideElement otherButton;
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Записать показатель')]")
    SelenideElement recordIndicatorButton;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'dropdown ui-dropdown')]")
    SelenideElement choiceIndicatorSelector;
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

    public void otherButtonClick(){
        otherButton.click();
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
    public void setAllIndicatorInputs(){
        recordIndicatorButton.click();
        setTemperatureInput("366");
        setWeightInput("90");
        setPressure1("120");
        setPressure2("70");
        setSugarLevel("235");
        setPulse("100");
        setAlcoholLevel("4");
        setAmbivalention("55");
        setMood("Напряженно приподнятое");
        setGeneralHealthLevel("нормальное здоровое состояние");
        setSkinCondition("кожные покровы чистые");
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
    public void setAmbivalention(String ambivalention){
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
