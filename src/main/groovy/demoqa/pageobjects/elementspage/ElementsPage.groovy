package demoqa.pageobjects.elementspage

import demoqa.pageobjects.dynamicpropertiespage.DynamicPropertiesPage
import demoqa.pageobjects.uploadanddownloadpage.UploadAndDownloadPage
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import pagebase.pageobjects.AbstractPage

class ElementsPage extends AbstractPage {
    static url = '/elements'

    static content = {
        dynamicProperties { $(By.xpath("//span[text()='Dynamic Properties']")) }
        uploadAndDownload { $('div.show li:nth-of-type(8)') }
    }

    @Step("Go to `Dynamic Properties page`")
    DynamicPropertiesPage navigateToDynamicPropertiesPage() {
        logger.info("Navigating to `Dynamic properties` page")
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250)");
        dynamicProperties.click()
        browser.page(DynamicPropertiesPage)
    }

    @Step("Go to `Upload and download page`")
    UploadAndDownloadPage navigateToUploadAndDownloadPage() {
        logger.info("Navigating to `Upload and download` page")
        uploadAndDownload.click()
        browser.page(UploadAndDownloadPage)
    }
}
