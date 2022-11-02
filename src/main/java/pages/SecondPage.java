package pages;

import core.AppiumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondPage extends AppiumBase {
    public SecondPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[@text='Thể loại hot']")
    private WebElement theloaihot ;
}
