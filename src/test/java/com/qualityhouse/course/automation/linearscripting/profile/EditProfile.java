package com.qualityhouse.course.automation.linearscripting.profile;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditProfile {

    @Test
    public void editUserProfile1() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://acme.qualityhouse.com/build3/index.php");

        driver.findElement(By.cssSelector("a[href='index.php?page=login']")).click();

        // login with Student1 credentials
        driver.findElement(By.id("username")).sendKeys("student1");

        driver.findElement(By.name("userpass")).sendKeys("stpass1");

        driver.findElement(By.name("ses_login")).click();

        // navigate to Profile page
        driver.findElement(By.cssSelector("a[href='index.php?page=edit-profile']")).click();

        // modify details of Student1 profile
        driver.findElement(By.name("cEmail")).clear();
        driver.findElement(By.name("cEmail")).sendKeys("student1@example.com");

        driver.findElement(By.name("cName")).clear();
        driver.findElement(By.name("cName")).sendKeys("Student One");

        driver.findElement(By.name("cPhone")).clear();
        driver.findElement(By.name("cPhone")).sendKeys("+987654321");

        driver.findElement(By.name("cAddress")).clear();
        driver.findElement(By.name("cAddress")).sendKeys("Students Street 1\nStudents City");

        driver.findElement(By.cssSelector("input[type='submit'][value='Submit']")).click();

        Assert.assertEquals("", "Your profile was updated successfully!", driver.findElement(By.cssSelector("body b")).getText());

        driver.findElement(By.cssSelector("a[href='index.php?page=logout']")).click();

        driver.findElement(By.cssSelector("a.big-btn[href='index.php?ses_logout=1']")).click();

        driver.close();
    }

    @Test
    public void tcVerifyMandatoryFields() {
        // todo: Exercise no. 2 - Verify that mandatory fields do not accept empty values
        // hint: driver.switchTo().alert().dismiss();

    }
}
