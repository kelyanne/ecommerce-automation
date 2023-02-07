package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BasePage {
    private final Properties properties;

    public BasePage() throws IOException {
        properties = new Properties();
        FileInputStream data = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/config.properties");
        properties.load(data);
    }

    public static WebDriver getDriver(){
        return WebdriverInstance.getDriver();
    }

    public String getUrl(){
        return properties.getProperty("url");
    }

    public String timestamp(){
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public void takeSnapShot(String name) throws IOException {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "/screenshots/" + timestamp() + "-" + name + ".png");
        FileUtils.copyFile(srcFile, destFile);
    }

    public static void waitElementBeInvisible(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
