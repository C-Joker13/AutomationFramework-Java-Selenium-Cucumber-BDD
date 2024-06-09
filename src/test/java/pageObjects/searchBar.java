package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchBar {

    public WebDriver driver;

    public searchBar(WebDriver driver) {
        this.driver = driver;
    }

    public void inputSearchBar(String searchText) {
        WebElement searchBar = driver.findElement(By.cssSelector("#APjFqb"));
        searchBar.clear();
        searchBar.sendKeys(searchText);
    }

    public void clickSearch() {
    	WebElement searchButton = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']"));
        searchButton.click();
    }

    public void clickChromeImageTab() {
        WebElement chromeImageTab = driver.findElement(By.xpath("//div[contains(@class, 'YmvwI') and contains(., 'Images')]"));
        chromeImageTab.click();
    }

    public boolean isImageTabSelected() {
        WebElement chromeImageTab = driver.findElement(By.xpath("//div[contains(@class, 'YmvwI') and contains(., 'Images')]"));
        String selectedAttribute = chromeImageTab.getAttribute("selected");
        return selectedAttribute != null;
    }
}

