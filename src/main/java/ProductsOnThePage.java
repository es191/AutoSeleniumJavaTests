import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsOnThePage {
    private static WebDriver driver;

    public ProductsOnThePage(WebDriver driver) {
        ProductsOnThePage.driver = driver;}

    private final By fromExpenSorting = By.xpath("//a[@id='ui-id-4']");
    private final By expenComputer = By.xpath("//a[text()='Alza Studio RTX4090']");

    public void sortingExp () {
        driver.findElement(fromExpenSorting).click();
        new ProductsOnThePage(driver);
    }

    public void choosingProduct () {
        driver.findElement(expenComputer).click();
        new OurProduct(driver);
    }

    public static void selectCheckBox (String id) {
        String cbXpath = "//input[@id='%s']/following::label";
        if (!driver.findElement(By.xpath(String.format(cbXpath, id))).isSelected()){
            driver.findElement(By.xpath(String.format(cbXpath,id))).click();
        }
    }
}
