import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OurProduct {
    private final WebDriver driver;

    public OurProduct (WebDriver driver) {this.driver = driver;}

    private final By buyButton = By.xpath("//a[@class='btnx new green buy js-buy-button']");

    public void confirmationOfProduct () {
        driver.findElement(buyButton).click();
        new InsuranceInCart(driver);
    }

}

