import com.sun.deploy.cache.Cache;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;

import static com.sun.deploy.cache.Cache.copyFile;

public class FinalCart {
    private static WebDriver driver = null;

    public FinalCart (WebDriver driver) {
        FinalCart.driver = driver;}



    public static void screenShot() throws IOException {
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Cache FileUtils = null;
        copyFile(scrFile, new File("c:\\Users\\evgen\\IdeaProjects\\testSelenium\\src\\screenshots\\'screenshot.png')"));
    };

}


