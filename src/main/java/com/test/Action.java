package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Action {

    public  WebDriver driver;
    //Constructor
    public Action(WebDriver driver){
        this.driver=driver;
    }

    By popUpCross = By.xpath("//div[@class='mCRfo9']/div/div/button");
    By insertField=By.xpath("//input[@name='q']");
    By hitButton=By.xpath("//button[@class='vh79eN']");
    //to close popup
    public WebElement popUp(){
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

}
