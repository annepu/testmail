package mailTravel.framework;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TestBase {

    protected static WebDriver driver = null;
    private final DesiredCapabilities capabilities = new DesiredCapabilities();
    protected static Logger log = Logger.getLogger(TestBase.class);
    public static String environment, baseURL,suiteName, BrowserName,testName;
    public static ExtentReports extent;


    @BeforeClass(alwaysRun= true)
    @Parameters({"browser","env"})
    public void initialiseTests(@Optional("CHROME") String browser,  @Optional("test") String env, ITestContext context){
        environment = env;
        BrowserName = browser;
        EnvironmentConfiguration.populate(env);
        driver = openLocalBrowser(browser);
        baseURL = EnvironmentConfiguration.getBaseURL();
    }

    private WebDriver openLocalBrowser(String  browserType) {
        try {
            switch (browserType) {
                case "CHROME":
                    System.setProperty("webdriver.chrome.driver", DriverPaths.CHROMEPATH);
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-extensions");
                    Map<String, Object> prefs = new HashMap<>();
                    Map<String, Object> profile = new HashMap<String, Object>();
                    Map<String, Object> contentSettings = new HashMap<String, Object>();
                    contentSettings.put("geolocation", 1);
                    profile.put("managed_default_content_settings", contentSettings);
                    prefs.put("profile", profile);
                    options.setExperimentalOption("prefs", prefs);
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    return new ChromeDriver(options);
                case "FIREFOX":
                    System.setProperty("webdriver.gecko.driver", EnvironmentConfiguration.getGeckoDriverPath());
                    return new FirefoxDriver();
                case "SAFARI":
                    return new SafariDriver();
                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + browserType +
                            "( expected 'firefox', 'chrome', or 'ie')");
            }
        } catch (Exception e) {
            log.error("Failed to open browser " + browserType + e);
            throw new IllegalStateException(e);
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            log.info("quitting driver after class:- " + getClass().getSimpleName());
            driver.quit();

        } catch (Exception e) {
            log.info("Error while quitting driver:- " + e.toString());
        }
    }

    @BeforeSuite(alwaysRun = true)
    @Parameters({"env"})
    public void extentSetup(ITestContext context, @Optional("test") String env) throws IOException {
        ExtentReportManager.setOutputDirectory(context);
        extent = ExtentReportManager.getInstance();
        suiteName = context.getCurrentXmlTest().getSuite().getName();
    }

    @AfterSuite(alwaysRun = true)
    public void closeExtentReport() {
        extent.flush();
    }

    @BeforeMethod(alwaysRun = true)
    public final void testCaseName(Method method) {
        testName = method.getName() ;
        ExtentTestManager.startTest(testName);

    }

    @AfterMethod(alwaysRun = true)
    @Parameters("mode")
    public final void results(ITestResult testResult, Method method, @Optional("single") String mode) {
        int result = testResult.getStatus();
        ExtentTestManager.getTest().getTest().setStartedTime(Helpers.getTime(testResult.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(Helpers.getTime(testResult.getEndMillis()));
        switch (result) {
            case ITestResult.SUCCESS:
                log.debug("(Pass)");
                break;
            case ITestResult.SKIP:
                log.debug("(Skipped)");
                ExtentTestManager.getTest().log(LogStatus.SKIP, "SKIPPED");
                break;
            default:
                log.error("Unexpected test result status code: " + result);
        }
        log.debug("*******************************************************************************************");
        ExtentTestManager.endTest();
        extent.flush();
    }


}
