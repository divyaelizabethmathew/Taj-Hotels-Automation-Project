package testpkg;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepkg.TajBaseClass;
import pagepkg.LoginPage;
import utilspkg.Excelutils;

public class LoginTest extends TajBaseClass {

    @DataProvider(name = "loginData")
    public Object[][] loginData() throws IOException {
        String filePath = "./src/test/resources/testdata/TajLoginData.xlsx";
        String sheetName = "Sheet1";
        return Excelutils.getTestData(filePath, sheetName);
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String loginType,String mobileNumber,String email,String membershipType,String membershipNumber) {
        test = extent.createTest("Login Test - " + loginType);
        LoginPage login = new LoginPage(driver);
        // Click Login
        login.loginMthd();
        if (loginType.equalsIgnoreCase("Mobile")) {
            login.mobileMthd(mobileNumber);
        } 
        else if (loginType.equalsIgnoreCase("Email")) {
            login.emailMthd(email);
        } 
        else if (loginType.equalsIgnoreCase("Membership")) {
            login.memMthd(membershipType, membershipNumber);
        }
        login.continueMthd();
    }
}