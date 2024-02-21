package TestCases.WebUITests.commonDataProviders;


import Framework.java.io.unity.core.readers.DataReader;
import org.testng.annotations.DataProvider;

public class commonDataProvider {
    @DataProvider(name = "cs_login")
    public Object[][] cs_login_data(){
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 1);
    }

    @DataProvider(name = "agency_name")
    public Object[][] agency_name_data(){
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 2);
    }

    @DataProvider(name = "add_employee_to_agency")
    public Object[][] employee_agency_map(){
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 6);
    }

    @DataProvider(name = "employee_data")
    public Object[][] employee_details(){
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 4);
    }
}
