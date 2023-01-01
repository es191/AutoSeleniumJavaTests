import org.openqa.selenium.*;

import java.io.File;

public class FinalCart {
    private WebDriver driver;

    public FinalCart (WebDriver driver) {this.driver = driver;}

    private By addingNewItem = By.xpath("//span[text()='Přidat zboží']");
    private By typingText = By.xpath("//input[@id='inputByCode']");
    private By newItemFromList = By.xpath("//span[text()='(MR066e1u)']");

    public FinalCart typingNewItem () {
        driver.findElement(addingNewItem).click();
        driver.findElement(typingText).sendKeys("Razer DeathAdder V2");
        driver.findElement(newItemFromList).click();
        return new FinalCart(driver);
    }
}


