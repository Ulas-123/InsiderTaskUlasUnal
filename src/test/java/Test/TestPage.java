package Test;
import Pages.CareersPage;
import Pages.MainPage;
import Pages.OpenPositionsPage;
import Pages.QualityAssurancePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import java.util.Set;
import java.util.concurrent.TimeUnit;




public class TestPage {


    MainPage mPage = new MainPage();
    CareersPage cPage =new CareersPage();
    OpenPositionsPage oPage = new OpenPositionsPage();
    QualityAssurancePage qPage = new QualityAssurancePage();



    @BeforeMethod
    public void setupMethod(){

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        mPage.cookies.click();





    }


    @Test
    //1. Visit https://useinsider.com/ and check Insider home page is opened or not

    public void checkMainPage(){



        String expectedTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not matching");

        Driver.getDriver().close();

    }

    @Test
    //2. Select “More” menu in navigation bar, select “Careers” and check Career page, its
    //Locations, Teams and Life at Insider blocks are opened or not
    public void checkCareerPage(){




        mPage.moreMenuButton.click();
        mPage.careersLink.click();


        cPage.teamsBlock.isDisplayed();
        cPage.locationsBlock.isDisplayed();
        cPage.lifeAtInsiderBlock.isDisplayed();

        Driver.getDriver().close();
   }

   @Test
   //3. Click “See All Teams”, select Quality Assurance, click “See all QA jobs”, filter jobs by
   //Location - Istanbul, Turkey and department - Quality Assurance, check presence of
   //jobs list
   public void seeAllJobs() {

       mPage.moreMenuButton.click();
       mPage.careersLink.click();


       JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
       js.executeScript("window.scrollBy(0,2600)");
       BrowserUtils.sleep(3);
       cPage.seeAllTeamsButton.click();

       js.executeScript("window.scrollBy(0,1800)");
       BrowserUtils.sleep(3);
       cPage.QualityAssuranceLink.click();

       js.executeScript("window.scrollBy(0,100)");
       BrowserUtils.sleep(3);
       qPage.seeAllQaJobsButton.click();

       js.executeScript("window.scrollBy(0,500)");
       oPage.locationDropdown.click();

       oPage.istTurkeyOption.click();

       BrowserUtils.sleep(3);

       Assert.assertTrue(oPage.positionName1.isDisplayed());
       Assert.assertTrue(oPage.positionName2.isDisplayed());


       Driver.getDriver().close();
   }

       @Test
       //Check that all jobs’ Position contains “Quality Assurance”, Department contains
       //“Quality Assurance”, Location contains “Istanbul, Turkey” and “Apply Now” button

       public void checkAllJobs(){


           mPage.moreMenuButton.click();
           mPage.careersLink.click();


           JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
           js.executeScript("window.scrollBy(0,2600)");
           BrowserUtils.sleep(3);
           cPage.seeAllTeamsButton.click();

           js.executeScript("window.scrollBy(0,1800)");
           BrowserUtils.sleep(3);
           cPage.QualityAssuranceLink.click();

           js.executeScript("window.scrollBy(0,100)");
           BrowserUtils.sleep(3);
           qPage.seeAllQaJobsButton.click();

           js.executeScript("window.scrollBy(0,500)");
           oPage.locationDropdown.click();

           oPage.istTurkeyOption.click();

           BrowserUtils.sleep(3);

           oPage.location1.isDisplayed();
           oPage.location2.isDisplayed();
           oPage.positionDepartment1.isDisplayed();
           oPage.positionDepartment2.isDisplayed();
           oPage.positionName1.isDisplayed();
           oPage.positionName2.isDisplayed();

           Actions action = new Actions(Driver.getDriver());
           action.moveToElement(oPage.applyNowButton1).build();
           oPage.applyNowButton1.isDisplayed();

           action.moveToElement(oPage.applyNowButton2).build();
           oPage.applyNowButton1.isDisplayed();

           Driver.getDriver().close();

           
       }


       @Test
       //Click “Apply Now” button and check that this action redirects us to Lever Application
       //form page

       public void clickApplyButton(){


           mPage.moreMenuButton.click();
           mPage.careersLink.click();


           JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
           js.executeScript("window.scrollBy(0,2600)");
           BrowserUtils.sleep(3);
           cPage.seeAllTeamsButton.click();

           js.executeScript("window.scrollBy(0,1800)");
           BrowserUtils.sleep(4);
           cPage.QualityAssuranceLink.click();

           js.executeScript("window.scrollBy(0,100)");
           BrowserUtils.sleep(3);
           qPage.seeAllQaJobsButton.click();

           js.executeScript("window.scrollBy(0,600)");
           oPage.locationDropdown.click();

           oPage.istTurkeyOption.click();

           BrowserUtils.sleep(3);

           js.executeScript("window.scrollBy(0,450)");

           Actions action = new Actions(Driver.getDriver());
           action.moveToElement(oPage.positionName1).build();

           JavascriptExecutor executor1= (JavascriptExecutor) Driver.getDriver();
           executor1.executeScript("arguments[0].click();", oPage.applyNowButton1);

           action.moveToElement(oPage.positionName2).build();
           executor1.executeScript("arguments[0].click();", oPage.applyNowButton2);

           Set<String> windows = Driver.getDriver().getWindowHandles();

           for (String each: windows) {
               Driver.getDriver().switchTo().window(each);
               String actualTitle = Driver.getDriver().getTitle();

               String job1 = "Insider. - Senior Software Quality Assurance Engineer - Remote";
               String job2 = "Insider. - Software Quality Assurance Engineer (Remote)";

               if(actualTitle.equals(job1)){
                   System.out.println("job1 passed");
               } else if (actualTitle.equals(job2)) {
                   System.out.println("job2 passed");
               }

           }

           Driver.getDriver().quit();
       }
}
