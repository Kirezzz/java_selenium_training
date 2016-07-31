package ru.stqa.selenium;

import org.testng.annotations.*;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFilmSuccessfylly extends TestNgTestBase{

  @Test
  public void testFindFilmSuccessfylly() throws Exception {
	  
	login();  
	  
    //driver.get(baseUrl + "/php4dvd/#!/sort/name asc/");
    driver.findElement(By.id("q")).clear();
    
    List <WebElement> elements = driver.findElements(By.xpath("//*[@id='results']/a/div[starts-with(@id,'movie_')]"));
    
    driver.findElement(By.id("q")).sendKeys("MovieTitle");
    driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
    
  //ѕровер€ем, что все каверы стали невидимы во врем€ поиска
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfAllElements(elements));
    

  //ѕровер€ем, что нашелс€ нужный нам кавер
    new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class ='title' and text() = 'MovieTitle']")));

    logOut();
  
  }


}
