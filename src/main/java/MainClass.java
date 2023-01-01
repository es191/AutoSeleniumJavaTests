import com.sun.deploy.cache.Cache;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\evgen\\IdeaProjects\\testSelenium\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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

        productsOnThePage.selectCheckBox("chb-producer-1835");
        productsOnThePage.selectCheckBox("chb-producer-1287");
        productsOnThePage.selectCheckBox("chb-producer-1518");

        productsOnThePage.choosingProduct();

        OurProduct ourProduct = PageFactory.initElements(driver, OurProduct.class);
        ourProduct.confirmationOfProduct();

        InsuranceInCart insuranceInCart = PageFactory.initElements(driver, InsuranceInCart.class);
        insuranceInCart.continueBuying();

        FinalCart finalCart = PageFactory.initElements(driver, FinalCart.class);
        finalCart.typingNewItem();

        driver.quit();

    }
}
