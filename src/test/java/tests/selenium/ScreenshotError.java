package tests.selenium;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotError {

    private static final String SCREENSHOT_PATH = "screenshots/";

    public static void captureScreenshot(WebDriver driver, ITestResult result) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = result.getMethod().getMethodName() + "_" + timestamp + ".png";
        Path targetPath = Paths.get(SCREENSHOT_PATH + screenshotName);

        try {
            Files.createDirectories(targetPath.getParent());
            Files.move(screenshotFile.toPath(), targetPath);
            System.out.println("Screenshot saved: " + targetPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
