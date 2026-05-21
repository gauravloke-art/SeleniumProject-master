package cart;

import base.BaseTest2;
import pages.AuthenticationPage2;
import pages.HomePage2;

import org.testng.annotations.Test;

public class CartTests3 extends BaseTest2 {
	//HomePage2 homePage2 = new HomePage2(driver);
	
	//AuthenticationPage2 Authenticationpage2=new AuthenticationPage2(driver);
    @Test(priority = 1)
    public void verifyProductsAreListedOnHomepage() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	HomePage2 homePage2 =
    	        new HomePage2(getDriver());
    	Authenticationpage2.login();
       //homePage2 = new HomePage2();
       homePage2.verifyItemsArePresent();
        //Assert.assertEquals(cartPage.getProductText(),"Tempo Zamalek Home Match Jersey 22/23 - Fan Edition");
    }
    @Test(priority = 2)
    public void verifyAboutPage() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	HomePage2 homePage2 =
    	        new HomePage2(getDriver());
    	Authenticationpage2.login();
        homePage2.goToAbout();
        //Assert.assertEquals(cartPage.getEmptyCartText(),"Your cart is empty!");
    }
    @Test(priority = 3)
    public void verifyLogoIsPresent() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	HomePage2 homePage2 =
    	        new HomePage2(getDriver());
    	Authenticationpage2.login();
        homePage2.verifylogoIsAvailable();
    }
    @Test(priority = 4)
    public void verifySortingIsWorking() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	HomePage2 homePage2 =
    	        new HomePage2(getDriver());
    	Authenticationpage2.login();
        homePage2.sortAtoZ();
    }
    @Test(priority = 5)
    public void verifyProductDetails() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	HomePage2 homePage2 =
    	        new HomePage2(getDriver());
    	Authenticationpage2.login();
        //homePage2.gotoAllItems();
        homePage2.verifyItemsArePresent();
        homePage2.verifyproductIsAvailable();
        System.out.println(homePage2.getProductName());
        System.out.println(homePage2.getProductDesc());
        System.out.println(homePage2.getProductPrice());
        }
    @Test(priority = 6)
    public void addToCart_Remove() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	HomePage2 homePage2 =
    	        new HomePage2(getDriver());
    	Authenticationpage2.login();
        //homePage2.gotoAllItems();
        homePage2.verifyItemsArePresent();
        homePage2.verifyproductIsAvailable();
        homePage2.addToCart();
        
        homePage2.removeFromCart();
        }
    @Test(priority = 7)
    public void addToCart() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	HomePage2 homePage2 =
    	        new HomePage2(getDriver());
    	Authenticationpage2.login();
        //homePage2.gotoAllItems();
        homePage2.verifyItemsArePresent();
        homePage2.verifyproductIsAvailable();
        homePage2.addToCart();
        homePage2.goTocart();
        homePage2.removeBtnFromcart();
        }
    @Test(priority = 8)
    public void verifyProductsAreListedOnHomepage1() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	HomePage2 homePage2 =
    	        new HomePage2(getDriver());
    	Authenticationpage2.login();
       //homePage2 = new HomePage2();
       homePage2.verifyItemsArePresent();
        //Assert.assertEquals(cartPage.getProductText(),"Tempo Zamalek Home Match Jersey 22/23 - Fan Edition");
    }
    @Test(priority = 9)
    public void verifyAboutPage1() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	HomePage2 homePage2 =
    	        new HomePage2(getDriver());
    	Authenticationpage2.login();
        homePage2.goToAbout();
        //Assert.assertEquals(cartPage.getEmptyCartText(),"Your cart is empty!");
    }
    @Test(priority = 10)
    public void verifyLogoIsPresent1() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	HomePage2 homePage2 =
    	        new HomePage2(getDriver());
    	Authenticationpage2.login();
        homePage2.verifylogoIsAvailable();
    }
    @Test(priority = 11)
    public void verifySortingIsWorking1() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	HomePage2 homePage2 =
    	        new HomePage2(getDriver());
    	Authenticationpage2.login();
        homePage2.sortAtoZ();
    }
    @Test(priority = 12)
    public void verifyProductDetails1() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	HomePage2 homePage2 =
    	        new HomePage2(getDriver());
    	Authenticationpage2.login();
        //homePage2.gotoAllItems();
        homePage2.verifyItemsArePresent();
        homePage2.verifyproductIsAvailable();
        System.out.println(homePage2.getProductName());
        System.out.println(homePage2.getProductDesc());
        System.out.println(homePage2.getProductPrice());
        }
    @Test(priority = 13)
    public void addToCart_Remove1() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	HomePage2 homePage2 =
    	        new HomePage2(getDriver());
    	Authenticationpage2.login();
        //homePage2.gotoAllItems();
        homePage2.verifyItemsArePresent();
        homePage2.verifyproductIsAvailable();
        homePage2.addToCart();
        homePage2.removeFromCart();
        }
    @Test(priority = 14)
    public void addToCart1() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	HomePage2 homePage2 =
    	        new HomePage2(getDriver());
    	Authenticationpage2.login();
        //homePage2.gotoAllItems();
        homePage2.verifyItemsArePresent();
        homePage2.verifyproductIsAvailable();
        homePage2.addToCart();
        homePage2.goTocart();
        homePage2.removeBtnFromcart();
        }
    @Test(priority = 15)
    public void invalidEmailMessage() throws InterruptedException{
    	AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());

    	
    	Authenticationpage2.verifyInvalidLogin();
    	
       
        }
}
