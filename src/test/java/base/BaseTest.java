package base;

import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public static String token, baseURI ;

    @BeforeSuite
    public void setUp(){
       token = utils.TokenManager.getToken();
       baseURI = utils.Helper.get("BASE_URI");
    }
}
