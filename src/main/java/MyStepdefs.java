import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FirstPage;
import pages.ThirdPage;

public class MyStepdefs {
    FirstPage firstPage = new FirstPage() ;

    ThirdPage thirdPage = new ThirdPage() ;
    @Given("Open Banggood Online Shopping App")
    public void openBanggoodOnlineShoppingApp() {

    }

    @When("Click to the Category on footer menu")
    public void clickToTheCategoryOnFooterMenu() {
        firstPage.category();
    }

    @And("Scroll and click to Home and Garden in left menu")
    public void scrollAndClickToHomeAndGardenInLeftMenu() {
        firstPage.clickHomeandgarden();
    }

    @And("After the right category displayed, click to the Home decor")
    public void afterTheRightCategoryDisplayedClickToTheHomeDecor() {
        firstPage.clickHomedecor();
    }

    @And("Click to the Filter and input price from 20 to 30")
    public void clickToTheFilterAndInputPriceFromTo() {
        firstPage.filter();
    }

    @And("Click Done")
    public void clickDone() {
        firstPage.done();
    }

    @And("Click First product")
    public void clickFirstProduct() {
        firstPage.clickfirstpro();
    }

    @Then("Verify product name should be displayed and product price 20 to 30")
    public void verifyProductNameShouldBeDisplayedAndProductPriceTo() {
        firstPage.verifyProduct();
    }

    @When("Click to the Account on footer menu")
    public void clickToTheAccountOnFooterMenu() {
        thirdPage.clickAccount();
    }

    @And("Click View All Order")
    public void clickViewAllOrder() {
        thirdPage.viewAll();
    }

    @Then("Verify the login screen should be displayed with : Email, pasword and Signin Button")
    public void verifyTheLoginScreenShouldBeDisplayedWithEmailPaswordAndSigninButton() {
        thirdPage.verifyLogin();
    }
}
