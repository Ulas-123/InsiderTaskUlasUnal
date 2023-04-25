package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CareersPage {

    public CareersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='javascript:void(0)']")
    public static WebElement seeAllTeamsButton;

    @FindBy(xpath = "(//h3[@class='category-title-media'])[1]")
    public static WebElement teamsBlock;

    @FindBy(xpath = "(//h3[@class='category-title-media ml-0'])[1]")
    public static WebElement locationsBlock;

    @FindBy(xpath = "//h2[.='Life at Insider']")
    public static WebElement lifeAtInsiderBlock;

    @FindBy(xpath = "//a[@href='https://useinsider.com/careers/quality-assurance/']")
    public static WebElement QualityAssuranceLink;

//h3[.='Quality Assurance']
}
