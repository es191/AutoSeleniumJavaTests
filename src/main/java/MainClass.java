import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\evgen\\IdeaProjects\\testSelenium\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://www.alza.cz/");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPopUpWindow();
        mainPage.clickFooter();

        WebElement link = driver.findElement(By.xpath("//li[@id='litp18890188']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();

        mainPage.findCategory();

        ProductsOnThePage productsOnThePage = PageFactory.initElements(driver, ProductsOnThePage.class);
        productsOnThePage.sortingExp();

        ProductsOnThePage.selectCheckBox("chb-producer-1835");
        ProductsOnThePage.selectCheckBox("chb-producer-1287");
        ProductsOnThePage.selectCheckBox("chb-producer-1518");

        productsOnThePage.choosingProduct();

        OurProduct ourProduct = PageFactory.initElements(driver, OurProduct.class);
        ourProduct.confirmationOfProduct();

        InsuranceInCart insuranceInCart = PageFactory.initElements(driver, InsuranceInCart.class);
        insuranceInCart.continueBuying();

        FinalCart finalCart = PageFactory.initElements(driver, FinalCart.class);
        finalCart.screenShot();

        driver.quit();

    }
}
