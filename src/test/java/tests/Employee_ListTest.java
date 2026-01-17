package tests;

import base.BaseTestLogin;
import org.testng.annotations.BeforeMethod;
import pages.Employee_ListPage;
import pages.User_ManagementPage;

public class Employee_ListTest extends BaseTestLogin {
    Employee_ListPage employeeListPage;

    @BeforeMethod
    public void initPage() {
        employeeListPage = new Employee_ListPage(driver);
    }
}
