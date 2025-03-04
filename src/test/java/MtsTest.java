import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://mts.by");

    }

    @Test
    public void testBlockTitle() {
        acceptCookiesIfPresent();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(.,'Онлайн пополнение') and contains(.,'без комиссии')]")
        ));

        assertNotNull(blockTitle, "Название блока не найдено");
        assertEquals("Онлайн пополнение\nбез комиссии", blockTitle.getText().trim(), "Название блока не совпадает");
    }


    @Test
    public void testPaymentSystemLogos() {
        acceptCookiesIfPresent();

        List<WebElement> logos = driver.findElements(By.xpath("//selector_логотипов"));
        assertTrue(logos.isEmpty(), "Логотипы платёжных систем найдены, хотя ожидалось их отсутствие");

    }

    @Test
    public void testMoreAboutServiceLink() {
        acceptCookiesIfPresent();
        WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Подробнее о сервисе')]"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);

        link.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));

        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl(), "Страница не изменилась на ожидаемую");
    }




    @Test
    public void testModalWindow() {

        acceptCookiesIfPresent();
        WebElement serviceField = driver.findElement(By.id("pay"));
        serviceField.sendKeys("Услуги связи");

        WebElement phoneNumberField = driver.findElement(By.id("connection-phone"));
        phoneNumberField.sendKeys("297777777");

        WebElement countNumberField = driver.findElement(By.id("connection-sum"));
        countNumberField.sendKeys("250");

        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        continueButton.click();

        WebElement popupElement = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-app"))); // Используйте правильный селектор для всплывающего окна

        assertNotNull(popupElement, "Всплывающее окно не появилось на странице.");
    }

    private void acceptCookiesIfPresent() {
        try {

            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("cookie__wrapper")
            ));

            WebElement acceptButton = cookieBanner.findElement(By.id("cookie-agree"));

            acceptButton.click();
            System.out.println("Окно с куки найдено, кнопка 'Принять' нажата.");
        } catch (Exception e) {

            System.out.println("Окно с куки не появилось или не удалось найти кнопку 'Принять'.");
        }
    }


    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
