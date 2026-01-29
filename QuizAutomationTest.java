import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class QuizAutomationTest {

    static WebDriver driver;
    static PrintWriter logger;
    static WebDriverWait wait;

    public static void main(String[] args) {

        try {
            // ================== LOG SETUP ==================
            File logDir = new File("logs");
            if (!logDir.exists()) logDir.mkdir();

            logger = new PrintWriter(new FileWriter("logs/execution.log", true));
            logger.println("====================================");
            logger.println("QUIZ AUTOMATION STARTED");
            logger.println("Timestamp: " + new Date());
            logger.println("====================================");

            // ================== LAUNCH BROWSER ==================
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            logger.println("Chrome browser launched");

            // ================== 1. VERIFY LANDING PAGE ==================
            driver.get("http://127.0.0.1:5500/index.html"); // CHANGE IF NEEDED

            logger.println("Landing page loaded");
            logger.println("Title: " + driver.getTitle());
            logger.println("URL: " + driver.getCurrentUrl());

            takeScreenshot("01_Landing_Page");
            Thread.sleep(2000);

            // ================== 2. START QUIZ ==================
            WebElement startBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.tagName("button"))
            );
            startBtn.click();
            logger.println("Start Quiz button clicked");

            WebElement question = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("question"))
            );
            logger.println("First question displayed");

            takeScreenshot("02_First_Question");
            Thread.sleep(2000);

            // ================== 3. ANSWER ALL QUESTIONS ==================
            int questionCount = 1;

            while (true) {

                List<WebElement> options = wait.until(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("opt"))
                );

                options.get(0).click(); // select first option
                logger.println("Answer selected for Question " + questionCount);

                takeScreenshot("03_Question_" + questionCount);
                Thread.sleep(1500);

                WebElement nextBtn = wait.until(
                        ExpectedConditions.elementToBeClickable(By.tagName("button"))
                );
                nextBtn.click();
                logger.println("Next button clicked");

                questionCount++;
                Thread.sleep(2000);

                if (driver.getCurrentUrl().contains("result.html")) {
                    break;
                }
            }

            // ================== 4. VERIFY RESULT PAGE ==================
            wait.until(ExpectedConditions.urlContains("result.html"));
            logger.println("Result page loaded");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("score")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("correct")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incorrect")));

            logger.println("Score, correct & incorrect answers verified");

            takeScreenshot("04_Result_Page");
            Thread.sleep(2000);

            logger.println("QUIZ AUTOMATION COMPLETED SUCCESSFULLY");

        } catch (Exception e) {
            if (logger != null) {
                logger.println("ERROR OCCURRED:");
                e.printStackTrace(logger);
            }
            e.printStackTrace();

        } finally {
            if (driver != null) {
                driver.quit();
                if (logger != null) logger.println("Browser closed");
            }

            if (logger != null) {
                logger.println("====================================");
                logger.println("AUTOMATION ENDED");
                logger.println("====================================");
                logger.close();
            }
        }
    }

    // ================== SCREENSHOT METHOD ==================
    public static void takeScreenshot(String name) throws Exception {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        File screenshotDir = new File("screenshots");
        if (!screenshotDir.exists()) screenshotDir.mkdir();

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        FileHandler.copy(
                src,
                new File("screenshots/" + name + "_" + timestamp + ".png")
        );
    }
}
