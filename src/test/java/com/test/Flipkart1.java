package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.util.*;

public class Flipkart1 {
    WebDriver driver;
    PomFile action = new PomFile(driver);

    @Test
    public void test1() {
        Assert.assertTrue(getDetails());
    }

    @Test
    public void test2() {
        Assert.assertTrue(getDetails());
    }

    @Test
    public void test3() throws Exception {
        Assert.assertTrue(getDetails2());
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

        // to handle popup
        if(action.popUp().isEnabled()){
            action.popUp().click();
        }
        action.insertShoes().sendKeys(product);
        action.hitSearch().click();

        action.delay();//thread.sleep
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
                action.delay();

            }
            System.out.println("temp = " + temp);
        }
        System.out.println("product = " + product);
        System.out.println("position = " + position);
        System.out.println(filter2);


        //sorting prices
        List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='_1vC4OE']"));
        Iterator<WebElement> iterator8=list1.iterator();
        while(iterator8.hasNext()){
            WebElement temp1=iterator8.next();
            String temp2=temp1.getText();
            String price_without_dollar=temp2.split("\u20B9")[1];
            a1.add(price_without_dollar);
        }

        a2 = (ArrayList) a1.clone();
        Collections.sort(a2);

        System.out.println("a1 = "+a1);
        System.out.println("a2 = "+a2);
    return a1.equals(a2);
    }
    public Boolean data2(String product3, String filter3) throws Exception {
        product3 = product3.trim();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resource\\chromedriver.exe");

        //Lauching chrome in incognito mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);

        //To make full screen
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        PomFile a = new PomFile(driver);
       if(a.popUp().isDisplayed()) {
           a.popUp().click();
       }
        a.insertShoes().sendKeys(product3);
        a.hitSearch().click();
        action.delay();
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
                action.delay();

            }
            System.out.println("temp = " +temp);
        }
        System.out.println("product = " +product3);
        System.out.println("position = " +position);
        System.out.println(filter3);


        //Sorting prices ie pagination of first page
        List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='_1vC4OE']"));
        Iterator<WebElement> iterator=list1.iterator();
        while(iterator.hasNext()){
            WebElement temp1=iterator.next();
            String temp2=temp1.getText();
            //Remove Dollar symbol from first position
            String price_without_dollar=temp2.split("\u20B9")[1];
            a1.add(price_without_dollar);
        }

        a2 = (ArrayList) a1.clone();
        Collections.sort(a2);

        System.out.println("a1 = "+a1);
        System.out.println("a2 = "+a2);

        Selection select=new Selection(driver);
        //selecting 2nd position shoes and select  is object of Selection class
        select.getBoolean(3);
        String parent_title= driver.getTitle();
        System.out.println("parent"  +parent_title);
        Assert.assertEquals("Shoes - Buy Products Online at Best Price in India - All Categories | Flipkart.com",parent_title);
        Set<String> number_of_tabs= driver.getWindowHandles();
        int counting=number_of_tabs.size();
        System.out.println("count of no of tabs"+counting);
        Iterator<String> it= number_of_tabs.iterator();
        String parent_window1=it.next();
        String child_window1=it.next();
        driver.switchTo().window(child_window1);
        String child_title= driver.getTitle();
        System.out.println("chiltitle"+child_title);
        action.delay();
        a.shoeSize().click();
        action.delay();
        //---------------------------------assertion1----------------------------------------//

        //Bagrin+Running shoes for Men and substring(removing) (Red)
        String brand=a.brandName1();// Bagrin
        String including_Color=a.shoeName1();//Running shoes for Men(Red)
        String excluding_Color=including_Color.substring(0,including_Color.lastIndexOf("(")).trim();
        String shoename1=brand+excluding_Color;
        System.out.println("shoename1="+shoename1);
        String price_with_dollar1=a.shoePrice1();
        String price_without_dollar1=price_with_dollar1.split("\u20B9")[1];
        System.out.println("price_without_dollar1 = "   +price_without_dollar1 );
        //conversion from string to Integer
        int shoe_price1=Integer.parseInt(price_without_dollar1);
        System.out.println("After conversion first product  price to int = "+shoe_price1);
        action.delay();
        a.addToCartShoe1().click();
        action.delay();
        //again back to parent page
        driver.switchTo().window(parent_window1);
        System.out.println("parentwindow1 id="+parent_window1);
        System.out.println("select another shoes from parent window");
        action.delay();
        select.getBoolean(4);
        action.delay();
        //switching to new child window
        Set<String> window_count= driver.getWindowHandles();
        Iterator<String> it3=window_count.iterator();
            String parenttab1= it3.next();
            String childtab1=it3.next();
            String childtab2=it3.next();
            System.out.println("parenttab1 id="+parenttab1);
            System.out.println("childtab1 id="+childtab1);
           System.out.println("childtab2 id="+childtab2);
        driver.switchTo().window(childtab2);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String brand1=a.brandName2();// Bagrin
        String including_Color1=a.shoeName2();//Running shoes for Men(Red)
        String excluding_Color1=including_Color1.substring(0,including_Color1.lastIndexOf("(")).trim();//Running shoes for men
        String shoename2=brand1+excluding_Color1;//Bagrin+Running shoes for men
        System.out.println("shoename2="+shoename2);
        String price_with_dollar2=a.shoePrice2();
        String price_without_dollar2=price_with_dollar2.split("\u20B9")[1];
        System.out.println("price_with_dollar2= " +price_without_dollar2 );
        int shoe_price2=Integer.parseInt(price_without_dollar2);
        System.out.println("shoe_price2="+ shoe_price2 );
        a.secondShoesize().click();
        action.delay();
        a.addToCartShoe2().click();
        System.out.println("second shoes selected");
       //Card Items assertion
        action.delay();
        String shoe_cart1=a.cartShoeName1();
        String cart_shoe1_dollar=a.cartshoePrice3();
        String cart_shoe1_withoutdollar=cart_shoe1_dollar.split("\u20B9")[1];
        System.out.println("shoe_cart1:"+shoe_cart1 );
        System.out.println("cart_shoe1_withoutdollar="+cart_shoe1_withoutdollar);
        int cartshoe1=Integer.parseInt(cart_shoe1_withoutdollar);
        System.out.println("After converssion first product  price to int ="+cartshoe1);
        action.delay();
        String shoe_cart2=a.cartShoeName2();
        String cart_shoe2_withdollar=a.cartshoePrice4();
        String cart_shoe2_withoutdollar=cart_shoe2_withdollar.split("\u20B9")[1];
        System.out.println("shoe_cart2:"+shoe_cart2);
        System.out.println("cart_shoe2_withoutdollar ="+cart_shoe2_withoutdollar);
        int cartshoe2=Integer.parseInt(price_without_dollar1);
        System.out.println("After converssion first product  price to int = "+cartshoe2);
        int selection_price=shoe_price1+shoe_price2;
        System.out.println("Addition of selection= "+selection_price);

        Assert.assertTrue(shoename1.contains(shoe_cart1));
        Assert.assertTrue(shoename2.contains(shoe_cart2));
        System.out.println("Comparison going on");
        Assert.assertEquals(price_without_dollar1,cart_shoe1_withoutdollar);
        System.out.println("1st product price tested properly");
        Assert.assertEquals(price_without_dollar2,cart_shoe2_withoutdollar);
        System.out.println("2nd product price tested properly");
        ///basket total
        String bt1=   a.basketTotal1();
        System.out.println("bt1"+bt1);
        String bt2=bt1.split("\u20B9")[1];

        int cartpricetotal=Integer.parseInt(bt2);
        System.out.println("basketpricetotal :"+cartpricetotal);
        System.out.println("comparison of selection and cartprice total");
        Assert.assertEquals(selection_price,cartpricetotal);
        return a1.equals(a2);

    }

       //data fetching from excel
       public Boolean getDetails() {
        ExcelFile configuration = new ExcelFile(System.getProperty("user.dir") + "\\src\\test\\resource\\Flipkart.xlsx");
        Object[][] signin_credentials = new Object[1][2];
        String product = configuration.getData(0, 0, 0);
        String filter2 = configuration.getData(0, 0, 1);
        return data(product, filter2);
    }
       public Boolean getDetails2() throws  Exception {
        ExcelFile configuration = new ExcelFile(System.getProperty("user.dir") + "\\src\\test\\resource\\Flipkart.xlsx");
        Object[][] signin_credentials = new Object[1][2];
        String product3 = configuration.getData(0, 1, 0);
        String filter3 = configuration.getData(0, 1, 1);
        return data2(product3,filter3);
    }


}