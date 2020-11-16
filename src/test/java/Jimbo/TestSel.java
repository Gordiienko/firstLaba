package Jimbo;

import com.codeborne.selenide.Condition;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.*;

public class TestSel {
    By inputForms = By.xpath("//a[contains(text(),'Input Forms')]");
    By simpleFormDemo = By.xpath("//a[contains(text(),'Simple Form Demo')]");
    By checkboxDemo = By.xpath("//a[contains(text(),'Checkbox Demo')]");
    By radioButtonsDemo = By.xpath("//a[contains(text(),'Radio Buttons Demo')]");
    By selectDropdownList = By.xpath("//a[contains(text(),'Select Dropdown List')]");
    By byXpath = By.xpath("//form[@id='get-input']//button");
    By display = By.xpath("//span[@id='display']");
    By getTotal = By.xpath("//button[contains(text(),'Get Total')]");
    By displayValue = By.id("displayvalue");
    By option1 = By.xpath("//label[text()='Option 1']/input");
    By option3 = By.xpath("//label[text()='Option 3']/input");
    By groupRadioButtonsDemo = By.xpath("//label[text()='Male']/input");
    By age = By.xpath("//label[text()='15 to 50']");
    By getValues = By.xpath("//button[contains(text(),'Get values')]");
    By actualResult = By.xpath("//p");
    By select = By.id("select-demo");
    By actualResult2 = By.xpath("//p[text()='Day selected :- Friday']");
    By select2 = By.xpath("//select[@id='multi-select']");
    By getAllSelected = By.xpath("//button[@id='printAll']");
    By actualResult3 = By.xpath("//p[text()='Options selected are : Florida']");


    @Before
    public void First() {
        open("https://www.seleniumeasy.com/test/");
        $("#at-cv-lightbox-close").shouldBe(Condition.visible).waitUntil(Condition.visible, 20000).click();
    }

    @Test
    public void Test1() {
        String newMessage = "Hello, my name is";
        $(inputForms).shouldBe(Condition.visible).click();
        $(simpleFormDemo).shouldBe(Condition.visible).click();
        $("#user-message").shouldBe(Condition.visible).setValue("Hello, my name is");
        $(byXpath).shouldBe(Condition.visible).click();
        $(display).shouldBe(Condition.visible).shouldHave(Condition.text(newMessage));
    }

    @Test
    public void Test2() {
        String value1 = "10";
        String value2 = "20";
        $(inputForms).shouldBe(Condition.visible).click();
        $(simpleFormDemo).shouldBe(Condition.visible).click();
        $("#sum1").shouldBe(Condition.visible).setValue(value1);
        $("#sum2").shouldBe(Condition.visible).setValue(value2);
        $(getTotal).shouldBe(Condition.visible).click();
        $(displayValue).shouldBe(Condition.visible).shouldHave(Condition.text("30"));
    }
    @Test
    public  void Test3(){
        $(inputForms).shouldBe(Condition.visible).click();
        $(checkboxDemo).shouldBe(Condition.visible).click();
        $(option1).shouldBe(Condition.visible).click();
        $(option3).shouldBe(Condition.visible).click();
        $(option1).shouldBe(Condition.selected);
        $(option3).shouldBe(Condition.selected);
    }
    @Test
    public void Test4(){
        $(inputForms).shouldBe(Condition.visible).click();
        $(radioButtonsDemo).shouldBe(Condition.visible).click();
        $(groupRadioButtonsDemo).shouldBe(Condition.visible).click();
        $(age).shouldBe(Condition.visible).click();
        $(getValues).shouldBe(Condition.visible).click();
        $(actualResult).shouldBe(Condition.visible).shouldNotHave(Condition.text("Sex : Female Age group: 5 - 15"));
    }
    @Test
    public void Test5(){
        String newMessage = "Day selected :- Friday";
        $(inputForms).shouldBe(Condition.visible).click();
        $(selectDropdownList).shouldBe(Condition.visible).click();
        $(select).shouldBe(Condition.visible).selectOption("Friday");
        $(actualResult2).shouldBe(Condition.visible).shouldHave(Condition.text(newMessage));
    }
    @Test
    public void Test6(){
        String resultat = "Options selected are : Florida";
        $(inputForms).shouldBe(Condition.visible).click();
        $(selectDropdownList).shouldBe(Condition.visible).click();
        $(select2).shouldBe(Condition.visible).selectOption("New York","Florida");
        $(getAllSelected).shouldBe(Condition.visible).click();
        $(actualResult3).shouldBe(Condition.visible).shouldHave(Condition.text(resultat));

    }
}
