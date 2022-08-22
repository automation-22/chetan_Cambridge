package uk.ac.cam.ice.www.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.ac.cam.ice.www.utility.Utility;

import java.util.List;

public class CoursePage extends Utility {

    private static final Logger log = LogManager.getLogger(CoursePage.class.getName());

    public CoursePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(className = "campl-primary-cta")
    WebElement applyNow;

    @CacheLookup
    @FindBy(id = "edit-freetext")
    WebElement searchCourses;

    @CacheLookup
    @FindBy(id = "edit-submit")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@class, 'views-row')]//img")
    List <WebElement> courseCount;

    @CacheLookup
    @FindBy(xpath = "//a[contains(@class, 'campl-next')]")
    List<WebElement> forwardArrow;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Search found')]")
    WebElement totalResult;

    public String getTotal(){
      return   getTextFromElement(totalResult);
    }

    public int page1CourseCount(){
        int total =  courseCount.size();
        return total;
    }

    public int page2CourseCount(){
        int total = courseCount.size();
        return total;
    }



    public void clickOnSearchButton(){
        clickOnElement(searchButton);
        log.info("I click on search button : " + searchButton.toString());
    }

    public void enterCourse(String text){
        sendTextToElement(searchCourses,text);
        log.info("I search for course : " + searchCourses.toString());
    }

    public void clickOnApplyButton() {
        clickOnElement(applyNow);
        log.info("I click on apply button : " + applyNow.toString());
    }

    public int getSearchCount()
    {

        By course = By.xpath("//div[contains(@class, 'views-row')]//img");
        By arrow = By.xpath("//a[contains(@class, 'campl-next')]");
        List<WebElement> courseCounts= driver.findElements(course);
        List<WebElement> nextArrow= driver.findElements(arrow);

        int sum=0;
        int size = courseCounts.size();
        while(size!=0)
        {
            sum=sum+size;
            int next =  driver.findElements(arrow).size();
           if(next>0)
           {
               driver.findElements(arrow).get(0).click();
               size = driver.findElements(course).size();
           }
           else
           {
               break;
           }
        }

        return sum;
    }


}
