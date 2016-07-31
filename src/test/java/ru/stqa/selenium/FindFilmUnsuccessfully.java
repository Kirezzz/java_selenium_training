package ru.stqa.selenium;

import java.util.List;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFilmUnsuccessfully extends TestNgTestBase {

	
  @Test
  public void testFindFilmUnsuccessfully() throws Exception {
	  
	login();
	  
    driver.findElement(By.id("q")).clear();
    
    List <WebElement> elements = driver.findElements(By.xpath("//*[@id='results']/a/div[starts-with(@id,'movie_')]"));
    
    driver.findElement(By.id("q")).sendKeys("TitleMovie2");
    driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
    
    //ѕровер€ем, что все каверы стали невидимы во врем€ поиска
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfAllElements(elements));
    
  
    //ѕровер€ем, что вывелось "No movies where found."
    new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='results']/div[text()='No movies where found.']")));
  
    logOut();
    
  }

}
