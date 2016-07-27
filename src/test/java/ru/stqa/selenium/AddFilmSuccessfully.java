package ru.stqa.selenium;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddFilmSuccessfully extends TestNgTestBase{
  private boolean acceptNextAlert = true;

  @Test
  public void testAddFilmSuccessfully() throws Exception {
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

    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.name("imdbid")).clear();
    driver.findElement(By.name("imdbid")).sendKeys("100500");
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Title");
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys("Also known as");
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("2011");
    driver.findElement(By.name("duration")).clear();
    driver.findElement(By.name("duration")).sendKeys("158");
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
    
   //Явное ожидание с проверкой, что все элементы подгрузились
    WebDriverWait await = new WebDriverWait(driver, 30);
    List <WebElement> coversAfter = await.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='results']/a/div[starts-with(@id,'movie_')]")));
    int ca = coversAfter.size();
    assertEquals(ca, cb + 1);//сравниваем кавер до и после
    
    
    driver.findElement(By.linkText("Log out")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to log out[\\s\\S]$"));
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
