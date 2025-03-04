import org.example.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class MtsOnlinePaymentTest {

    private WebDriver driver;
    private Main mtsOnlinePaymentPage;
    private WebDriverWait wait;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.mts.by/");

        mtsOnlinePaymentPage = new Main(driver);
    }

    @Test
    public void testConnectionFormFieldsEmpty() {
        acceptCookiesIfPresent();
        mtsOnlinePaymentPage.selectOption("Услуги связи");

        assertTrue(mtsOnlinePaymentPage.isConnectionPhoneFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isConnectionSumFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isConnectionEmailFieldEmpty());
    }

    @Test
    public void testInternetFormFieldsEmpty() {
        acceptCookiesIfPresent();
        mtsOnlinePaymentPage.selectOption("Домашний интернет");

        assertTrue(mtsOnlinePaymentPage.isInternetPhoneFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isInternetSumFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isInternetEmailFieldEmpty());
    }

    @Test
    public void testInstalmentFormFieldsEmpty() {
        acceptCookiesIfPresent();
        mtsOnlinePaymentPage.selectOption("Рассрочка");

        assertTrue(mtsOnlinePaymentPage.isInstalmentScoreFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isInstalmentSumFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isInstalmentEmailFieldEmpty());
    }

    @Test
    public void testArrearsFormFieldsEmpty() {
        acceptCookiesIfPresent();
        mtsOnlinePaymentPage.selectOption("Задолженность");

        assertTrue(mtsOnlinePaymentPage.isArrearsScoreFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isArrearsSumFieldEmpty());
        assertTrue(mtsOnlinePaymentPage.isArrearsEmailFieldEmpty());
    }

    private void acceptCookiesIfPresent() {
        try {

            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("cookie__wrapper") // Локатор окна с куки
            ));

            WebElement acceptButton = cookieBanner.findElement(By.id("cookie-agree"));

            acceptButton.click();
            System.out.println("Окно с куки найдено, кнопка 'Принять' нажата.");
        } catch (Exception e) {

            System.out.println("Окно с куки не появилось или не удалось найти кнопку 'Принять'.");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}