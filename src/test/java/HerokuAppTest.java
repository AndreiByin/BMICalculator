import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HerokuAppTest {

    @Test
    public void addRemoveElements(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/webdrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.className("added-manually")).click();
        int a = driver.findElements(By.className("added-manually")).size();
        assertEquals(a,1,"Кол-во кнопок неверное");
        driver.quit();
    }
}
