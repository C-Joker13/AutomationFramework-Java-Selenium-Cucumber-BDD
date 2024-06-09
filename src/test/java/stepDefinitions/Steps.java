package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.searchBar;

public class Steps {
	
	public WebDriver driver;
	public searchBar sb;
	public Properties configProps;

	@Before
	public void setup() throws IOException{
		
		//Reading properties from config.Properties file
		configProps = new Properties();
		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProps.load(configPropFile);
		
		String brows = configProps.getProperty("browser");
		
		//Change browser value in the config.Properties to select the with which browser to run tests
		if(brows.equals("chrome")) {
			System.setProperty("webdriver.chromedriver.driver", configProps.getProperty("chromepath"));
	    	driver = new ChromeDriver();
		}
		else if(brows.equals("firefox")) {
			System.setProperty("webdriver.geckodriver.driver", configProps.getProperty("firefoxpath"));
	    	driver = new FirefoxDriver();
		}
    	
    
	}
	
    @Given("User starts Chrome browser")
    public void user_Start_Chrome() {	
    	sb = new searchBar(driver);
    }
    
    @And ("opens URL {string}")
    public void select_Chrome_tab(String url) {
    	driver.get(url);
    }
    
    @When ("I type {string} in search bar")
    public void type_in_search_bar(String text) {
    	sb.inputSearchBar(text);
    }
    
    @And ("I click Google Search button")
    public void click_google_search() {
    	sb.clickSearch();
    }
    
    @Then ("select Images tab")
    public void select_Chrome_tab() {
    	sb.clickChromeImageTab();
    }
    
    @And ("I can see selected Images tab")
    public void images_tab() {
    	Assert.assertTrue(sb.isImageTabSelected());
    }
    
    @After
    public void close_browser() {
    	driver.quit();
    }
}
