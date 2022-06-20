package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaPage {
    public CarvanaPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[data-qa='logo-wrapper'] svg")
    public WebElement logo;

    @FindBy(className = "csYWSj")
    public WebElement howItWorksText;

    @FindBy(className = "tFmIu")
    public WebElement aboutCarvanaText;

    @FindBy(className = "hsULzE")
    public WebElement supportAndContactText;

    @FindBy(css = "div[data-qa='desktop-wrapper']>a")
    public WebElement signInButton;

    @FindBy(id = "usernameField")
    public WebElement emailInputBox;

    @FindBy(id = "passwordField")
    public WebElement passwordInputBox;

    @FindBy(css = "button[data-cv='sign-in-submit']")
    public WebElement modalSignInButton;

    @FindBy(css = "div[data-qa='error-message-container']")
    public WebElement errorMessage;

    @FindBy(css = "div[data-qa='header-items']>a:nth-child(1)")
    public WebElement searchCarsButton;

    @FindBy(css = ".lYQCK>button")
    public List<WebElement> filterOptions;

    @FindBy(id = "search-bar-container-wrapper")
    public WebElement searchInputBox;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(css = ".result-tile picture")
    public List<WebElement> tilesImages;

    @FindBy(className = "favorite-vehicle")
    public List<WebElement> addToFavButton;

    @FindBy(css = "div[data-test='InventoryTypeExperiment']")
    public List<WebElement> inventoryType;

    @FindBy(className = "year-make")
    public List<WebElement> yearAndMake;

    @FindBy(className = "trim-mileage")
    public List<WebElement> trimMileage;

    @FindBy(className = "upgrades-price")
    public List<WebElement> price;

    @FindBy(className = "monthly-payment")
    public List<WebElement> monthlyPayment;

    @FindBy(className = "down-payment")
    public List<WebElement> downPayment;

    @FindBy(className = "delivery-chip")
    public List<WebElement> deliveryChip;


}
