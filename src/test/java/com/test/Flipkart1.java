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

import java.util.*;

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

    @Test
    public void test3() throws InterruptedException {
        Boolean b = getDetails2();
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

        a.delay();///thread.sleep

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
    public Boolean data2(String product3, String filter3) throws InterruptedException {
        product3 = product3.trim();

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
        a.insertShoes().sendKeys(product3);
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
            if (filter3.equalsIgnoreCase(temp)) {
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
        System.out.println("product = " + product3);
        System.out.println("position = " + position);
        System.out.println(filter3);


        //sorting prices
        List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='_1vC4OE']"));
        Iterator<WebElement> itr8=list1.iterator();
        while(itr8.hasNext()){
            WebElement temp1=itr8.next();
            String temp2=temp1.getText();
            //System.out.println("temp2"+  temp2);
            String price_without_dollar=temp2.split("\u20B9")[1];
            a1.add(price_without_dollar);
        }

        a2 = (ArrayList) a1.clone();
        Collections.sort(a2);

        System.out.println("a1 = "+a1);
        System.out.println("a2 = "+a2);
//        Assert.assertTrue(a1.equals(a2));

        //selscting 2nd position shoes
         a.secondPositionshoe().click();
        String parenttitle= driver.getTitle();
        System.out.println("parent"  +parenttitle);
         Assert.assertEquals("Shoes - Buy Products Online at Best Price in India - All Categories | Flipkart.com",parenttitle);
        Set<String> handle= driver.getWindowHandles();
        int countt=handle.size();
        System.out.println("count of no of tabs         "            +countt);
        Iterator<String> it= handle.iterator();
        String parentwindow1=it.next();
        String childwindow1=it.next();

        driver.switchTo().window(childwindow1);
        String childtitle= driver.getTitle();
        System.out.println("chiltitle"    +childtitle);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.shoeSize().click();
        //assertion1----------------------------------------


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String assertname1=a.pName1();

        String assert1=a.pPrice1();
        String Pprice1=assert1.split("\u20B9")[1];


        System.out.println("assertname1  :  "   +assertname1 );

        System.out.println("Pprice1 = "   +Pprice1 );
        int pro1=Integer.parseInt(Pprice1);
        System.out.println("After converssion first product  price to int = "   +pro1 );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.addTocart().click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //again back to parent page
       driver.switchTo().window(parentwindow1);
        System.out.println("parentwindow1 id"   +parentwindow1);
        System.out.println("select another shoes from parernt window");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.selectPosition3().click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //switching to new child window

        Set<String> handle2= driver.getWindowHandles();
        Iterator<String> it3= handle2.iterator();

            String p1= it3.next();
            String c1=it3.next();
            String c2=it3.next();
            System.out.println("p1 id"   +p1);
            System.out.println("c1 id"   +c1);
           System.out.println("c2 id"   +c2);
        driver.switchTo().window(c2);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String assertname2=a.pName2();
        String assert2=a.pPrice2();
        String Pprice2=assert2.split("\u20B9")[1];


        System.out.println("assertname2  :  "   +assertname2 );

        System.out.println("Pprice2 = "   +Pprice2 );

        int pro2=Integer.parseInt(Pprice2);
        System.out.println("After converssion first product  price to int = "   +pro2 );
    a.secondShoesize().click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.addTocart2().click();
        System.out.println("second shoes selected");


//Basket assertion

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String assertname3=a.pName3();
        String assert3=a.pPrice3();
        String Pprice3=assert3.split("\u20B9")[1];
        System.out.println("assertname3  :  "   +assertname3 );

        System.out.println("Pprice3 = "   +Pprice3 );
        int pro3=Integer.parseInt(Pprice3);
        System.out.println("After converssion first product  price to int = "   +pro3 );

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String assertname4=a.pName4();
        String assert4=a.pPrice4();
        String Pprice4=assert4.split("\u20B9")[1];
        System.out.println("assertname4  :  "   +assertname4 );

        System.out.println("Pprice4 = "   +Pprice4);
        int pro4=Integer.parseInt(Pprice1);
        System.out.println("After converssion first product  price to int = "   +pro4 );
        int add1=pro1+pro2;
        System.out.println("Addition of selection= "   +add1 );


  Assert.assertEquals(Pprice1,Pprice3);
  System.out.println("1st product price tested propely");
        Assert.assertEquals(Pprice2,Pprice4);
        System.out.println("2nd product price tested propely");
        ///basket total
     String bt1=   a.basketTotal1();

        String bt2=bt1.split("\u20B9")[1];

        int basketpricetotal=Integer.parseInt(bt2);
        System.out.println("basketpricetotal  :  "   +basketpricetotal);
        System.out.println("comparison");
        Assert.assertEquals(add1,basketpricetotal);




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

    public Boolean getDetails2() throws InterruptedException {

        ExcelFile configuration = new ExcelFile(System.getProperty("user.dir") + "\\src\\test\\resource\\Flipkart.xlsx");
        //  int rows = configuration.getRowCount(0);
        Object[][] signin_credentials = new Object[1][2];
        String product3 = configuration.getData(0, 1, 0);
        String filter3 = configuration.getData(0, 1, 1);


        return data2(product3,filter3);
    }


}