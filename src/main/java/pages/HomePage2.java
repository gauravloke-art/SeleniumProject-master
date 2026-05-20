package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class HomePage2 extends BasePage2{
	

private final By cart =By.id("shopping_cart_container");
private final By menu =By.id("react-burger-menu-btn");
private final By allItems =By.id("inventory_sidebar_link");
private final By about =By.id("about_sidebar_link");
private final By logout =By.id("logout_sidebar_link");
private final By resetAppState =By.id("reset_sidebar_link");
private final By filter=By.xpath("//select[@class='product_sort_container']");
private final By filterAtoZ=By.xpath("//select[@class='product_sort_container']/option[1]");
private final By listOfElements=By.xpath("//div[@class='inventory_item']");
private final By logo=By.xpath("//div[@class='app_logo']");
private final By firstProduct=By.xpath("//div[@class='inventory_item'][1]");
private final By productName=By.xpath("//div[@class='inventory_item'][1]/div[2]/div/a/div");
private final By productDescription=By.xpath("//div[@class='inventory_item'][1]/div[2]/div/div");
private final By productPrice=By.xpath("//div[@class='inventory_item'][1]/div[2]/div[2]/div");
private final By addTocart=By.xpath("//div[@class='inventory_item'][1]/div[2]/div[2]/button");
//remove-sauce-labs-backpack
////button[@id='remove-sauce-labs-backpack']
private final By removeBtnFromcart=By.xpath("//button[@id='remove-sauce-labs-backpack']");
private final By removeBtn=By.xpath("//button[@id='remove-sauce-labs-backpack']");
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
public HomePage2(WebDriver driver) {
    super(driver);
}


public void verifyItemsArePresent() {
	wait.until(
            ExpectedConditions.visibilityOfElementLocated(listOfElements)
    );
	Assert.assertTrue(
            driver.findElements(listOfElements).size() > 0,
            "Items are not present"
    );
}
public void gotoAllItems() {
	//wait.until(
//	        ExpectedConditions.visibilityOfElementLocated(menu)
//	        );
	wait.until(
            ExpectedConditions.elementToBeClickable(menu)
    ).click();
	//click(menu);
	click(allItems);
	}

public String getProductName(){
	wait.until(
	        ExpectedConditions.visibilityOfElementLocated(productName)
	        );
    return getText(productName);
}

public String getProductDesc(){
	wait.until(
	        ExpectedConditions.visibilityOfElementLocated(productDescription)
	        );
    return getText(productDescription);
}

public String getProductPrice(){
	wait.until(
	        ExpectedConditions.visibilityOfElementLocated(productPrice)
	        );
    return getText(productPrice);
}

public void addToCart() {
	wait.until(
	        ExpectedConditions.visibilityOfElementLocated(addTocart)
	        );
	click(addTocart);
	//wait.until(
	       // ExpectedConditions.visibilityOfElementLocated(removeBtn)
	       // );
	//Assert.assertTrue(((WebElement) removeBtn).isDisplayed());
	
	}
public void removeFromCart() {
	wait.until(
	        ExpectedConditions.visibilityOfElementLocated(removeBtn)
	        );
	click(removeBtn);

	
	}

public void goTocart() {
	wait.until(
	        ExpectedConditions.visibilityOfElementLocated(cart)
	        );
	click(cart);
	}
public void sortAtoZ() {
	wait.until(
	        ExpectedConditions.visibilityOfElementLocated(filter)
	        );
	click(filter);
	click(filterAtoZ);
	}

public void logout() {
	wait.until(
	        ExpectedConditions.visibilityOfElementLocated(menu)
	        );
	click(menu);
	click(logout);
	}

public void goToAbout() {
	wait.until(
	        ExpectedConditions.visibilityOfElementLocated(menu)
	        );
	click(menu);
	click(about);
	String actualUrl = driver.getCurrentUrl();

	Assert.assertEquals(
	        actualUrl,
	        "https://saucelabs.com/"
	);
	driver.navigate().back();
	}
public void goToAbout1() {
	wait.until(
	        ExpectedConditions.visibilityOfElementLocated(about)
	        );
	}
////button[@id='remove-sauce-labs-backpack']
public void verifyproductIsAvailable() {
	//click(addTocart);
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	WebElement product = wait.until(
            ExpectedConditions.visibilityOfElementLocated(firstProduct)
    );

    Assert.assertTrue(product.isDisplayed());
	
	}
public void verifylogoIsAvailable() {
	//click(addTocart);
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	WebElement logo1 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(logo)
    );

    Assert.assertTrue(logo1.isDisplayed());
	//Assert.assertTrue(((WebElement) logo).isDisplayed());
	
	}
public void removeBtnFromcart(){
	 wait.until(
            ExpectedConditions.visibilityOfElementLocated(removeBtnFromcart)
    );
	click(removeBtnFromcart);
	
}



}

