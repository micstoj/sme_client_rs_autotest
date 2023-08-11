package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPagePO {
    public SelenideElement loginWithPasswordButton = $x("/html/body/div/div[1]/div[2]/div/div[1]/div/div[1]/ul/li[1]/a");
    public SelenideElement loginWithCertificatesButton = $x("/html/body/div/div[1]/div[2]/div/div[1]/div/div[1]/ul/li[1]/a");



    public SelenideElement usernameInputField = $(Selectors.by("id", "visiblej_username"));
    public SelenideElement passwordInputField = $(Selectors.by("id", "visiblej_password"));

    public SelenideElement serbianTextButton = $x("/html/body/div/div[1]/div[2]/div/div[2]/a[1]");
    public SelenideElement englishTextButton = $x("/html/body/div/div[1]/div[2]/div/div[2]/a[2]");

    public SelenideElement loginButton = $x("/html/body/div/div[1]/div[2]/div/div[1]/div/div[2]/div[1]/form/button");

    public SelenideElement userProfileIcon = $(Selectors.by("id", "profileSelector"));
    public ElementsCollection userProfileIcon1 = $$("ul.dropdown-menu>li:first-child");

    public SelenideElement userProfileProfileButton = $x("/html/body/nav/div/div[1]/ul[3]/li[3]/ul/li[1]/a");

    public SelenideElement userProfileLogoutButton = $x("/html/body/nav/div/div[1]/ul[3]/li[3]/ul/li[2]/a");





}
