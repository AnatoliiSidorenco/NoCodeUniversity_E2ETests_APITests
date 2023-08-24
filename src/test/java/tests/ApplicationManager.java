package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    public WebDriver driver;
    String BASE_URL = "https://jere237.softr.app/";

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\EducationProg\\SeleniumChromeDriver116\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    public void stop() {
        driver.quit();
    }
}


// WebDriverManager.chromedriver().setup();


 /*   protected ChromeDriver driver;
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");
      driver = new ChromeDriver(options);*/