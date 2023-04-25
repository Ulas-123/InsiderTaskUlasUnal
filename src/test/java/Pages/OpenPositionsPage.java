package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OpenPositionsPage {

    public OpenPositionsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@id='select2-filter-by-location-container']")
    public static WebElement locationDropdown;

    @FindBy (xpath = "//span[@id='select2-filter-by-department-container']")
    public static WebElement departmentDropdown;

    @FindBy (xpath = "//p[.='Senior Software Quality Assurance Engineer - Remote']")
    public static WebElement positionName1;

    @FindBy (xpath = "(//span[.='Quality Assurance'])[1]")
    public static WebElement positionDepartment1;

    @FindBy (xpath = "(//div[.='Istanbul, Turkey'])[1]")
    public static WebElement location1;

    @FindBy (xpath = "(//a[.='Apply Now'])[1]")
    public static WebElement applyNowButton1;

    @FindBy (xpath = "//p[.='Software Quality Assurance Engineer (Remote)']")
    public static WebElement positionName2;

    @FindBy (xpath = "(//span[.='Quality Assurance'])[2]")
    public static WebElement positionDepartment2;

    @FindBy (xpath = "(//div[.='Istanbul, Turkey'])[2]")
    public static WebElement location2;

    @FindBy (xpath = "(//a[.='Apply Now'])[2]")
    public static WebElement applyNowButton2;

    @FindBy (xpath = "//li[.='Istanbul, Turkey']")
    public static WebElement istTurkeyOption;


}
