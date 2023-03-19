package mailTravel.framework;

import org.testng.log4testng.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static mailTravel.framework.DriverPaths.GECKODRIVERPATH;
import static mailTravel.framework.DriverPaths.IEPATH;

public class EnvironmentConfiguration {

    private static Properties ENV_CONFIG= null;

    private EnvironmentConfiguration(){

    }

    public static String getInternetExplorerPath() {
        return IEPATH;
    }

    public static String getGeckoDriverPath() {
        return GECKODRIVERPATH;
    }

    public static String getBaseURL(){
        return ENV_CONFIG.getProperty("baseURL");
    }

    public static void populate(String environmentName) {
        Logger log = Logger.getLogger(EnvironmentConfiguration.class);
        log.info("Loading environment properties for profile " + environmentName);
        String propsResourceName = "/" + environmentName + "_config.properties";
        log.info("Loaded environment properties for profile " + environmentName);
        try (InputStream input = EnvironmentConfiguration.class.getResourceAsStream(propsResourceName)) {
            ENV_CONFIG = new Properties();
            ENV_CONFIG.load(input);
        } catch (IOException e) {
            log.error("Could not load environment properties - this is going to break...", e);
        }
    }
}
