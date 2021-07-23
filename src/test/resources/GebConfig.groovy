/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import geb.Browser
import geb.Page
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.safari.SafariDriver

driver = {
    boolean headless = false
    String browser = System.getProperty("BROWSER") ?: "chrome"

    switch (browser.toLowerCase()) {
        case "chrome":
            return new ChromeDriver(chromeOptions(headless))
        case "firefox":
            FirefoxOptions ffOptions = new FirefoxOptions()
            ffOptions.setHeadless(headless)
            WebDriverManager.firefoxdriver().setup()
            return new FirefoxDriver()
        case "safari":
            return new SafariDriver()
        case "remote":
            DesiredCapabilities cap = new DesiredCapabilities()
            cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions(headless))
            cap.setBrowserName("chrome")
            String hubAddress = System.getProperty("HUB_ADDRESS") ?: "http://localhost:4444/wd/hub"
            RemoteWebDriver driver = new RemoteWebDriver(new URL(hubAddress), cap)
            driver.setFileDetector(new LocalFileDetector())
            return driver
    }
}

static ChromeOptions chromeOptions(boolean headless) {
    String downloadFilepath = new File("download").getAbsolutePath()
    /* Disable the remember password dialog */
    ChromeOptions chromeOptions = new ChromeOptions()
    Map<String, Object> prefs = new HashMap<String, Object>()
    prefs.put("credentials_enable_service", false)
    prefs.put("profile.password_manager_enabled", false)

    if (headless) {
        System.setProperty("window-size", "2560,2048")
    }

    def winSize = System.getProperty("window-size")

    if (winSize && (winSize =~ /\d+,\d+/))
        chromeOptions.addArguments("--window-size=${winSize}")
    else {
        /* Default to maximized */
        chromeOptions.addArguments("--start-maximized")
    }

    prefs.put("download.default_directory", downloadFilepath)
    prefs.put("intl.accept_languages", "en-US")
    System.setProperty("webdriver.chrome.silentOutput", "true")
    chromeOptions.setExperimentalOption("prefs", prefs)
    chromeOptions.addArguments("ignore-certificate-errors")
    chromeOptions.setHeadless(headless)
    WebDriverManager.chromedriver().setup()
    return chromeOptions
}


baseUrl = "https://demoqa.com/"
