import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InsuranceInCart {
    private final WebDriver driver;

    public InsuranceInCart (WebDriver driver) {this.driver = driver;}

    private final By continueCart = By.xpath("//div[@class='buttonGroup']/a[2]");

    public void continueBuying () {
        driver.findElement(continueCart).click();
        new FinalCart(driver);
    }

}
