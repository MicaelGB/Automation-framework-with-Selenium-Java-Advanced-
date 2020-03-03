package com.ea.test.seleniumtest;

import com.ea.framework.base.Base;
import com.ea.framework.base.BrowserType;
import com.ea.framework.base.DriverContext;
import com.ea.framework.base.FrameworkInitialize;
import com.ea.test.pages.HomePage;
import com.ea.test.pages.LoginPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.ea.framework.base.Base.CurrentPage;

import static java.lang.Thread.holdsLock;
import static java.lang.Thread.sleep;

public class LoginTest extends FrameworkInitialize {


    @Before
    public void Initialize(){
        InitializeBrowser(BrowserType.Chrome);
        DriverContext.Browser.GoToUrl("http://eaapp.somee.com/");
    }

    @Test
    public void Login() throws InterruptedException {
       /*without POM
        _driver.findElement(By.name("UserName")).sendKeys("admin");
        _driver.findElement(By.name("Password")).sendKeys("admin");
        _driver.findElement(By.name("Login")).submit();*/

       CurrentPage = GetInstance(HomePage.class);
       CurrentPage = CurrentPage.As(HomePage.class).ClickLogin();
       Thread.sleep(2000);
       CurrentPage.As(LoginPage.class).Login("admin","password");
    }
}
