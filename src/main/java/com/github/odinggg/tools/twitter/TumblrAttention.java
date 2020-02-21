package com.github.odinggg.tools.twitter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 描述:
 * 关注
 *
 * @outhor Hansen
 * @create 2018-12-24 10:51
 */
public class TumblrAttention {
    public static void attention(String userName, ChromeDriver driver) throws Exception {
        driver.get("https://twitter.com/" + userName);
        Thread.sleep(1000);
        WebElement notFollow = null;
        try {
            notFollow = driver.findElementByXPath("//div[@class=\"user-actions btn-group not-muting not-following\"]");
        } catch (Exception e) {
            if (e instanceof NoSuchElementException) {
                try {
                    notFollow = driver.findElementByXPath("//div[@class=\"user-actions btn-group not-following not-muting can-dm \"]");
                } catch (Exception e1) {
                    if (e1 instanceof NoSuchElementException)return;
                }
            }
        }
        if (notFollow==null)return;
        WebElement followElement = notFollow.findElement(By.className("EdgeButton--secondary"));
        followElement.click();
        Thread.sleep(1000);
    }

}
