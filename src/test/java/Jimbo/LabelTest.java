package Jimbo;


import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
public class LabelTest {
    WebDriver driver;

    @Before
    public void Orig() {
        BasicConfigurator.configure();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='at-cv-lightbox-close']"))).click();

    }

    @Test
    public void Test1() {
        WebElement InputForms = driver.findElement(By.xpath("//a[contains(text(),'Input Forms')]"));
        InputForms.click();
        WebElement SimpleFormDemo = driver.findElement(By.xpath("//a[contains(text(),'Simple Form Demo')]"));
        SimpleFormDemo.click();
        WebElement EnterMessage = driver.findElement(By.id("user-message"));
        EnterMessage.sendKeys("Hello, my name is ");
        WebElement ShowMassage = driver.findElement(By.xpath("//form[@id='get-input']//button"));
        ShowMassage.click();
        String yourMessage = driver.findElement(By.xpath("//div[@id='user-message']//span[@id='display']")).getText();
        log.info(yourMessage);

        Assert.assertEquals("Hello, my name is", yourMessage);
    }

    @Test
    public void Test2() {
        int value1 = 10;
        int value2 = 20;
        int expectedValue = value1 + value2;
        WebElement InputForms = driver.findElement(By.xpath("//a[contains(text(),'Input Forms')]"));
        InputForms.click();
        WebElement SimpleFormDemo = driver.findElement(By.xpath("//a[contains(text(),'Simple Form Demo')]"));
        SimpleFormDemo.click();
        WebElement EnterMessage = driver.findElement(By.id("sum1"));
        EnterMessage.sendKeys(String.valueOf(value1));
        EnterMessage = driver.findElement(By.id("sum2"));
        EnterMessage.sendKeys(String.valueOf(value2));
        WebElement GetTotal = driver.findElement(By.xpath("//button[contains(text(),'Get Total')]"));
        GetTotal.click();
        String actualValue = driver.findElement(By.id("displayvalue")).getText();
        Assert.assertEquals(String.valueOf(expectedValue), actualValue);
    }

    @Test
    public void Test3() {

        WebElement InputForms = driver.findElement(By.xpath("//a[contains(text(),'Input Forms')]"));
        InputForms.click();
        WebElement CheckboxDemo = driver.findElement(By.xpath("//a[contains(text(),'Checkbox Demo')]"));
        CheckboxDemo.click();
        WebElement option1 = driver.findElement(By.xpath("//label[text()='Option 1']/input"));
        option1.click();
        WebElement option3 = driver.findElement(By.xpath("//label[text()='Option 3']/input"));
        option3.click();
        Assert.assertEquals(option1.isSelected(), option3.isSelected());
    }

    @Test
    public void Test4() {
        WebElement InputForms = driver.findElement(By.xpath("//a[contains(text(),'Input Forms')]"));
        InputForms.click();
        WebElement RadioButtonsDemo = driver.findElement(By.xpath("//a[contains(text(),'Radio Buttons Demo')]"));
        RadioButtonsDemo.click();
        WebElement groupRadioButtonsDemo = driver.findElement(By.xpath("//label[text()='Male']/input"));
        groupRadioButtonsDemo.click();
        WebElement value = driver.findElement(By.xpath("//label[text()='15 to 50']"));
        value.click();
        WebElement getValues = driver.findElement(By.xpath("//button[contains(text(),'Get values')]"));
        getValues.click();
        String actualResult = driver.findElement(By.xpath("//p")).getText();
        Assert.assertNotEquals("Sex : Female Age group: 5 - 15", actualResult);
    }

    @Test
    public void Test5() {

        WebElement InputForms = driver.findElement(By.xpath("//a[contains(text(),'Input Forms')]"));
        InputForms.click();
        WebElement selectDropdownList = driver.findElement(By.xpath("//a[contains(text(),'Select Dropdown List')]"));
        selectDropdownList.click();
        Select select = new Select(driver.findElement(By.xpath("//select[@id='select-demo']")));
        select.selectByVisibleText("Friday");
        String actualResult = driver.findElement(By.xpath("//p[text()='Day selected :- Friday']")).getText();
        Assert.assertEquals("Day selected :- Friday", actualResult);
    }

    @Test
    public void test6() {
        WebElement InputForms = driver.findElement(By.xpath("//a[contains(text(),'Input Forms')]"));
        InputForms.click();
        WebElement selectDropdownList = driver.findElement(By.xpath("//a[contains(text(),'Select Dropdown List')]"));
        selectDropdownList.click();
        Select select = new Select(driver.findElement(By.xpath("//select[@id='multi-select']")));
        select.selectByVisibleText("New York");
        select.selectByVisibleText("Florida");
        WebElement getAllSelected = driver.findElement(By.xpath("//button[@id='printAll']"));
        getAllSelected.click();
        String actualResult = driver.findElement(By.xpath("//p[text()='Options selected are : Florida']")).getText();
        Assert.assertEquals("Options selected are : Florida", actualResult);
    }

    @Test
    public void test7() {
        String expectedColor = "rgb(255,0,0)";
        WebElement InputForms = driver.findElement(By.xpath("//a[contains(text(),'Input Forms')]"));
        InputForms.click();
        WebElement AjaxFormSubmit = driver.findElement(By.xpath("//a[contains(text(),'Ajax Form Submit')]"));
        AjaxFormSubmit.click();
        WebElement submit = driver.findElement(By.id("btn-submit"));
        submit.click();
        Assert.assertEquals("rgb(255,0,0)", expectedColor);
    }

    @Test
    public void test8() {
        WebElement datePickers = driver.findElement(By.xpath("//a[text()='Date pickers']"));
        datePickers.click();
        WebElement bootstrapDatePicker = driver.findElement(By.xpath("//li[@style='display: list-item;']/a[text()='Bootstrap Date Picker']"));
        bootstrapDatePicker.click();
        WebElement selectDate = driver.findElement(By.xpath("//div[@class='input-group date']//i [@class='glyphicon glyphicon-th']"));
        selectDate.click();
        LocalDate yesterday = LocalDate.now().minusDays(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String expectedDate = yesterday.format(formatter);
        String actualDate = driver.findElement(By.xpath("//div[@class='input-group date']//input[@type='text']")).getAttribute("value");
        Assert.assertEquals(expectedDate, actualDate);


    }
}
