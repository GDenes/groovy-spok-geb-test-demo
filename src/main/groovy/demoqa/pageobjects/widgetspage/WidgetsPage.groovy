package demoqa.pageobjects.widgetspage

import demoqa.pageobjects.tooltipspage.ToolTipsPage
import geb.navigator.Navigator
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import pagebase.pageobjects.AbstractPage

class WidgetsPage extends AbstractPage {

    static url = '/widgets'

    static content = {
        toolTips { $(".show.element-list li:nth-of-type(7)") }
        body { $("body") }
    }

    @Step("Go to `Tool Tips page`")
    ToolTipsPage navigateToToolTipsPage() {
        logger.info("Navigating to `Tool Tips` page")
        JavascriptExecutor jse = (JavascriptExecutor) driver
        jse.executeScript("scroll(0, 250)")

        waitFor { toolTips.click() }
        browser.page(ToolTipsPage)
    }

}
