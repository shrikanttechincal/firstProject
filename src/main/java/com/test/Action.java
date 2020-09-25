package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Action {

    public WebDriver driver;

    //Constructor
    public Action(WebDriver driver) {
        this.driver = driver;
    }

    By popUpCross = By.xpath("//div[@class='mCRfo9']/div/div/button");
    By insertField = By.xpath("//input[@name='q']");
    By hitButton = By.xpath("//button[@class='vh79eN']");
    By secondpositionShoe = By.xpath("(//div[@class='_1vC4OE'])[2]");
    By shoeSize1 = By.xpath("//a[contains(text(),'6')]");
    By addCart1 = By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']");

    By shoe2 = By.xpath("(//div[@class='_1vC4OE'])[3]");
    By size2 = By.xpath("//a[contains(text(),'6')]");
    By addCart2 = By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']");
    By name1= By.xpath("//span[@class='_35KyD6']");
    By price1=By.xpath("//div[@class='_1vC4OE _3qQ9m1']");
    By name2= By.xpath("//span[@class='_35KyD6']");
    By price2=By.xpath("//div[@class='_1vC4OE _3qQ9m1']");
    By name3=By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[3]/div/div[1]/div[1]/div[1]/a");
    By price3=By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[3]/div/div[1]/div[1]/span[1]");
    By name4=By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/div[1]/a");
    By price4=By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/span[1]");
    By basketTotal=By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[3]/div/span/div/div/span");//a[@class='_3ko_Ud']
    By xname1=By.xpath("//span[@class='_2J4LW6']");
    By yname1=By.xpath("//span[@class='_2J4LW6']");


    public String xName1(){
        return driver.findElement(xname1).getText();
    }
    public String yName1(){
        return driver.findElement(yname1).getText();
    }


    public static void delay(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String basketTotal1() {
        return driver.findElement(basketTotal).getText();
    }


public String pName1() {
    return driver.findElement(name1).getText();
}
    public String pPrice1() {
        return driver.findElement(price1).getText();
    }
    public String pName2() {
        return driver.findElement(name2).getText();
    }
    public String pPrice2() {
        return driver.findElement(price2).getText();
    }


    public String pName3() {
        return driver.findElement(name3).getText();
    }
    public String pPrice3() {
        return driver.findElement(price3).getText();
    }
    public String pName4() {
        return driver.findElement(name4).getText();
    }
    public String pPrice4() {
        return driver.findElement(price4).getText();
    }




    //to close popup
    public WebElement popUp() {
        return driver.findElement(popUpCross);
    }


    //to give input field shoes
    public WebElement insertShoes() {
        return driver.findElement(insertField);
    }

    //to hit enter
    public WebElement hitSearch() {
        return driver.findElement(hitButton);
    }

    public WebElement secondPositionshoe() {

        return driver.findElement(secondpositionShoe);
    }

    public WebElement shoeSize() {

        return driver.findElement(shoeSize1);
    }

    public WebElement addTocart() {

        return driver.findElement(addCart1);
    }

    public WebElement selectPosition3() {
        return driver.findElement(shoe2);
    }

    public WebElement secondShoesize() {
        return driver.findElement(size2);
    }

    public WebElement addTocart2() {
        return driver.findElement(addCart2);
    }

}
