package ru.stqa.selenium;


import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveFilm extends TestNgTestBase{
  private boolean acceptNextAlert = true;


  @Test
  public void testRemoveFilm() throws Exception {
    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    
    //подсчет каверов фильмов до добавления.
    WebDriverWait bwait = new WebDriverWait(driver, 30);
    List <WebElement> coversBefore = bwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='results']/a/div[starts-with(@id,'movie_')]")));
    int cb = coversBefore.size();
    
    driver.findElement(By.cssSelector("div.nocover")).click();
    driver.findElement(By.cssSelector("img[alt=\"Remove\"]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    
    //Явное ожидание с проверкой, что все элементы подгрузились
    WebDriverWait await = new WebDriverWait(driver, 30);
    List <WebElement> coversAfter = await.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='results']/a/div[starts-with(@id,'movie_')]")));
    int ca = coversAfter.size();
        
   //подсчет каверов фильмов после добавления.
    assertEquals(ca, cb - 1);
    
    driver.quit();
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
