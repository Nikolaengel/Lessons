import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommunicationServicesTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        // Автоматическая настройка ChromeDriver
        WebDriverManager.chromedriver().setup();


        // Создание экземпляра ChromeDriver
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void testCommunicationServicesForm() {

        final String service = "Услуги связи";
        final String numberPhone = "297777777";
        final String sum = "250";
        final String email = "test@example.com";

        driver.get("https://www.mts.by/");
        acceptCookiesIfPresent();
        WebElement serviceSelect = driver.findElement(By.id("pay"));
        serviceSelect.sendKeys(service);

        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        phoneInput.sendKeys(numberPhone);

        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.sendKeys(sum);

        WebElement emailInput = driver.findElement(By.id("connection-email"));
        emailInput.sendKeys(email);

        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        continueButton.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("iframe[src*='checkout.bepaid.by']")
        ));
        driver.switchTo().frame(iframe);

        WebElement costCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay-description__cost']/span")
        ));
        String costCheckValue = costCheck.getText().replaceAll("[^\\d.]", "").split("\\.")[0];
        assertEquals(sum, costCheckValue);

        WebElement numberCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay-description__text']/span")
        ));
        String numberCheckValue = numberCheck.getText().replaceAll("\\D", ""); // вырезать только цифры
        assertEquals("375" + numberPhone, numberCheckValue);

        WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(@class, 'colored') and contains(text(), 'Оплатить')]")
        ));
        String buttonText = payButton.getText().replaceAll("[^\\d.]", "").split("\\.")[0];
        assertEquals(sum, buttonText);

        WebElement paymentIcons = driver.findElement(By.cssSelector(".card-page__methods-container"));
        assertTrue(paymentIcons.isDisplayed());

        WebElement creditCardField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[formcontrolname='creditCard']")
        ));
        assertTrue(creditCardField.getAttribute("value").isEmpty());

        WebElement expirationDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[formcontrolname='expirationDate']")
        ));
        assertTrue(expirationDateField.getAttribute("value").isEmpty());

        WebElement cvcField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[formcontrolname='cvc']")
        ));
        assertTrue(cvcField.getAttribute("value").isEmpty());

        WebElement holderField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[formcontrolname='holder']")
        ));
        assertTrue(holderField.getAttribute("value").isEmpty());
    }

    private void acceptCookiesIfPresent() {
        try {

            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("cookie__wrapper") // Замените на реальный ID окна с куки
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