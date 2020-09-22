package com.test;

import com.codeborne.selenide.Configuration;
import com.test.Action;
import com.test.ExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Flipkart1 {
    WebDriver driver;

    @Test
    public void test1() {
        Boolean b = getDetails();
        Assert.assertTrue(b);
    }

    @Test
    public void test2() {
        Boolean b = getDetails();
        Assert.assertTrue(b);
    }

    public Boolean data(String product, String filter2) {
        product = product.trim();

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resource\\chromedriver.exe");

        //lauching chrome in incognito mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);

        //to make full screen
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        Action a = new Action(driver);
        a.popUp().click();
        a.insertShoes().sendKeys(product);
        a.hitSearch().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      //Sorting of filter from excel
        List<WebElement> total = driver.findElements(By.xpath("//div[@class='_3ywJNQ']/div"));
        Iterator<WebElement> itTotal = total.iterator();
        ArrayList a1 = new ArrayList();
        ArrayList a2 = new ArrayList();
        int count = 0;
        int position = 0;
        while (itTotal.hasNext()) {
            count++;
            String temp = itTotal.next().getText();
            temp = temp.trim();
            if (filter2.equalsIgnoreCase(temp)) {
                position = count;
                driver.findElement(By.xpath("//div[@class='_3ywJNQ']/div[" + position + "]")).click();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("temp = " + temp);
        }
        System.out.println("product = " + product);
        System.out.println("position = " + position);
        System.out.println(filter2);


        //sorting prices
        List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='_1vC4OE']"));
        Iterator<WebElement> itr8=list1.iterator();
        while(itr8.hasNext()){
            WebElement temp1=itr8.next();
            String temp2=temp1.getText();
            String price_without_dollar=temp2.split("\u20B9")[1];
            a1.add(price_without_dollar);
        }

        a2 = (ArrayList) a1.clone();
        Collections.sort(a2);

        System.out.println("a1 = "+a1);
        System.out.println("a2 = "+a2);
//        Assert.assertTrue(a1.equals(a2));

    return a1.equals(a2);
    }

//data fetching from excel
    public Boolean getDetails() {

        ExcelFile configuration = new ExcelFile(System.getProperty("user.dir") + "\\src\\test\\resource\\Flipkart.xlsx");
        //  int rows = configuration.getRowCount(0);
        Object[][] signin_credentials = new Object[1][2];
        String product = configuration.getData(0, 0, 0);
        String filter2 = configuration.getData(0, 0, 1);

        return data(product, filter2);
    }
}