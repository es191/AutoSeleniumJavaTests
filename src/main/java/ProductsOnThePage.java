import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsOnThePage {
    private static WebDriver driver;

    public ProductsOnThePage(WebDriver driver) {this.driver = driver;}

    private By fromExpenSorting = By.xpath("//a[@id='ui-id-4']");
    private By expenComputer = By.xpath("//a[text()='Alza Studio RTX4090']");
    private By paragraf = By.xpath("//div[@class='category-description']//p");


    public ProductsOnThePage sortingExp () {
        driver.findElement(fromExpenSorting).click();
        return new ProductsOnThePage(driver);
    }

    public OurProduct choosingProduct () {
        driver.findElement(expenComputer).click();
        return new OurProduct(driver);
    }

    public static void selectCheckBox (String id) {
        String cbXpath = "//input[@id='%s']/following::label";
        if (!driver.findElement(By.xpath(String.format(cbXpath, id))).isSelected()){
            driver.findElement(By.xpath(String.format(cbXpath,id))).click();
        }
    }

    public ProductsOnThePage getParagragText(String attribute) {
       driver.findElement(paragraf).getAttribute("innerText");
       return new ProductsOnThePage(driver);
    }
}
