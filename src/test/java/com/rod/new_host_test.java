package com.rod;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class new_host_test {
    public static WindowsDriver driver ;
    @BeforeClass (alwaysRun = true)
        public static void setup () throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Users\\Public\\Emerson\\NGF-ModbusManager//NGFMdbsMgr");
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test (priority = 1)
        public static void buttons () throws InterruptedException {
        Thread.sleep(1000);                                    //waiting is for action to be seen
        driver.findElementByAccessibilityId("4081").click();   //status
        Thread.sleep(1000);
        driver.findElementByAccessibilityId("4082").click();   //setup
        Thread.sleep(1000);
        driver.findElementByAccessibilityId("4083").click();   //version
        Thread.sleep(1000);
        driver.findElementByAccessibilityId("1906").getText();   //SW_version
    }
    @Test (priority = 2)
        public static void version () {
        if (driver.findElementByAccessibilityId("1906").getText().contains("v3.1.2.8")) {  //version verification
            System.out.println("the version is 3.1.2.8");
        } else {
            System.out.println("there is another version");
        }
    }
    @Test (priority = 3)
        public static void closing () throws InterruptedException {
        driver.findElementByName("Закрыть").click();           //close
        Thread.sleep(1000);
        driver.findElementByAccessibilityId("2").click();      //cancel
    }
}