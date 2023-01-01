import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InsuranceInCart {
    private WebDriver driver;

    public InsuranceInCart (WebDriver driver) {this.driver = driver;}

    private By continueCart = By.xpath("//div[@class='buttonGroup']/a[2]");

    public FinalCart continueBuying () {
        driver.findElement(continueCart).click();
        return new FinalCart(driver);
    }

}
