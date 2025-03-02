import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
import org.example.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("MTS Online Payment Tests")
@Feature("Form Validation")
public class MtsOnlinePaymentTests {

    private WebDriver driver;
    private Main mtsOnlinePaymentPage;

    @BeforeEach
    @Step("Set up browser and open MTS website")
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Автоматическая настройка драйвера
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        mtsOnlinePaymentPage = new Main(driver);
    }

    @Test
    @Story("Validate Connection Form Fields")
    @Description("Test to verify that connection form fields are empty by default")
    public void testConnectionFormFieldsEmpty() {
        mtsOnlinePaymentPage.selectOption("Услуги связи");

        assertTrue(mtsOnlinePaymentPage.isConnectionPhoneFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isConnectionSumFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isConnectionEmailFieldEmpty());
    }

    @Test
    @Story("Validate Internet Form Fields")
    @Description("Test to verify that internet form fields are empty by default")
    public void testInternetFormFieldsEmpty() {
        mtsOnlinePaymentPage.selectOption("Домашний интернет");

        assertTrue(mtsOnlinePaymentPage.isInternetPhoneFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isInternetSumFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isInternetEmailFieldEmpty());
    }

    @Test
    @Story("Validate Instalment Form Fields")
    @Description("Test to verify that instalment form fields are empty by default")
    public void testInstalmentFormFieldsEmpty() {
        mtsOnlinePaymentPage.selectOption("Рассрочка");

        assertTrue(mtsOnlinePaymentPage.isInstalmentScoreFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isInstalmentSumFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isInstalmentEmailFieldEmpty());
    }

    @Test
    @Story("Validate Arrears Form Fields")
    @Description("Test to verify that arrears form fields are empty by default")
    public void testArrearsFormFieldsEmpty() {
        mtsOnlinePaymentPage.selectOption("Задолженность");

        assertTrue(mtsOnlinePaymentPage.isArrearsScoreFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isArrearsSumFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isArrearsEmailFieldEmpty());
    }

    @AfterEach
    @Step("Close browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
