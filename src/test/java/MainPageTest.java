import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;
    private ProductsOnThePage productsOnThePage;

    @Before
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\evgen\\IdeaProjects\\testSelenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://www.alza.cz/");
        mainPage = new MainPage(driver);

        mainPage.clickPopUpWindow();
        mainPage.clickFooter();
    }

    @Test
    public void ourTitles () {
        String expected = driver.getTitle();
        String actual = "Alza.cz – rychlý a pohodlný nákup odkudkoliv | Alza.cz";
        assertEquals(expected, actual);
    }

    @Test
    public void presenceOfElements () {
        String expLink1 = driver.findElement(By.xpath("//a[contains(text(), 'Počítače a notebooky')]")).getText();
        String actLink1 = "Počítače a notebooky";
        assertEquals(expLink1, actLink1);

        String expLink2 = driver.findElement(By.xpath("//a[contains(text(), 'Velké spotřebiče')]")).getText();
        String actLink2 = "Velké spotřebiče";
        assertEquals(expLink2, actLink2);

        String expLink3 = driver.findElement(By.xpath("//a[text() ='Jak nakoupit']")).getText();
        String actLink3 = "Jak nakoupit";
        assertEquals(expLink3, actLink3);
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
