package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Selection {
  public   WebDriver driver;
    public Selection(WebDriver driver){
        this.driver=driver;

    }
    public void getBoolean(int position) {
            if(position==3) {
                driver.findElement(By.xpath("(//div[@class='_1vC4OE'])[3]")).click();
            }
            if(position==4) {
                driver.findElement(By.xpath("(//div[@class='_1vC4OE'])[4]")).click();
            }

        }
    }



