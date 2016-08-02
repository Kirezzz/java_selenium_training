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
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  int cb = 0;
		  int ca = 0;

	//login();
    
    //подсчет каверов фильмов до добавления.
    try {
		List <WebElement> coversBefore = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='results']/a/div[starts-with(@id,'movie_')]")));
	    cb = coversBefore.size();
    	}
    catch (NoSuchElementException e) {
    	cb = 0; 
    };
    
   	driver.findElement(By.xpath("//div[@class = 'nocover' and @alt = 'MovieTitle']")).click();
   	driver.findElement(By.xpath("//img[@title = 'Remove']")).click();
   	assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));

    
    //Явное ожидание с проверкой, что все элементы подгрузились
    List <WebElement> coversAfter = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='results']/a/div[starts-with(@id,'movie_')]")));
    ca = coversAfter.size();
        
   //подсчет каверов фильмов после добавления.
    assertEquals(ca, cb - 1);
    
   //driver.quit();
 
  }


	
}
