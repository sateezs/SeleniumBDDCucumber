package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        System.setProperty("webdriver.chrome.driver", "libs/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        /*
        Maximize the screen or window
         */
        driver.manage().window().maximize();

        /*
        Launching URL
         */
        driver.get("https://formy-project.herokuapp.com/switch-window");
        Thread.sleep(2000);

        /*
          Switch window Actions
         */
        WebElement openWindow = driver.findElement(By.id("new-tab-button"));
        openWindow.click();

        String window0 = driver.getWindowHandle();
        for (String window1 : driver.getWindowHandles()) {
            if (!window1.equals(window0)) {
                driver.switchTo().window(window1);
            }
        }
        Thread.sleep(4000);

        driver.switchTo().window(window0);

        /*
        Accepting alert in the window
         */
        WebElement alertEle = driver.findElement(By.id("alert-button"));
        alertEle.click();
        Thread.sleep(4000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
//        driver.switchTo().alert().dismiss();
//        driver.switchTo().alert().sendKeys("asdfasdf");


        /*
        JavaScript Executor testing -- click ();
         */

        driver.get("https://formy-project.herokuapp.com/modal");


        /*
         * Close the driver
         */
        driver.quit();
    }
}