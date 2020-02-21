package com.github.odinggg.tools.twitter;

import com.github.odinggg.tools.util.JacksonConvertUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @outhor Hansen
 * @create 2018-12-21 16:13
 */
@Service
public class ChromeFollowTwitterService {
    private final Logger logger = LoggerFactory.getLogger(ChromeFollowTwitterService.class);

    @Value("${user.name:}")
    private String name;
    @Value("${user.password:}")
    private String password;
    @Value("${user.temp-file-path:}")
    private String tempFilePath;

    static {
        String chromePath = new Object() {
            String getPath() {
                return Objects.requireNonNull(this.getClass().getClassLoader().getResource("./lib/chromedriver.exe"))
                        .getPath();
            }
        }.getPath().substring(1);
        System.setProperty("webdriver.chrome.driver", chromePath);
    }

    public void follow() throws Exception {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://www.twitter.com");
        WebElement elementByXPath = chromeDriver.findElementByXPath("//div[@class=\"StaticLoggedOutHomePage-buttons\"]/a[2]");
        elementByXPath.click();
        Thread.sleep(1000);
        WebElement userNameClassName = chromeDriver.findElementByXPath("//input[@class=\"js-username-field email-input js-initial-focus\"]");
        userNameClassName.clear();
        Random random = new Random();

        for (char c : name.toCharArray()) {
            userNameClassName.sendKeys(String.valueOf(c));
            Thread.sleep(random.nextInt(500));
        }
        Thread.sleep(1000);
        WebElement passwordClassName = chromeDriver.findElementByClassName("js-password-field");
        passwordClassName.clear();
        for (char c : password.toCharArray()) {
            passwordClassName.sendKeys(String.valueOf(c));
            Thread.sleep(random.nextInt(500));
        }
        Thread.sleep(800);
        WebElement logIn = chromeDriver.findElementByXPath("//button[@type=\"submit\"]");
        logIn.click();
        Thread.sleep(2000);
        Actions actions = new Actions(chromeDriver);
        actions.keyDown(Keys.CONTROL).sendKeys("T").keyUp(Keys.CONTROL).perform();
        chromeDriver.get("https://twitter.com/ObserverXo");
        Thread.sleep(1000);
        for (int i = 0; i < 8; i++) {
            chromeDriver.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            Thread.sleep(2000);
        }
        List<WebElement> elementsByXPath = chromeDriver.findElementsByXPath("//div[@class=\"stream\"]//li[position()>1]//p/a/b");
        List<String> collect = elementsByXPath.stream().filter(Objects::nonNull).filter(webElement -> {
            if (webElement.getText() != null && !webElement.getText().isEmpty()) {
                return true;
            } else {
                return false;
            }
        }).map(WebElement::getText).filter(s -> !s.matches("^从Tumblr来的优秀原创博主们$")).collect(Collectors.toList());
        Thread.sleep(1000);
        chromeDriver.get("https://twitter.com/following");
        Thread.sleep(1000);
        for (int i = 0; i < 10; i++) {
            chromeDriver.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            Thread.sleep(2000);
        }
        List<WebElement> follows = chromeDriver.findElementsByXPath("//div[@class=\"ProfileCard-content\"]/div[@class=\"ProfileCard-userFields\"]/span[@class=\"ProfileCard-screenname\"]/a/span/b");
        List<String> followNames = follows.stream()
                .filter(Objects::nonNull)
                .filter(webElement -> webElement.getText() != null && !webElement.getText().isEmpty()
                )
                .map(WebElement::getText)
                .collect(Collectors.toList());
        collect.removeAll(followNames);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(tempFilePath)));
        String s = JacksonConvertUtil.objectToJson(collect);
        bufferedWriter.write(s);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
        collect.forEach(name -> {
            try {
                TumblrAttention.attention(name, chromeDriver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        chromeDriver.quit();
        logger.info("完成");
    }
}
