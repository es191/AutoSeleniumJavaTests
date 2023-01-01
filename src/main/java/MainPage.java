import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    private By mainBanner = By.xpath("//div[@id='alzaDialog']/div[2]");
    private By mainFooter = By.xpath("//a[@data-action-id-value='1023']");
    private By mainCategory = By.xpath("//div[@class='subCategoryWrapper']//a[text()='Počítače']");

    public MainPage clickPopUpWindow () {
        driver.findElement(mainBanner).click();
        return new MainPage(driver);
    }

    public MainPage clickFooter () {
        driver.findElement(mainFooter).click();
        return new MainPage(driver);
    }

    public ProductsOnThePage findCategory () {
        driver.findElement(mainCategory).click();
        return new ProductsOnThePage(driver);
    }


}
