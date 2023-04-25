package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainPage {


public MainPage(){

    PageFactory.initElements(Driver.getDriver(),this);
}


    @FindBy(xpath = "//span[.='More']" )
    public static WebElement moreMenuButton;


    @FindBy (xpath = "//h5[.='Careers']")
    public static WebElement careersLink;

    @FindBy (xpath = "//a[.='Accept All']")
    public static WebElement cookies;

}
