package dummyApiTests;

import com.jayway.jsonpath.JsonPath;
import mailTravel.apis.ApiRequests;
import mailTravel.framework.EnvironmentConfiguration;
import mailTravel.pages.PageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EmployeeApiTests  extends PageBase {

    @Test
    public void printCountandNamesOfEmployees() {
        String apiResponseNew = new ApiRequests().getApiResponse(EnvironmentConfiguration.getDummyApi() + "/api/v1/employees");
        List<String> employeeRecord = JsonPath.parse(apiResponseNew).read("$.data[*].employee_name");
        log.info("count of employees" + employeeRecord.size());
        for (String name : employeeRecord) {
            log.info(" employee names " + name);
        }
        Assert.assertTrue(employeeRecord.size() == 24, "Incorrect employee record count");
    }

    @Test
    public void addEmployeeRecord() {
        String apiResponseNew = new ApiRequests().postRequest("https://dummy.restapiexample.com/api/v1/create");
        System.out.println("response " + apiResponseNew);
        // Output in console
        // response{"status":"success","data":{"name":"test","salary":"345","age":"34","id":9797},"message":"Successfully! Record has been added."}
    }

    public void updateRecord(){
        // TODO
        // String apiResponseNew = new ApiRequests().putRequest("https://dummy.restapiexample.com/api/v1/update/2");
     }
}
