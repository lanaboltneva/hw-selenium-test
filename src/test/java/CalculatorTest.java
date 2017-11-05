import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
//import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorTest {

   private static WebDriver driver;

   @BeforeClass
   public static void start(){
       ChromeDriverManager.getInstance().setup();
       driver = new ChromeDriver();

       String currentDir = System.getProperty("user.dir");
       driver.get(currentDir + "/src/test/web_calc_html/calc.html");

   }

   @Before
   public void cleanup(){
       driver.findElement(By.xpath("//input[@value='C']")).click();
   }


    @Test
    public void add_test(){
        driver.findElement(By.xpath("//input[@value='8']")).click();
        driver.findElement(By.xpath("//input[@value='8']")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals( "110", driver.findElement(By.id("resultsbox")).getAttribute("value") );
    }


    @Test
    public void subtract_test(){
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='-']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='3']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals( "29", driver.findElement(By.id("resultsbox")).getAttribute("value") );
    }

    @Test
    public void multiply_test(){
        driver.findElement(By.xpath("//input[@value='3']")).click();
        driver.findElement(By.xpath("//input[@value='7']")).click();
        driver.findElement(By.xpath("//input[@value='x']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='3']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals( "851", driver.findElement(By.id("resultsbox")).getAttribute("value") );
    }

    @Test
    public void divide_test(){
        driver.findElement(By.xpath("//input[@value='6']")).click();
        driver.findElement(By.xpath("//input[@value='0']")).click();
        driver.findElement(By.xpath("//input[@value='/']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals( "4", driver.findElement(By.id("resultsbox")).getAttribute("value") );
    }

    @AfterClass
    public static void stop(){
        driver.quit();

    }

}
