package uk.ac.cam.ice.www.pages;

import bsh.util.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import uk.ac.cam.ice.www.utility.Utility;

import java.util.List;

public class RegisterPage extends Utility {

    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[contains(@id,'forename')]")
    WebElement firstName;

    @CacheLookup
    @FindBy(xpath = "//div[@id='iceForm:well:dateOfBirth:dateOfBirthDay']")
    WebElement day;

    @CacheLookup
    @FindBy(xpath = "//ul[@id='iceForm:well:dateOfBirth:dateOfBirthDay_items']//li")
    List<WebElement> dayList;

    @CacheLookup
    @FindBy(xpath = "//div[@id='iceForm:well:dateOfBirth:dateOfBirthMonth']")
    WebElement month;

    @CacheLookup
    @FindBy(xpath = "//ul[@id='iceForm:well:dateOfBirth:dateOfBirthMonth_items']//li")
    List<WebElement> monthList;

    @CacheLookup
    @FindBy(xpath = "//div[@id='iceForm:well:dateOfBirth:dateOfBirthYear']")
    WebElement year;

    @CacheLookup
    @FindBy(xpath = "//ul[@id='iceForm:well:dateOfBirth:dateOfBirthYear_items']//li")
    List<WebElement> yearList;

    @CacheLookup
    @FindBy(xpath = "//span[text()='Register']")
    WebElement register;

    public void clickOnRegisterButton() {
        clickOnElement(register);
        log.info("I click on register button : " + register.toString());
    }

    public void selectYear(String text){
        log.info("I select year : " + year.toString());
        clickOnElement(year);
        List<WebElement> elements = yearList;
        for(WebElement element: elements)
        {
            String getText= element.getText();
            System.out.println(getText);
            if(getText.equals(text))
            {
                element.click();
                break;
            }
        }
    }

    public void selectMonth(String text){
        log.info("I select month : " + month.toString());
        clickOnElement(month);
        List<WebElement> elements = monthList;
        for(WebElement element: elements)
        {
            String getText= element.getText();
            System.out.println(getText);
            if(getText.equals(text))
            {
                element.click();
                break;
            }
        }
    }

    public void selectDay(String text){
        log.info("I select day : " + day.toString());

        clickOnElement(day);
        List<WebElement> elements = dayList;
        for(WebElement element: elements)
        {
            String getText= element.getText();
            System.out.println(getText);
            if(getText.equals(text))
            {
                element.click();
                break;
            }
        }
   /*

    By locator = By.xpath("//div[@id='iceForm:well:dateOfBirth:dateOfBirthDay']");
		driver.findElement(locator).click();
    By locator1 = By.xpath("//ul[@id='iceForm:well:dateOfBirth:dateOfBirthDay_items']//li");

    List<WebElement> ele= driver.findElements(locator1);
		 for(WebElement element: ele) {

        String getText= element.getText();
        System.out.println(getText);
        if(getText.equals("10"))
        {
            element.click();
            break;
        }
    }
    */

    }

    public void enterFirstName(String name) {
        sendTextToElement(firstName,name);

        log.info("I enter first name : " + firstName.toString());
    }


}
