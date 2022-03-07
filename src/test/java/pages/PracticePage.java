package pages;

import base.SeleniumBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PracticePage extends SeleniumBase {
    WebDriver driver;

    public PracticePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//input[@name='radioButton'])[2]")
    WebElement radioButton;

    @FindBy(xpath = "(//input[@name='radioButton'])[3]")
    WebElement radioButton3;

    @FindBy(xpath = "(//input[@name='radioButton'])[1]")
    WebElement radioButton1;

    @FindBy(id = "autocomplete")
    WebElement country;

    @FindBy(id = "dropdown-class-example")
    WebElement selectOption;

    @FindBy(id = "checkBoxOption1")
    WebElement checkBox1;

    @FindBy(id = "checkBoxOption2")
    WebElement checkBox2;

    @FindBy(id = "openwindow")
    WebElement popupWind;

    @FindBy(xpath = "//a[@class= 'btn-style class1 class2']")
    WebElement openTab;

    @FindBy(id = "name")
    WebElement nameAlert;

    @FindBy(id = "alertbtn")
    WebElement alertBtn;

    @FindBy(id = "name")
    WebElement nameAlert2;

    @FindBy(id = "confirmbtn")
    WebElement confimAlert;

    @FindBy(css = "[id='product'] tbody tr td")
    List<WebElement> tableData;

    @FindBy(id = "displayed-text")
    private WebElement hidenText;

    @FindBy(id = "hide-textbox")
    private WebElement hideBtn;

    @FindBy(id = "show-textbox")
    private WebElement showText;


    @FindBy(id = "mousehover")
    private WebElement mouseHower;

    @FindBy(linkText = "Reload")
    private WebElement howerRelod;


    ////////////////////////////
    public void clickOnRadioBtn3() {
        radioButton3.click();

    }


    public void clickOnRadioBtn() {
        radioButton.click();
    }


    public void clickOnRadioBtn1() {
        radioButton1.click();
    }


    public void setCountry() {
        country.sendKeys("Armenia");
        country.click();
    }


    public void setSelectOption() {
        Select select = new Select(selectOption);
        select.selectByVisibleText("Option3");

    }


    public void setCheckBox1() {
        checkBox1.click();
    }


    public void setCheckBox2() {
        checkBox2.click();
    }


    public void setPopupWind() {
        popupWind.click();
        String parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> iterator = s.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();

            if (!parent.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                driver.close();
                driver.switchTo().window(parent);
            }
        }
    }


    public void setOpenNewTab() {

        openTab.click();

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));

    }


    public void setNameAlert() {
        nameAlert.sendKeys(" ALERT one");
    }


    public void setAlertBtn() {
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("Alert Accepting " + alertMessage);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        alert.accept();
    }


    public void setNameAlert2() {
        nameAlert2.sendKeys(" ALERT Two");
    }


    public void dSetAlertBtn() {
        confimAlert.click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("Alert Dismiss " + alertMessage);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        alert.dismiss();
    }


    private int getTbleItem(int rowindex, int columnIndex) {
        return 3 * (rowindex - 1) + columnIndex;
    }

    public String getTableDataContent(int rowIndex, int columnIndex) {
        int tdIndexToGet = getTbleItem(rowIndex, columnIndex);
        return tableData.get(tdIndexToGet).getText();
    }


    public void sendHiddenText() {
        hidenText.sendKeys("ACA QA Tigran");
    }


    public void setHideBtn() {
        hideBtn.click();
    }


    public void showHiddenText() {
        showText.click();
    }

    public void setMouseHower() {
        Actions actions = new Actions(driver);
        WebElement mousehover = driver.findElement(By.id("mousehover"));
        actions.moveToElement(mousehover).build().perform();
    }


    public void mouseHoverReload() {

        WebElement mouseHower = driver.findElement(By.linkText("Reload"));
        mouseHower.click();

        System.out.println("Reloaded and finished test ");
    }

    public void thanks(){
        System.out.println("THANKS VERY MUCH ");
    }

}







