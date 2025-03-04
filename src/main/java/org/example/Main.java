package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Main {

    // Точка входа в программу
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    // Логика страницы MtsOnlinePaymentPage
    private WebDriver driver;

    // Локаторы
    @FindBy(id = "pay")
    private WebElement selectElement;

    @FindBy(id = "connection-phone")
    private WebElement connectionPhoneField;

    @FindBy(id = "connection-sum")
    private WebElement connectionSumField;

    @FindBy(id = "connection-email")
    private WebElement connectionEmailField;

    @FindBy(id = "internet-phone")
    private WebElement internetPhoneField;

    @FindBy(id = "internet-sum")
    private WebElement internetSumField;

    @FindBy(id = "internet-email")
    private WebElement internetEmailField;

    @FindBy(id = "score-instalment")
    private WebElement instalmentScoreField;

    @FindBy(id = "instalment-sum")
    private WebElement instalmentSumField;

    @FindBy(id = "instalment-email")
    private WebElement instalmentEmailField;

    @FindBy(id = "score-arrears")
    private WebElement arrearsScoreField;

    @FindBy(id = "arrears-sum")
    private WebElement arrearsSumField;

    @FindBy(id = "arrears-email")
    private WebElement arrearsEmailField;

    // Конструктор
    public Main(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Методы для работы с элементами страницы
    public void selectOption(String optionText) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(optionText);
    }

    public boolean isConnectionPhoneFieldEmpty() {
        return connectionPhoneField.getAttribute("value").isEmpty();
    }

    public boolean isConnectionSumFieldEmpty() {
        return connectionSumField.getAttribute("value").isEmpty();
    }

    public boolean isConnectionEmailFieldEmpty() {
        return connectionEmailField.getAttribute("value").isEmpty();
    }

    public boolean isInternetPhoneFieldEmpty() {
        return internetPhoneField.getAttribute("value").isEmpty();
    }

    public boolean isInternetSumFieldEmpty() {
        return internetSumField.getAttribute("value").isEmpty();
    }

    public boolean isInternetEmailFieldEmpty() {
        return internetEmailField.getAttribute("value").isEmpty();
    }

    public boolean isInstalmentScoreFieldEmpty() {
        return instalmentScoreField.getAttribute("value").isEmpty();
    }

    public boolean isInstalmentSumFieldEmpty() {
        return instalmentSumField.getAttribute("value").isEmpty();
    }

    public boolean isInstalmentEmailFieldEmpty() {
        return instalmentEmailField.getAttribute("value").isEmpty();
    }

    public boolean isArrearsScoreFieldEmpty() {
        return arrearsScoreField.getAttribute("value").isEmpty();
    }

    public boolean isArrearsSumFieldEmpty() {
        return arrearsSumField.getAttribute("value").isEmpty();
    }

    public boolean isArrearsEmailFieldEmpty() {
        return arrearsEmailField.getAttribute("value").isEmpty();
    }
}