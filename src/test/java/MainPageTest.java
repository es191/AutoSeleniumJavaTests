import com.google.common.base.Verify;
import org.checkerframework.checker.optional.qual.Present;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;
    private ProductsOnThePage productsOnThePage;

    @Before
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\evgen\\IdeaProjects\\testSelenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.alza.cz/");
        mainPage = new MainPage(driver);

        mainPage.clickPopUpWindow();
        mainPage.clickFooter();
    }

    @Test
    public void goToCategory () {
        WebElement link = driver.findElement(By.xpath("//li[@id='litp18890188']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();

        ProductsOnThePage productsOnThePage = mainPage.findCategory();

    }
    @After
    public void tearDown () {
        driver.quit();
    }

}
