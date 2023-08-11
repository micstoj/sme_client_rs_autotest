package stepDefinitions.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SimpleReport;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Objects;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.halcom.properties.Properties.getPropertyValue;

public class Hooks {
    private final SimpleReport report = new SimpleReport();
    //public static String mPayClientPropertyFile = System.getProperty("user.dir") + "/src/main/resources/mPayClient.properties";
    public static String smeClientPropertyFile = System.getProperty("propertypath");

    public static String smeClientDataFile = System.getProperty("user.dir") + "/src/main/resources/SmeClientData_EN.txt";
    public static long TIMEOUT_FOR_ELEMENT_TO_APPEAR = Long.parseLong(getPropertyValue("TIMEOUT_FOR_ELEMENT_TO_APPEAR", smeClientPropertyFile));
    public static String csvFile = getPropertyValue("IMPORT_CSV_PAYMENTS_FOLDER_PATH",smeClientPropertyFile) + "\\PaymentCases_EN.csv";
    public static String selectedLanguage = "en";
    @Before
    public void setup() throws IOException {
        Configuration.browserCapabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--user-data-dir=C:\\Temp\\SelenideChromeData\\");
        options.addArguments("--profile-directory=ChromeData");

        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        //Configuration.browserSize = "1920x1080"; 1680x1050 1600x900 1440x900 1400x1050 1280x1024 1280x960
        Configuration.browserSize = "1440x800";
        //Configuration.browserSize = "1680x1050";
        System.out.println("Loading properties file: " + System.getProperty("propertypath"));


        if(System.getProperty("language") == null || Objects.equals(System.getProperty("language"), "en")){
            smeClientDataFile = System.getProperty("user.dir") + "/src/main/resources/mPayClientData_EN.txt";
        } else if(Objects.equals(System.getProperty("language"), "sl") ){
            smeClientDataFile = System.getProperty("user.dir") + "/src/main/resources/mPayClientData_SL.txt";
            csvFile = getPropertyValue("IMPORT_CSV_PAYMENTS_FOLDER_PATH",smeClientPropertyFile) + "\\PaymentCases_SL.csv";
            selectedLanguage="sl";
        }
        System.out.println("Selected file with translation is: " + smeClientDataFile);


    }

    public static Scenario runningScenario;
    @Before
    public void beforeTest(Scenario scenario) throws Exception {
        scenario.log("Starting " + scenario.getName());
        runningScenario = scenario;
        report.start();
    }

    @After
    public void afterTest(Scenario scenario) {
        scenario.log("Finished " + scenario.getName());
        runningScenario = scenario;
        report.finish(scenario.getName());
    }


    //if the scenario is unsuccessful make a screenshot in html report
    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) getWebDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", timeMilliseconds);
        }

    }
}
