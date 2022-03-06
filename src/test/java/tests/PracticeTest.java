package tests;

import base.SeleniumBase;
import org.testng.annotations.Test;
import pages.PracticePage;

import static org.testng.Assert.*;

public class PracticeTest extends SeleniumBase {

    PracticePage practicePage;


    @Test
    public void verifyRadioBtnFunction() throws InterruptedException {
        practicePage = new PracticePage(driver);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        practicePage.clickOnRadioBtn();

        practicePage.clickOnRadioBtn3();
        practicePage.clickOnRadioBtn1();
        practicePage.setCountry();
        practicePage.setSelectOption();
        practicePage.setCheckBox1();
        practicePage.setCheckBox1();

        practicePage.setCheckBox2();
        practicePage.setCheckBox1();
        Thread.sleep(500);
        practicePage.setPopupWind();
        Thread.sleep(1000);
        practicePage.setOpenNewTab();
        practicePage.setNameAlert();
        practicePage.setAlertBtn();
        practicePage.setNameAlert2();
        practicePage.dSetAlertBtn();
        String expectedText = "Advanced Selenium Framework Pageobject, TestNG, Maven, Jenkins,C";
        String actualText = practicePage.getTableDataContent(9, 1);

        assertEquals(expectedText, actualText, "Texts doesn't matching -> " + expectedText + " doesn't matching " + actualText);
        practicePage.sendHiddenText();
        practicePage.setHideBtn();
        practicePage.showHiddenText();


    }
}
