package mailTravel.framework;

import com.relevantcodes.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.Reporter;

import java.io.File;

public class ExtentReportManager {

	private static ExtentReports extent;

	private static ITestContext context;

	public synchronized static ExtentReports getInstance() {
		File extentReportConfig = new File(System.getProperty("user.dir") + "/src/main/resources/extentreport.xml");
		if (extent == null) {
			File outputDirectory = new File(context.getOutputDirectory());
			File resutlDirectory = new File(System.getProperty("user.dir") + "/target/htmlReport");
			extent = new ExtentReports(resutlDirectory + File.separator + "AutomationTestReport.html", true);
			extent.loadConfig(extentReportConfig);
			Reporter.log("Extent Report directory :" + resutlDirectory, true);
		}
		return extent;
	}

	public static void setOutputDirectory(ITestContext context) {
		ExtentReportManager.context = context;
	}

}
