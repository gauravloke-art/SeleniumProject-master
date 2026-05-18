package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class HomePage2 extends BasePage{
	

private final By cart =By.id("shopping_cart_container");
private final By menu =By.id("react-burger-menu-btn");
private final By allItems =By.id("inventory_sidebar_link");
private final By about =By.id("about_sidebar_link");
private final By logout =By.id("logout_sidebar_link");
private final By resetAppState =By.id("reset_sidebar_link");
private final By filter=By.xpath("//select[@class='product_sort_container']");
private final By filterAtoZ=By.xpath("//select[@class='product_sort_container']/option[1]");
private final By listOfElements=By.xpath("//div[@class='inventory_item']");
private final By firstProduct=By.xpath("//div[@class='inventory_item'][1]");
private final By productName=By.xpath("//div[@class='inventory_item'][1]/div[2]/div/a/div");
private final By productDescription=By.xpath("//div[@class='inventory_item'][1]/div[2]/div/div");
private final By productPrice=By.xpath("//div[@class='inventory_item'][1]/div[2]/div[2]/div");
private final By addTocart=By.xpath("//div[@class='inventory_item'][1]/div[2]/div[2]/button");
//remove-sauce-labs-backpack
private final By removeBtn=By.id("remove-sauce-labs-backpack");


public void verifyItemsArePresent() {
	Assert.assertTrue(
            driver.findElements(listOfElements).size() > 0,
            "Items are not present"
    );
}
public void gotoAllItems() {
	click(menu);
	click(allItems);
	}

public String getProductName(){
    return getText(productName);
}

public String getProductDesc(){
    return getText(productDescription);
}

public String getProductPrice(){
    return getText(productPrice);
}

public void addToCart() {
	click(addTocart);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	wait.until(
	        ExpectedConditions.visibilityOfElementLocated(removeBtn)
	        );
	Assert.assertTrue(((WebElement) removeBtn).isDisplayed());
	
	}

public void goTocart() {
	click(cart);
	}

public void logout() {
	click(menu);
	click(logout);
	}

public void goToAbout() {
	click(about);
	String actualUrl = driver.getCurrentUrl();

	Assert.assertEquals(
	        actualUrl,
	        "https://saucelabs.com/"
	);
	}
	




}

