package stepDefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Cookie;
import pageObjects.LoginPagePO;
import stepDefinitions.base.RobotThread;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.halcom.properties.Properties.getPropertyValue;
import static com.halcom.properties.Properties.robotThreadStarted;
import static stepDefinitions.base.Hooks.*;

public class LoginPageSteps {
    LoginPagePO loginPage = new LoginPagePO();

    @Given("go to the SME Client login page at the @URL")
    public void go_to_the_sme_client_login_page_at_the_url() throws Exception {
        if(!robotThreadStarted) {
            new RobotThread();
            robotThreadStarted = true;
        }
        open(getPropertyValue("URL", smeClientPropertyFile));

        //select appropriate language (default is EN, for SR run with external param -Dlanguage=sr )
        loginPage.serbianTextButton.shouldBe(Condition.visible,Duration.ofSeconds(TIMEOUT_FOR_ELEMENT_TO_APPEAR));
        loginPage.serbianTextButton.click();
        Cookie ck = getWebDriver().manage().getCookieNamed("lang");

        if(!selectedLanguage.equals(ck.toString())){
            switch (selectedLanguage) {
                case "sr" -> loginPage.serbianTextButton.click();
                case "en" -> loginPage.englishTextButton.click();
            }
        }

    }

    @And("click on the PASSWORD button for login with username and password")
    public void clickOnThePASSWORDButtonForLoginWithUsernameAndPassword() {
        loginPage.loginWithPasswordButton.shouldBe(Condition.visible, Duration.ofSeconds(TIMEOUT_FOR_ELEMENT_TO_APPEAR));
        loginPage.loginWithPasswordButton.click();
    }

    @And("type @username and @password and press Continue button")
    public void typeUsernameAndPasswordAndPressContinueButton() {
        loginPage.usernameInputField.shouldBe(Condition.visible, Duration.ofSeconds(TIMEOUT_FOR_ELEMENT_TO_APPEAR));
        loginPage.passwordInputField.shouldBe(Condition.visible, Duration.ofSeconds(TIMEOUT_FOR_ELEMENT_TO_APPEAR));
        loginPage.usernameInputField.click();
        loginPage.usernameInputField.sendKeys("Karic244570");
        loginPage.passwordInputField.click();
        loginPage.passwordInputField.sendKeys("123456");
        loginPage.loginButton.shouldBe(Condition.visible, Duration.ofSeconds(TIMEOUT_FOR_ELEMENT_TO_APPEAR));
        loginPage.loginButton.click();
    }

    @And("type OTP for login & press the Login button or just press Login button \\(if bank doesnt use OTP for login)")
    public void typeOTPForLoginPressTheLoginButtonOrJustPressLoginButtonIfBankDoesntUseOTPForLogin() {
        
    }

    @Then("Profile icon should be visible and contain Logout button")
    public void profileIconShouldBeVisibleAndContainLogoutButton() throws InterruptedException {
        loginPage.userProfileIcon.shouldBe(Condition.visible, Duration.ofSeconds(TIMEOUT_FOR_ELEMENT_TO_APPEAR));
        loginPage.userProfileIcon.click();
        System.out.println("dugme je : " + loginPage.userProfileIcon1);
        Thread.sleep(3000);
        loginPage.userProfileProfileButton.shouldBe(Condition.visible, Duration.ofSeconds(TIMEOUT_FOR_ELEMENT_TO_APPEAR));
        loginPage.userProfileLogoutButton.shouldBe(Condition.visible, Duration.ofSeconds(TIMEOUT_FOR_ELEMENT_TO_APPEAR));
        loginPage.userProfileLogoutButton.click();

    }
}
