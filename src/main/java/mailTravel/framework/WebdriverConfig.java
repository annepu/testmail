//package mailTravel.framework;
//
//public class WebdriverConfig {
//
//    private String browserType;
//
//    private String seleniumMode;
//
//    private DeviceProfiles deviceProfile;
//
//    private WebDriverConfig() {
//        // Use the static method, it's cleaner
//    }
//
//    public static WebDriverConfig aWebDriverConfig() {
//        return new WebDriverConfig()
//                .withSeleniumMode("SINGLE")
//                .withSeleniumServer("local");
//    }
//
//    public WebDriverConfig withBrowser(String browser) {
//        this.browserType = browser;
//        log.info("getting the browser " + this);
//        return this;
//    }
//
//    public WebDriverConfig withDeploymentEnvironment(String env) {
//        this.deploymentEnvironment = env;
//        log.info("getting the environment " + this);
//        return this;
//    }
//
//    public WebDriverConfig withSeleniumMode(String mode) {
//        this.seleniumMode = mode;
//        log.info("getting the mode " + this);
//        return this;
//    }
//
//    public WebDriverConfig withSeleniumServer(String server) {
//        this.seleniumServer = server;
//        log.info("getting the selenium server " + this);
//        return this;
//    }
//
//    public WebDriverConfig withSeleniumDeviceProfile(String profile) {
//        this.deviceProfile = DeviceProfiles.valueOf(profile);
//        log.info("getting the device profile " + this);
//        return this;
//    }
//
//    public String getBrowserType() {
//        log.info("getting the browserType " + browserType);
//        return browserType;
//    }
//
//
//    public String getSeleniumMode() {
//        log.info("getting the selenium mode " + seleniumMode);
//        return seleniumMode;
//    }
//
//    public String getOS() {
//        String os = deviceProfile.getOs();
//        log.info("getting the os " + os);
//        return os;
//    }
//
//    public String getOsVersion(){
//        String osVersion = deviceProfile.getOsVersion();
//        log.info("getting the OS version: "+ osVersion);
//        return  osVersion;
//    }
//
//    public String getDeviceType() {
//        String deviceType = deviceProfile.getDeviceType();
//        log.info("getting the device type " + deviceType);
//        return deviceType;
//    }
//
//    public String getDevice() {
//        log.info("getting the device details " + deviceProfile.getDeviceManufacturer());
//        return deviceProfile.getDeviceManufacturer();
//    }
//
//    public String getBrowserVersion() {
//        String browserVersion = deviceProfile.getBrowserVersion();
//        log.info("getting the device version " + browserVersion);
//        return browserVersion;
//    }
//
//    public String getDeviceName() {
//        log.info(deviceProfile.getDeviceModel());
//        return deviceProfile.getDeviceModel();
//    }
//}
