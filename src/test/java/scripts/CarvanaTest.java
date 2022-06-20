package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class CarvanaTest extends Base{

    // Task - 1
    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void testTitleAndUrl(){
        driver.get("https://www.carvana.com/");

        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }


    // Task - 2
    @Test(priority = 2, description = "Validate the Carvana logo")
    public void testLogo(){
        driver.get("https://www.carvana.com/");

        Waiter.waitForVisibilityOfElement(driver, carvanaPage.logo, 30);
        Assert.assertTrue(carvanaPage.logo.isDisplayed());
    }


    // Task - 3
    @Test(priority = 3, description = "Validate the main navigation section items")
    public void testNavigationMenu(){
        driver.get("https://www.carvana.com/");

        Assert.assertEquals(carvanaPage.howItWorksText.getText(), "HOW IT WORKS");
        Assert.assertTrue(carvanaPage.howItWorksText.isDisplayed());
        Assert.assertEquals(carvanaPage.aboutCarvanaText.getText(), "ABOUT CARVANA");
        Assert.assertTrue(carvanaPage.aboutCarvanaText.isDisplayed());
        Assert.assertEquals(carvanaPage.supportAndContactText.getText(), "SUPPORT & CONTACT");
        Assert.assertTrue(carvanaPage.supportAndContactText.isDisplayed());
    }


    // Task - 4
    @Test(priority = 4, description = "Validate the sign in error message")
    public void testSignInErrorMessage(){
        driver.get("https://www.carvana.com/");

        carvanaPage.signInButton.click();
        carvanaPage.emailInputBox.sendKeys("johndoe@gmail.com");
        carvanaPage.passwordInputBox.sendKeys("abcd1234");
        carvanaPage.modalSignInButton.click();
        Waiter.pause(5);

        Assert.assertEquals(carvanaPage.errorMessage.getText(), "Email address and/or password combination is incorrect\n" +
                "Please try again or reset your password.");
    }


    // Task - 5
    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void testFilterOptions(){
        driver.get("https://www.carvana.com/");

        Waiter.pause(3);
        carvanaPage.searchCarsButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        String[] expectedText = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};

        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(carvanaPage.filterOptions.get(i).getText(), expectedText[i]);
        }
    }


    // Task - 6
    @Test(priority = 6, description = "Validate the search result tiles")
    public void testSearchTiles(){
        driver.get("https://www.carvana.com/");

        Waiter.pause(3);
        carvanaPage.searchCarsButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        actions.sendKeys(carvanaPage.searchInputBox, "mercedes-benz").click(carvanaPage.goButton).perform();
        Waiter.waitUntilURLContains(driver, 30, "mercedes-benz");
        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));

        for(WebElement element : carvanaPage.tilesImages){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.addToFavButton){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.inventoryType){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.yearAndMake){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.trimMileage){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.price){
            Assert.assertTrue(Integer.parseInt(element.getText().replaceAll("[\\D]", "")) > 0);
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.monthlyPayment){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.downPayment){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.deliveryChip){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }
    }
}
