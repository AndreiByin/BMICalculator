import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class BMICalculatorTest {


    @Test
    public void calculateKgCmsNormal() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("67");
        browser.findElement(By.name("ht")).sendKeys("175");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        new Select(browser.findElement(By.name("opt1"))).selectByValue("kilograms");

        assertEquals(category, "Your category is Normal", "Не совпадает" +
                "с ожидаемой категорией BMI");

        browser.quit();
    }

    @Test
    public void calculateKgCmsUnderweight() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("53");
        browser.findElement(By.name("ht")).sendKeys("170");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        new Select(browser.findElement(By.name("opt1"))).selectByValue("kilograms");

        assertEquals(category, "Your category is Underweight", "Не совпадает" +
                " с ожидаемой категорией BMI");

        browser.quit();
    }

    @Test
    public void calculateKgCmsOverweight() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("73");
        browser.findElement(By.name("ht")).sendKeys("170");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        new Select(browser.findElement(By.name("opt1"))).selectByValue("kilograms");

        assertEquals(category, "Your category is Overweight", "Не совпадает" +
                " с ожидаемой категорией BMI");

        browser.quit();
    }

    @Test
    public void letterInput() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("qwe");
        browser.findElement(By.name("ht")).sendKeys("qwe");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        new Select(browser.findElement(By.name("opt1"))).selectByValue("kilograms");

        assertEquals(category, "", "Результат не совпадает" +
                " с ожидаемым");

        browser.quit();
    }
}