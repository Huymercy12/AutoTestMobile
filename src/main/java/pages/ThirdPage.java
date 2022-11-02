package pages;

import core.AppiumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ThirdPage extends AppiumBase {
    public ThirdPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "com.banggood.client:id/main_tab_account")
    private WebElement account ;
    @FindBy(id = "com.banggood.client:id/tv_view_all")
    private WebElement viewall ;
    @FindBy(id = "com.banggood.client:id/et_email")
    private WebElement email ;
    @FindBy(id = "com.banggood.client:id/et_pwd")
    private WebElement pass ;
    @FindBy(id = "com.banggood.client:id/btn_sign_in")
    private WebElement signinButton ;
    WebDriverWait wait = new WebDriverWait(driver,20);
    public void clickAccount(){
        account.click();
    }
    public void viewAll(){
        viewall.click();
    }
    public boolean verifyLogin(){
        return email.isDisplayed() && pass.isDisplayed() && signinButton.isDisplayed();
    }

}
