package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTests {
    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().window().maximize(); //option 1
//        driver.manage().window().fullscreen(); //option2 fullscreen
//        driver.manage().window().setSize(new Dimension(375, 812)); //option3 for mobile testing

        driver.quit();
    }

    public void shiftingContentCount() {
        WebElement shiftingContent = driver.findElement(By.linkText("Shifting Content"));
        shiftingContent.click();
        shiftingContent.findElement(By.linkText("Example 1: Menu Element")).click();
        List<WebElement> menuElements = shiftingContent.findElements(By.tagName("a"));
        System.out.println(menuElements.size());
    }

    public void elementPractice() {
        List<WebElement> links =  driver.findElements(By.tagName("a")); //returns list of elements with that tagName (useful for counting)
        System.out.println(links.size());

//        WebElement notPresentElement = driver.findElement(By.linkText("Justin")); //returns NoSuchElementException
//        inputsLink.click();

        WebElement inputsLink = driver.findElement(By.linkText("Inputs")); //returns first element in DOM it finds with that link.
        inputsLink.click();

        System.out.println(driver.getTitle());
    }

    public static void main(String args[]){
        BaseTests test = new BaseTests();
        test.setUp();
//        test.shiftingContentCount();
        test.elementPractice();
    }


}
