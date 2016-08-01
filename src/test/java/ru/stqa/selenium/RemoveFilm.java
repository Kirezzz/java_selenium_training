package ru.stqa.selenium;


import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveFilm extends TestNgTestBase{

	  
	  @Test
  public void testRemoveFilm() throws Exception {

	//login();
    
    //подсчет каверов фильмов до добавления.
    WebDriverWait bwait = new WebDriverWait(driver, 30);
    List <WebElement> coversBefore = bwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='results']/a/div[starts-with(@id,'movie_')]")));
    int cb = coversBefore.size();
    
   	driver.findElement(By.xpath("//div[@class = 'nocover' and @alt = 'MovieTitle']")).click();
   	driver.findElement(By.xpath("//img[@title = 'Remove']")).click();
   	assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));

    
    //Явное ожидание с проверкой, что все элементы подгрузились
    List <WebElement> coversAfter = driver.findElements(By.xpath("//*[@id='results']/a/div[starts-with(@id,'movie_')]"));
    int ca = coversAfter.size();
        
   //подсчет каверов фильмов после добавления.
    assertEquals(ca, cb - 1);
    
    //driver.quit();
 
  }


	
}
