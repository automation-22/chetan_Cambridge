package uk.ac.cam.ice.www.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import uk.ac.cam.ice.www.pages.CoursePage;
import uk.ac.cam.ice.www.pages.LoginPage;
import uk.ac.cam.ice.www.pages.RegisterPage;

public class ApplyForCourse {
    @Given("^User is on course page$")
    public void userIsOnCoursePage() {
    }

    @When("^I click on apply now button$")
    public void iClickOnApplyNowButton() {
        new CoursePage().clickOnApplyButton();
    }

    @And("^I click on register button from login page$")
    public void iClickOnRegisterButtonFromLoginPage() {
        new LoginPage().clickOnRegisterButton();
    }

    @And("^I enter firstname \"([^\"]*)\"$")
    public void iEnterFirstname(String name) {
        new RegisterPage().enterFirstName(name);
    }

    @And("^I select day \"([^\"]*)\" month \"([^\"]*)\" year \"([^\"]*)\"$")
    public void iSelectDayMonthYear(String day, String month, String year)  {
       new RegisterPage().selectDay(day);
       new RegisterPage().selectMonth(month);
       new RegisterPage().selectYear(year);
    }

    @Then("^I click on register button$")
    public void iClickOnRegisterButton() {
        new RegisterPage().clickOnRegisterButton();
    }

    @When("^I enter course computer \"([^\"]*)\"$")
    public void iEnterCourseComputer(String course)  {
        new CoursePage().enterCourse(course);

    }

    @And("^I click on search button$")
    public void iClickOnSearchButton() {
        new CoursePage().clickOnSearchButton();
    }


    @Then("^I should able to see result based on search$")
    public void iShouldAbleToSeeResultBasedOnSearch() {
        String totalCount = new CoursePage().getTotal();
        totalCount = totalCount.replaceAll("[aA-zZ]","").trim();
        int searchCount = Integer.parseInt(totalCount);
        int count = new CoursePage().getSearchCount();
     Assert.assertTrue("Total not matching "+count+":"+searchCount,count==searchCount);

    }
}
