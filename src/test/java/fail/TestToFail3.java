package fail;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestToFail3 extends BaseTest {
    @Test
    public void changeLanguageToArabicFailing() throws InterruptedException{
        homePage.closePopUp();
        homePage.changeToArabic();
        Assert.assertEquals(homePage.arabicAssertionText(),"hi");
    }
}
