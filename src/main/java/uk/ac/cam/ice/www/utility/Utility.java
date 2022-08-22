package uk.ac.cam.ice.www.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import uk.ac.cam.ice.www.drivermanager.ManageDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Utility extends ManageDriver {


    /**
     * This method will click on element
     */

    public void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * This method will get text from element
     */


    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public String getTextFromElement(WebElement element,String text) {
        return element.getText();
    }


    public void sendTextToElement(WebElement element, String str) {
        element.sendKeys(str);
    }



    // Select value from drop down menu
      public void dropDown(WebElement element, String text){
          Select select = new Select(element);
          select.selectByVisibleText(text);
      }

    // Select value from drop down menu
    public void dropDownByValue(WebElement element, String text){
        Select select = new Select(element);
        select.selectByValue(text);
    }


    //************************** ScreenShot Methods *********************************************//

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/main/java/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

}
