package com.guidersoft.pages;

import com.guidersoft.utility.Driver;
import com.guidersoft.utils.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import static com.guidersoft.utils.Locators.*;

public class HomePage extends BaseTest {
    // url ve locator'lar Locators interface'i icine yazilacak
    // import kisminda static olarak import edilecek

    public HomePage(WebDriver driverGelen){
        // constructor
        // 1. gelen driver'i bu classin (parent'in) driver'ina atayacak
        // 2. parent'in waiti tanimlayacak
        driver = driverGelen;
        // driver = Driver.getDriver();  // kullanilabilir, cünkü driver singlton static
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public HomePage(){
        this(Driver.getDriver());
    }

    public void open(String url){
        // ana sayfaya gidecek
        driver.get(url);
    }

    public void login(String username, String password){
        /*
            1.  Sayfada Login linki varsa
            2.  My Account'a tiklayacak
            3.  Login'e tiklayacak
            4.  username ve sifre girecek ve login butonuna tiklayacak
            5.  login oldugunu assert edecek
         */

        waitForPresence(lLoginLink);
        click(lMyAccount);
        click(lLoginLink);
        sendKeys(lLoginFormUsername, username);
        sendKeys(lLoginFormPassword, password);
        click(lLoginFormSubmitButton);
        waitForPresence(lLogoutLink);
    }

    public void logout(){
        /*
            1.  Sayfada Logout linki varsa
            2.  logout yapilacak
            3.  logout oldugunu assert edecek
         */
        waitForPresence(lLogoutLink);
        click(lMyAccount);
        click(lLogoutLink);
        waitForPresence(lLoginLink);


    }

    public void search(String text){
        /*
            1.  Aldigi text'i search'e send edip ara butonuna tiklayacak
            2.  arama sayfasini geldigini assert edecek
         */
    }

    public List<WebElement> getSearchList(){
        // arama sonucunda listelenen ürünleri element olarak return edecek
        return null;
    }

    public List<WebElement> getSearchList(String text){
        // arama sonucunda listelenen ürünlerinden gelen "text" i icerenleri return edecek
        return null;
    }



}
