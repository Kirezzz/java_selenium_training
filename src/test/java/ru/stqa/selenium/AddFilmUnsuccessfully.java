package ru.stqa.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddFilmUnsuccessfully {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddFilmUnsuccessfully() throws Exception {
    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys("Also known as");
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("2021");
    driver.findElement(By.name("duration")).clear();
    driver.findElement(By.name("duration")).sendKeys("180");
    driver.findElement(By.name("rating")).clear();
    driver.findElement(By.name("rating")).sendKeys("10");
    driver.findElement(By.name("notes")).clear();
    driver.findElement(By.name("notes")).sendKeys("Personal notes");
    driver.findElement(By.name("taglines")).clear();
    driver.findElement(By.name("taglines")).sendKeys("Taglines");
    driver.findElement(By.name("plotoutline")).clear();
    driver.findElement(By.name("plotoutline")).sendKeys("Plot outline");
    driver.findElement(By.name("plots")).clear();
    driver.findElement(By.name("plots")).sendKeys("Plots");
    driver.findElement(By.id("text_languages_0")).clear();
    driver.findElement(By.id("text_languages_0")).sendKeys("Languages");
    driver.findElement(By.name("subtitles")).clear();
    driver.findElement(By.name("subtitles")).sendKeys("Subtitles");
    driver.findElement(By.name("audio")).clear();
    driver.findElement(By.name("audio")).sendKeys("Audio");
    driver.findElement(By.name("video")).clear();
    driver.findElement(By.name("video")).sendKeys("Video");
    driver.findElement(By.name("country")).clear();
    driver.findElement(By.name("country")).sendKeys("Country");
    driver.findElement(By.name("genres")).clear();
    driver.findElement(By.name("genres")).sendKeys("Genres");
    driver.findElement(By.name("director")).clear();
    driver.findElement(By.name("director")).sendKeys("Director");
    driver.findElement(By.name("writer")).clear();
    driver.findElement(By.name("writer")).sendKeys("Writer");
    driver.findElement(By.name("producer")).clear();
    driver.findElement(By.name("producer")).sendKeys("Producer");
    driver.findElement(By.name("music")).clear();
    driver.findElement(By.name("music")).sendKeys("Music");
    driver.findElement(By.name("cast")).clear();
    driver.findElement(By.name("cast")).sendKeys("Cast");
    driver.findElement(By.id("submit")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Log out")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to log out[\\s\\S]$"));
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
