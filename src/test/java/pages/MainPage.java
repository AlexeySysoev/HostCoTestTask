package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Личный кабинет')]/parent::a")
    SelenideElement profilePageButton;
    @FindBy(how = How.XPATH, using = ".//a[contains(@class,'menu-show-button')]")
    SelenideElement userMenuButton;
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Войти в кабинет')]")
    SelenideElement loginButton;
    @FindBy(how = How.XPATH, using = ".//input[@id = 'username']")
    SelenideElement userNameField;
    @FindBy(how = How.XPATH, using = ".//input[@id = 'password']")
    SelenideElement passwordField;
    @FindBy(how = How.XPATH, using = ".//input[@name = 'login']")
    SelenideElement signInButton;
    public ProfilePage profilePageButtonClick(){
        userMenuButtonClick();
        profilePageButton.click();
        return page(ProfilePage.class);
    }
    public void userMenuButtonClick(){
        userMenuButton.click();
    }
    public void loginButtonClick(){
        loginButton.click();
    }
    public void setUserNameField(String userName){
        userNameField.setValue(userName);
    }
    public void setPasswordField(String password){
        passwordField.setValue(password);
    }
    public void signInButtonClick(){
        signInButton.click();
    }
    public void signIn(String userName, String password){
        loginButtonClick();
        setUserNameField(userName);
        setPasswordField(password);
        signInButtonClick();
    }
}
