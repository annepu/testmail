package mailTravel.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import java.util.HashMap;
import java.util.Map;

public class TestBase {

    protected static WebDriver driver = null;
    private final DesiredCapabilities capabilities = new DesiredCapabilities();
    protected static Logger log = Logger.getLogger(TestBase.class);
    public static String environment, baseURL, BrowserName;


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
                case "IE":
                    System.setProperty("webdriver.ie.driver", EnvironmentConfiguration.getInternetExplorerPath());
                    return new InternetExplorerDriver();
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

}
