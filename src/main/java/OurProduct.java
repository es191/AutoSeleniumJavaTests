import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OurProduct {
    private WebDriver driver;

    public OurProduct (WebDriver driver) {this.driver = driver;}

    private By buyButton = By.xpath("//a[@class='btnx new green buy js-buy-button']");

    public InsuranceInCart confirmationOfProduct () {
        driver.findElement(buyButton).click();
        return new InsuranceInCart(driver);
    }

}

