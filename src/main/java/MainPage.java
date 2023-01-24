import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    
    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    private final By mainBanner = By.xpath("//div[@id='alzaDialog']/div[2]");
    private final By mainFooter = By.xpath("//a[@data-action-id-value='1023']");
    private final By mainCategory = By.xpath("//div[@class='subCategoryWrapper']//a[text()='Počítače']");

    public void clickPopUpWindow () {
        driver.findElement(mainBanner).click();
        new MainPage(driver);
    }

    public void clickFooter () {
        driver.findElement(mainFooter).click();
        new MainPage(driver);
    }

    public ProductsOnThePage findCategory () {
        driver.findElement(mainCategory).click();
        return new ProductsOnThePage(driver);
    }
}
